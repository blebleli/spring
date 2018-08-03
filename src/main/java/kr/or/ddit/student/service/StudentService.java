package kr.or.ddit.student.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentService implements StudentServiceInf {
	
	@Resource(name="studentDao")
	private StudentDaoInf studentDao;
	
	//StudentDaoInf studentDao = new StudentDao();
	
	/**
	 * 
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 학생 정보를 조회한다.
	 */
	@Override
	public List<StudentVo> selectAllStudents() {
		return studentDao.selectAllStudents();
	}

	/**
	 * 
	 * Method   : selectStudentsById 
	 * 최초작성일  : 2018. 7. 10. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 특정학생을 id로 조회
	 */
	@Override
	public StudentVo selectStudentsById(int id) {
		return studentDao.selectStudentsById(id);
	}

	/**
	 * 
	 * Method   : selectStudentsCount 
	 * 최초작성일  : 2018. 7. 10. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 특정학생을 vo로 조회
	 */
	@Override
	public StudentVo selectStudentsByVo(StudentVo studentVo) {
		
		return studentDao.selectStudentsByVo(studentVo);
	}

	
	
	/**
	 * 
	 * Method   : getStudentPageList 
	 * 최초작성일  : 2018. 7. 10. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param map
	 * @return 
	 * Method 설명 : 학생 페이지 리스트 조회
	 */
	@Override
	public Map<String, Object> getStudentPageList(Map<String, Integer> map) {
	
	
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//학생 페이지 리스트 조회
		List<StudentVo> studentList = studentDao.getStudentPageList(map);
		resultMap.put("studentList", studentList);
		
		//전체학생건수조회
		int totCnt = studentDao.getStudentTotCnt();
		resultMap.put("totCnt", totCnt);

		//페이지 네비게이션 html 생성
		int page = map.get("page");	
		int pageSize = map.get("pageSize");

		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));

		return resultMap;
	}
	
	
	/**
	 * 
	 * Method   : makePageNavi 
	 * 최초작성일  : 2018. 7. 11. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param page
	 * @param pageSize
	 * @param totCnt
	 * @return 
	 * Method 설명 : 페이지 네비게이션 문자열 생성 
	 */
	private String makePageNavi(int page, int pageSize, int totCnt){
		int cnt = totCnt / pageSize;
		int mod = totCnt % pageSize;
		if(mod>0) cnt++;
		
		StringBuffer pageNaviStr = new StringBuffer();
		int prePage = page ==1?1:page-1;
		int nextPage = page == cnt?page:page+1;
		
		pageNaviStr.append("<li data-page=\""+prePage+"\" data-pageSize=\""+pageSize+"\"><a href=\"/student/tiles/list?page="+prePage+
				"&pageSize="+pageSize+"\" aria-label=\"Previous\">"
				+ "<span aria-hidden=\"true\">&laquo;</span></a></li>");

		
	
		for(int i=1; i<=cnt; i++){
			String activeClass = "";
			if (i==page) 
				activeClass = "class=\"active\"";

			pageNaviStr.append("<li data-page=\""+i+"\" data-pageSize=\""+pageSize+"\""+activeClass+"><a href=\"/student/tiles/list?page="+i+
									 "&pageSize="+pageSize+"\">"+i+"</a></li>");
		}	
		
		
		pageNaviStr.append("<li data-page=\""+nextPage+"\" data-pageSize=\""+pageSize+"\"><a href=\"/student/tiles/list?page="+nextPage+
				"&pageSize="+pageSize+ "\"aria-label=\"Next\">"
				+ "<span aria-hidden=\"true\">&raquo;</span></a></li>");
		
		return pageNaviStr.toString();
	}

	@Override
	public int studentUpdate(StudentVo studentVo) {
		// TODO Auto-generated method stub
		return studentDao.studentUpdate(studentVo);
	}
	

}
