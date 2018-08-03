package kr.or.ddit.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.model.BoardVo;

@Service("boardService")
public class BoardService implements BoardServiceInf{

	BoardDao boardDao = new BoardDao();
	
	@Override
	public List<BoardVo> getAllBoards() {
		// TODO Auto-generated method stub
		return boardDao.getAllBoards();
	}

	@Override
	public BoardVo getBoardById(int b_id) {
		// TODO Auto-generated method stub
		return boardDao.getBoardById(b_id);
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return boardDao.updateBoard(boardVo);
	}

	@Override
	public int insertBoard(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return boardDao.insertBoard(boardVo);
	}

}
