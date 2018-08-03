package kr.or.ddit.student.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;



/*
	spring controller test 설정
	1. spring을 junit에서 사용할 수 있도록 설정 :  Runwith(SpringJunit4ClassRunner.class)
	2. spring 설정 파일을 설정 : @ ContextConfiguration
	3. spring continer 가 웹 어플리케이션 컨텍스트로 생성될 수 있도록 설정 : @WebAppConfiguration
	4. 스프링 웹 환경과 동일하게 요청을 할 수 있도로 dispathcherServlet 역할을 하는 MockMvc 객체 생성
	 ==> Mockmvc를 생성하기 위해서는 WebApplicationContext 객체가 필요
	
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/servlet-context.xml"})
@WebAppConfiguration
public class StudentControllerTest {
	
	//@Autowired
	@Resource
	private WebApplicationContext context;
	
	//mockmvc
	private MockMvc mvc;
	
	@Before
	public void setup(){
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	//학생리스트 페이징 조회 테스트
	@Test
	public void studentListTest() throws Exception {
		/***Given***/
		MvcResult result = mvc.perform(get("/student/list")
									  .param("page", "1")
									  .param("pageSize", "10")).andReturn();

		/***When***/
		
		
		/***Then***/
		//viewname
		//속성들(studentList, totCnt, pageNavi)
		ModelAndView mav = result.getModelAndView();
		
		assertEquals("student/list",mav.getViewName());
		

		List<StudentVo> studentList=  (List<StudentVo>) mav.getModel().get("studentList");	//1페이지의 값을 가져와서 10개 , 
		assertEquals(10,studentList.size());
		assertTrue((Integer)mav.getModel().get("totCnt") > 10);
		assertNotNull(mav.getModel().get("pageNavi"));
	}
	
	
	// /student/detail url을 테스트
	@Test
	public void studentDetailTest() throws Exception {
		/***Given***/
		MvcResult result = mvc.perform(get("/student/detail")
									  .param("id", "1")).andReturn();

		/***When***/
		
		/***Then***/
		//viewname
		//속성들(studentList, totCnt, pageNavi)
		ModelAndView mav = result.getModelAndView();
		
		assertEquals("student/detail",mav.getViewName());
	

	}
	

}

















