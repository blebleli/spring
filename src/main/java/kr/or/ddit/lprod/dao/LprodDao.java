package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class LprodDao implements LprodDaoInf{
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	
	@Override
	public List<LprodVo> getAllLprod() {
		SqlSession session = sqlSessionFactory.openSession();
		
		List<LprodVo> studentList = session.selectList("lprod.selectAllLprod");
		session.close();
		
		return studentList;
	}


	@Override
	public List<LprodVo> getLprodPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		
		List<LprodVo> lprodList = session.selectList("lprod.getLprodPageList",map);
		
		session.close();
		return lprodList;
	}


	@Override
	public int getLprodTotCnt() {
		SqlSession session = sqlSessionFactory.openSession();
	    int lprodCnt = session.selectOne("lprod.getLprodTotCnt");
		session.close();
		return lprodCnt;
	}



}
