package kr.or.ddit.ioc.annotation;

import static org.junit.Assert.*;
import kr.or.ddit.ioc.placeholder.JdbcInfo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanTest {

	//spring container 생성(application-annotation.xml)
	
	private ApplicationContext context;

	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-annotation.xml");
	}
	@Test
	public void test() {
		/***Given***/
		//spring container 생성

		/***When***/
		//annotationBean DL
		AnnotationBean annotationBean = context.getBean("annotationBean", AnnotationBean.class);

		/***Then***/
		//name 속성 비교
		assertEquals("brown", annotationBean.getName());

	
	
	}

}
