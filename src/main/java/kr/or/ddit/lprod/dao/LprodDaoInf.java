package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.student.model.StudentVo;

public interface LprodDaoInf {
/**
 * 
 * Method   : getAllLprod 
 * 최초작성일  : 2018. 7. 11. 
 * 작성자 : PC06 
 * 변경이력 : 
 * @return 
 * Method 설명 : 모든 lprod 메서드를 가져온다
 */
	List<LprodVo> getAllLprod();
	
	/**
	 * 
	 * Method   : getStudentPageList 
	 * 최초작성일  : 2018. 7. 10. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param map
	 * @return 
	 * Method 설명 : 페이지 리스트 조회
	 */
	List<LprodVo> getLprodPageList(Map<String, Integer> map);
	
	
	/**
	 * 
	 * Method   : getLprodTotCnt 
	 * 최초작성일  : 2018. 7. 11. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 
	 */
	int getLprodTotCnt();
	
}
