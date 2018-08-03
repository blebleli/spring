package kr.or.ddit.ioc.Javaconfig;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.ioc.dao.IocDaoInf;
import kr.or.ddit.ioc.javaconfig.JavaAnnotationConfig;
import kr.or.ddit.ioc.service.IocServiceInf;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={JavaAnnotationConfig.class})
public class JavaAnnotationConfigTest {

	//iocDao, iocService
		@Resource(name="iocDao")
		private IocDaoInf iocDao;
		
		@Resource(name="iocAnnotationService")
		private IocServiceInf iocService;
		
		@Before
		public void setup(){
			
		}
		
		@Test
		public void javaConfigtest() {
			/***Given***/
			
			/***When***/

			
			/***Then***/
			
			assertEquals("sayHello", iocDao.hello());
			assertEquals("sayHello", iocService.hello());
			assertEquals("sayHello", iocService.getIocDao());
			
			//iocDao.hello() : "sayHello"
			//iocService.hello()  : "sayHello"
			//iocDao, iocService.getIocDao()
		}


}
