package kr.or.ddit.ioc.type;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//spring 환경에서 junit 구동
//spring ioc 컨테이너 설정파일
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/ioc/application-type.xml"})
public class TypeTest {
	
	//iocVo
//	@Resource(name="iocVo")
//	private IocVo iocVo;

	//iocFormattingVo
	@Resource(name="iocFormattingVo")
	private IocFormattingVo iocFormattingVo;
	
	@Test
	public void IocFormattingVoTest(){
		/***Given***/
	
		/***When***/
		/***Then***/
		//name, regDt(yyyy-MM-dd), modDt(MM-dd-yyyy)
		assertEquals("brown", iocFormattingVo.getName());
		
		assertEquals("2018-07-30",
				new SimpleDateFormat("yyyy-MM-dd").format(iocFormattingVo.getRegDt()));
		
		assertEquals("07-30-2018", 
				new SimpleDateFormat("MM-dd-yyyy").format(iocFormattingVo.getModDt()));
		
		assertEquals(9999123, iocFormattingVo.getAmount());
	}
	
	
	
//	@Test
//
//	public void iocVotest() {
//		/***Given***/
//	
//		/***When***/
//		//설정파일(application-type.xml)에서 주입한 속성(name, regDt)가 정상적으로 주입되었는지 확인
//		assertEquals("brown", iocVo.getName());
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	
//		/***Then***/
//		//yyyy-mm-dd
//		
//		assertEquals("2018-07-30", 	sdf.format(iocVo.getRegDt()));
//	
//
//	}

}
