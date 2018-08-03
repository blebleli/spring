package kr.or.ddit.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller("mvcController")
public class MvcController {

	//localhoset:8180 mvc/view
	//mvc 어노테이션을 테스트할 view
	
	@RequestMapping("/view")
	public String view(){
		return "mvc/view";
	}
	
}
