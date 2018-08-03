package kr.or.ddit.mvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import kr.or.ddit.mvc.model.ValidVo;
import kr.or.ddit.mvc.model.ValidVoValidator;
import kr.or.ddit.mvc.model.Validjsr303Vo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/valid")
@Controller
public class ValidatorController {
	
	@RequestMapping("/view")
	public String view(){
		return "mvc/valid/view";
	}
	
	
	//spring validator
	@RequestMapping("/submit")
	//BindingResult 는 vo객체 ""바로뒤에"" 생성되어야 한다.
	public String submit(ValidVo vaildVo, BindingResult errors , 
						 HttpServletRequest request,
						 Model model){
		
		new ValidVoValidator().validate(vaildVo, errors); //bind result
		
		if (errors.hasErrors()) {
			model.addAttribute("errorMsg","에러가 발생했습니다.");
		}
		
		model.addAttribute("vaildVo",vaildVo);
		
		return "mvc/valid/view";
	}
	
	//jsr303
	@RequestMapping("/submit/jsr303")
	//BindingResult 는 vo객체 ""바로뒤에"" 생성되어야 한다.
	public String submit2(@Valid Validjsr303Vo vaildJsr303Vo, BindingResult errors , 
						 HttpServletRequest request,
						 Model model){

		
		if (errors.hasErrors()) {
			model.addAttribute("errorMsg","에러가 발생했습니다.");
		}
		
		model.addAttribute("vaildJsr303Vo",vaildJsr303Vo);
		
		return "mvc/valid/view";
	}
	
	//spring validator
	@RequestMapping("/submit/valid")
	//BindingResult 는 vo객체 ""바로뒤에"" 생성되어야 한다.
	public String submitValid(@Valid ValidVo vaildVo, BindingResult errors , 
						 HttpServletRequest request,
						 Model model){
		
		if (errors.hasErrors()) {
			model.addAttribute("errorMsg","에러가 발생했습니다.");
		}
		
		model.addAttribute("vaildVo",vaildVo);
		
		return "mvc/valid/view";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setValidator(new ValidVoValidator());
	}
		
}
