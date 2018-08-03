package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BoardDao implements BoardDaoInf {

	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	@Override
	public List<BoardVo> getAllBoards() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.getAllBoards");
		session.close();
		return boardList;
	}

	@Override
	public BoardVo getBoardById(int b_id) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardVo boardList = session.selectOne("board.getBoardById",b_id);
		session.close();
		return boardList;
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		SqlSession session = sqlSessionFactory.openSession();	
	    int updateCnt = session.update("board.updateBoard",boardVo);
	    session.commit();
		session.close();
		return updateCnt;
	}

	@Override
	public int insertBoard(BoardVo boardVo) {
		SqlSession session = sqlSessionFactory.openSession();	
	    int insertCnt = session.insert("board.insertBoard",boardVo);
	    session.commit();
		session.close();
		return insertCnt;
	}

}
