package kr.or.ddit.ioc.Javaconfig;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import kr.or.ddit.ioc.annotation.AnnotationBean;
import kr.or.ddit.ioc.dao.IocDaoInf;
import kr.or.ddit.ioc.javaconfig.JavaConfig;
import kr.or.ddit.ioc.service.IocServiceInf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//juni 환경에서 container를 사용할 수 있도록 자동 설정
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={JavaConfig.class})
public class JavaconfigTest {

	//iocDao, iocService
	
	@Resource(name="iocDao")
	private IocDaoInf iocDao;
	
	@Resource(name="iocService")
	private IocServiceInf iocService;
	
	@Before
	public void setup(){
		
	}
	
	@Test
	public void javaConfigtest() {
		/***Given***/
		

		/***When***/
		//iocDao, iocService 가 정상적으로 주입 되었는지 확인
		//스프링 컨테이너에 DL --> @Resource(name = "스프링 빈") 을 통해 주입
	
		String a = iocDao.hello();
		/***Then***/
		
		assertEquals("sayHello", iocDao.hello());
		assertEquals("sayHello", iocService.hello());
		//assertEquals("sayHello", iocService.);
		
		//iocDao.hello() : "sayHello"
		//iocService.hello()  : "sayHello"
		//iocDao, iocService.getIocDao()
	}

}
