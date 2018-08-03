package kr.or.ddit.lprod.web;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.LprodServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lprod")
@Controller("LprodController")
public class LprodController {
	
	//처리
	@Resource(name="LprodService")
	private LprodServiceInf lprodService;
	
	//리스트 조회
	@RequestMapping("/list")
	public String detail(LprodVo vo, Model model){ //id값이 설정된 상태로 오게된다.
		
		List<LprodVo> lprodList = lprodService.getAllLprod();
		
		model.addAttribute("lprodList",lprodList);

		return"lprod/list";
	}
	
}
