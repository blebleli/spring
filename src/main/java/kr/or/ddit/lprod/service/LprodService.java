package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.dao.LprodDaoInf;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

@Service("LprodService")
public class LprodService implements LprodServiceInf {
	@Override
	public List<LprodVo> getAllLprod() {
		LprodDaoInf lprodDao = new LprodDao();
		return lprodDao.getAllLprod();
	}

	@Override
	public Map<String, Object> getLprodPageList(Map<String, Integer> map) {
		LprodDaoInf lprodDao = new LprodDao();
		
		// 페이지 리스트 조회
		List<LprodVo> pageList = lprodDao.getLprodPageList(map);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pageList", pageList);

		//페이지 네비게이션 html 생성
		int page = map.get("page");	
		int pageSize = map.get("pageSize");
		
		//전체건수조회
		int totCnt = lprodDao.getLprodTotCnt();

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
		
		pageNaviStr.append("<li><a href=\"/lprodList?page="+prePage+
				"&pageSize="+pageSize+"\" aria-label=\"Previous\">"
				+ "<span aria-hidden=\"true\">&laquo;</span></a></li>");

		
	
		for(int i=1; i<=cnt; i++){
			String activeClass = "";
			if (i==page) 
				activeClass = "class=\"active\"";

			pageNaviStr.append("<li "+activeClass+"><a href=\"/lprodList?page="+i+
									 "&pageSize="+pageSize+"\">"+i+"</a></li>");
		}	
		
		
		pageNaviStr.append("<li><a href=\"/lprodList?page="+nextPage+
				"&pageSize="+pageSize+ "\"aria-label=\"Next\">"
				+ "<span aria-hidden=\"true\">&raquo;</span></a></li>");
		
		return pageNaviStr.toString();
	}


	
}
