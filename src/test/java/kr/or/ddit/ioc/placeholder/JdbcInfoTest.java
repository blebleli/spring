package kr.or.ddit.ioc.placeholder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcInfoTest {

	private ApplicationContext context;
	
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-placeholder.xml");
	
	}
	
	@Test
	public void placeholderTest() {
		/***Given***/
		

		/***When***/
		//jdbcInfo bean DL
		JdbcInfo jdbcInfo = context.getBean("jdbcInfo",JdbcInfo.class);
		
		/***Then***/
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe", jdbcInfo.getUrl());
		assertEquals("oracle.jdbc.driver.OracleDriver", jdbcInfo.getDriver());
		assertEquals("pc06", jdbcInfo.getUsername());
		assertEquals("java", jdbcInfo.getPassward());

	}

}
