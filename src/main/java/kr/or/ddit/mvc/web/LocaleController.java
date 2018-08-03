package kr.or.ddit.mvc.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/locale")
@Controller
public class LocaleController {
	
	
	//국제화 코드를 담을 map을 생성하는 model attribute 생성
//	<option value="ko">한국어</option>
//	<option value="ja">日本語</option>
//	<option value="en">English</option>
//	jsp화면에서 하드코딩하는것이 아니라 로직만들기 
	
	
	//locale/view
	@RequestMapping("/view")
	public String view(){
		return "locale/view"; 
	
	}

	@ModelAttribute("localeMap")
	public Map<String,String> localeMap(){
		 Map<String,String> localeMap =new HashMap<String, String>();
		 localeMap.put("ko", "한국어");
		 localeMap.put("en", "English");
		 localeMap.put("ja", "日本語");
		 return localeMap;
	}
	
	
	
	
	
	/*
	 어떤 view resolver 에서 처리될지를 결정  :  servlet-content.xml에 
	 설정한 view resolver 의 우선수위에 따라 결정
	 				설정파일을 보고 우선순위를해석할 수 있어야한다. 
	 
	 
	 우리가 설정한 상황
	 beanNameViewResolver : priority 1
	 tilesViewResolver : priority 2
	 internalResourceViewResolver : priority 3
	 
	 
	 view 이름으로 "locale/view"를 controller 에서 리턴한 경우 
	 1. beanNameViewResolver 에 의해 스프링 bean 중 
	    이름이"locale/view"를 갖는 view가 등록되었는지 확인
	    	--> bean 이 존재하지 않음 --> 다음 viewResolver 로 이동
	   * jasonView, excelDownloadView, fileDownloadView
	 
	 2.tilesViewResolver 를 통해 tiles-config.xml 에 설정된 defination name 중
	   "locale/view 와 일치하는 definition 이 존재하는지 확인
	 		--> name 일치하는 definition 존재하지 않음 --> 다음 viewResolver로 이동
	 
	 3.internalResourceViewResolver
	   internalResourceViewResolver 는 해당 리소스가 존재하는지 여부를 확인하지 않고
	   prefix +viewName +surfix로 forward 처리함
	 		--> viewName 에 해당하는 리소스가 없을 경우 404에러
	 				
	 */
	
}
