package kr.or.ddit.board.web;

import javax.annotation.Resource;

import kr.or.ddit.board.service.BoardServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping("/board")
//@Controller("boardController")
public class BoardController {

	//게시판 리스트 처리
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	//학생 상세 정보 조회
//	@RequestMapping("/detail")
//	public String detail(BoardVo vo, Model model){ //id값이 설정된 상태로 오게된다.
//		
//		List<BoardVo> boardList = boardService.getAllBoards();
//		
//		model.addAttribute("boardList",boardList);
//
//		return"board/boardList";
//	}
	
}
