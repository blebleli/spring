package kr.or.ddit.ioc.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanTest {

	//before annotation을 통해 스프링 ioc 컨테이너 생성
	
	private ApplicationContext context;

	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-collection.xml");
	}
	
	@Test
	public void springContainerTest(){
		/***Given***/

		/***When***/
		/***Then***/
		assertNotNull(context);
		assertTrue(context.getBeanDefinitionCount()>=1);
	
	}
	
	
	@Test
	public void listTest() {
		/***Given***/
		//spring ioc 컨테이너 생성(before)

		/***When***/
		CollectionBean collection =  context.getBean("collectionBean",CollectionBean.class);
		//CollectionBean collection =  (CollectionBean)context.getBean("collectionBean");
		
		List lists= collection.getLists();
		//IocService iocDao1 = iocService.getIocDao() // prototype scope
		//IocService iocDao2 = iocService.getIocDao() // prototype scope
		
		
		/***Then***/
		assertEquals("sally",collection.getLists().get(2));
		assertEquals("cony",lists.get(1));
		//List.get(0) == brown
		//List.get(1) == sally
		//List.get(2) == cony

	}
	
	
	@Test 
	public void setTest(){
		/***Given***/

		/***When***/
		CollectionBean collection =  context.getBean("collectionBean",CollectionBean.class);
		
		Set sets = collection.getSets();
		Iterator<String> iter = sets.iterator();

		/***Then***/
		assertEquals("cony", iter.next());
		assertTrue(sets.contains("sally"));
	}
	
	@Test 
	public void mapTest(){
		/***Given***/

		/***When***/
		CollectionBean collection =  context.getBean("collectionBean",CollectionBean.class);
		
		Map maps = collection.getMap();

		/***Then***/
		assertEquals("brown", maps.get("ranger2"));

	}
	
	@Test 
	public void propTest(){
		/***Given***/

		/***When***/
		CollectionBean collection =  context.getBean("collectionBean",CollectionBean.class);
		
		Properties pros = collection.getPros();

		/***Then***/
		assertEquals("brown", pros.get("ranger2"));

	}
	
	
	
	

}
