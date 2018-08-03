package kr.or.ddit.lprod.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.dao.LprodDaoInf;
import kr.or.ddit.lprod.model.LprodVo;

import org.junit.Before;
import org.junit.Test;

public class LprodServiceTest {

	private LprodServiceInf lprodService;
	
	@Before
	public void setup(){
		lprodService = new LprodService();
	}
	
	@Test
	public void selectAllLprodTest() {
		List<LprodVo> lprodList = lprodService.getAllLprod();
	
		assertEquals(9, lprodList.size());
	}


}
