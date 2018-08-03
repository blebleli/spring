package kr.or.ddit.lprod.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVo;

import org.junit.Before;
import org.junit.Test;

public class LprodDaoTest {

	private LprodDaoInf lprodDao;
	
	@Before
	public void setup(){
		lprodDao = new LprodDao();
	}
	
	@Test
	public void selectAllLprodTest() {
		List<LprodVo> lprodList = lprodDao.getAllLprod();
	
		assertEquals(9, lprodList.size());
	}

}
