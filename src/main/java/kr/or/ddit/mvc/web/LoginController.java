package kr.or.ddit.mvc.web;

import kr.or.ddit.user.model.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/login")
@Controller("loginController")
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("/view")
	public String hello(Model model){ //spring 에서 제공하는 model 객체

		return "login/login";

	}
	
	
	//로그인 처리
	//@RequestMapping("/loginProcess")
	public String loginProcess(UserVo userVo){
		
		//logger : userid, pass 찍기
		logger.debug("{}", userVo.getUserId()+" : "+userVo.getPassword());
		
		//정상접속 완료
		//WEB-INF/ view/ main.jsp
		return "main";
	}
	
	
	@RequestMapping("/loginProcess")
	public ModelAndView loginProcess2(UserVo userVo){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		
		mav.addObject("from", "modelAndView");
		
		//logger : userid, pass 찍기
		logger.debug("{}", "return ModelAndView");
		logger.debug("{}", userVo.getUserId()+" : "+userVo.getPassword());
		
		//정상접속 완료
		
		//WEB-INF/ view/ main.jsp
		return mav;
	}
}
