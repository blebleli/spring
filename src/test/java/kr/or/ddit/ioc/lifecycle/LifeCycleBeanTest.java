package kr.or.ddit.ioc.lifecycle;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleBeanTest {

	private Logger logger = LoggerFactory.getLogger(LifeCycleBeanTest.class);
	
	
	//spring contaner 생성( before)
	private ApplicationContext context;
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-lifecycle.xml");
		
	}
	
	@Test
	public void beanLifeCycleTest() {
		LifeCycleBean lifeCycleBean = context.getBean("lifeCycleBean", LifeCycleBean.class);
		logger.debug("{}",lifeCycleBean);
	}
	
	

}
