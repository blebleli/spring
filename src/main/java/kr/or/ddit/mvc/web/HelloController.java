package kr.or.ddit.mvc.web;

import javax.annotation.Resource;

import kr.or.ddit.ioc.service.IocServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//주소mapping이 필요하다 
@RequestMapping("/hello")
@Controller
public class HelloController {
	
	@Resource(name="iocAnnotationService")
	private IocServiceInf iocService;
	
	
	//return : view 이름
	//localhost:8180/hello/view -- 메서드는 class 주소다음에 붙어서
	@RequestMapping("/view")
	public String hello(Model model){ //spring 에서 제공하는 model 객체
		//BoardService boardService = new BoardService();
		//hello() 매소드의 리턴 값을 hello.jsp 에서 출력
		String msg = iocService.hello();
		model.addAttribute("msg", msg);
			
		//forward  : 기본값 
		//redirect : hello
		return "hello";
		
		//prefix : /WEB-INF/views
		//suffix : .jsp
		//-> /WEB-INF/views/hello.jsp
	}
	
	
}
