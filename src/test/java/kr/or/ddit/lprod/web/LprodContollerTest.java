package kr.or.ddit.lprod.web;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.lprod.model.LprodVo;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/servlet-context.xml"})
@WebAppConfiguration
public class LprodContollerTest {

	@Resource
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();

	}
	
	@Test
	public void LprodListTest(){
		
//		MvcResult result =  mvc.perform(get("/lprod/list"));
//		
//		/***When***/
//		
//		/***Then***/
//		//viewname
//		//속성들(studentList, totCnt, pageNavi)
//		ModelAndView mav = result.getModelAndView();
//		
//		assertEquals("/lprod/list",mav.getViewName());
//		
//		
//		List<LprodVo> lprodList=  (List<LprodVo>) mav.getModel().get("lprodList");	//1페이지의 값을 가져와서 10개 , 
//	

	}
}


















