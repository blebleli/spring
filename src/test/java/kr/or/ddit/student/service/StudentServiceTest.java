package kr.or.ddit.student.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;

public class StudentServiceTest {

	private StudentServiceInf studentService;
	
	//@before - test - after
	@Before
	public void setup(){
		studentService = new StudentService();
	}
	
	
	@Test
	public void selectAllStudents() {

		/***Given***/

		/***When***/
		List<StudentVo> stdList = studentService.selectAllStudents();
		for(StudentVo vo : stdList){
			System.out.println(vo);
		}
		
		/***Then***/
		assertEquals(25, stdList.size());
	}
	
	@Test
	public void selectStudentsById(){
		
		/***Given***/
		int id = 14;
		
		/***When***/
		StudentVo stdVo = studentService.selectStudentsById(id);
		
		/***Then***/
		assertEquals("한수정",stdVo.getName()) ;
	}
	
	
	@Test
	public void selectStudentsByVo(){
		
		/***Given***/
		StudentVo vo = new StudentVo();
		vo.setId(14);
		
		/***When***/
		StudentVo stdVo = studentService.selectStudentsByVo(vo);
		
		/***Then***/
		assertEquals("한수정",stdVo.getName()) ;
	}
	
	

	@Test
	public void getStudentPageList(){
		
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 3);
		map.put("pageSize", 10);
		
		/***When***/
		Map<String, Object> resultMap = studentService.getStudentPageList(map);
		
		//학생 페이지 리스트
		List<StudentVo> pageList = (List<StudentVo>)resultMap.get("pageList");
		
		//학생 전체 건수
		int totCnt = (int)resultMap.get("totCnt");
		
		/***Then***/
		assertEquals(5,pageList.size()) ;
		assertEquals(25,totCnt) ;
		
	}
	
	@Test
	public void calculatePageNavi(){
		/***Given***/
		int totCnt = 25;
		int pageSize = 10;

		int cnt = totCnt / pageSize;
		int mod = totCnt % pageSize;
		if(mod>0) cnt++;
		
		StringBuffer pageNaviStr = new StringBuffer();

		
		for(int i=1; i<=cnt; i++){
			pageNaviStr.append("<li><a href=\"#\">"+i+"</a></li>");

		}		

		
		/***Then***/

	}
	
	@Test
	public void studentUpdateTest(){
		/***Given***/
		StudentVo studentVo = new StudentVo();
		studentVo.setId(2);
		studentVo.setName("강병관");
		studentVo.setAddr1("대전광역시 중구 중앙로 76");
	    studentVo.setAddr2("영민빌딩 2층 대덕인재개발원");
	    studentVo.setZipcd("34940");
		studentVo.setPic("sally.png");
        studentVo.setPicpath("D:\\A_TeachingMaterial\\7.JspSpring\\fileUpload");
        studentVo.setPicname("sally.png");

		/***When***/
        int studentCnt = studentService.studentUpdate(studentVo);
		/***Then***/
        assertEquals(1,studentCnt );
	}
	
	
	

}
