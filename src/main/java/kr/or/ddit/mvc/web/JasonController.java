package kr.or.ddit.mvc.web;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/json")
@Controller
public class JasonController {
	
	@ModelAttribute("rangers")
	public void rangers(Model model){
		List<String> list = new ArrayList<String>();
		list.add("brown");
		list.add("cony");
		list.add("sally");
		
		model.addAttribute("rangers",list);
		
		
	}
	
	@RequestMapping("/data")
	public String data(){
		
		return "jsonView"; 
		
		//문자열을 리턴하는데, viewresolver 가 순차적으로 적용한다.
		// 지금까지는 jsp이름을 리턴(폴더를 포함한 경로와 jsp파일이름)
		// 현재 viewResolver 설정상황
		//1. 두개의 viewResolver 가 등록
		// 1.1 order 0 : beanNameViewResolver
		// 1.2 order 1 :  internalResourceViewResolver
	}
	
	//ragers 리스트를 json 응답으로 생성(@ResponseBody)
	//json/data/responseBody
	//응답받는 데이터를 출력해본다.
	@RequestMapping("/data/responseBody")
	@ResponseBody
	public List<String> dataResponseBody(Model model){
		List<String> rangers = (List<String>) model.asMap().get("rangers");
		return rangers;
	}
	  
	//json 요청을 위한 view
	@RequestMapping("/requestView")
	public String requestView(){
		return "json/requestView";
	}
	
	
	
	@RequestMapping("/requestBody")
	@ResponseBody
	public List<String> requestBody(@RequestBody List<String> rangers){
//		for (String str : rangers) {
//			str = str + "_requestBody";
//		}
		for (int i = 0; i < rangers.size(); i++) {
			rangers.set(i, rangers.get(i)+ UUID.randomUUID().toString());
		}
		return rangers;
	}
	
	
	/*
	 클라이언트가 문자열을 요청
	 json 문자열을 해석해서 설정해줄것이다. 
	 받을 것을 루프돌면서, request body 라고 해주고 

	 */

	//json/excelData
	@RequestMapping("/excelData")
	public String excleData(){
		return "excelDownloadView";
	}
	
	
	//json/fileDown?fileName=bawi.png
	//업로드경로에 잇는 파일 아무거나 넣으면 된다.
	@RequestMapping("/fileDown")
	public String fileDown(@RequestParam("fileName") String fileName, Model model){
		model.addAttribute("fileName", fileName);
		return "fileDownloadView";
	}
	
	//rangers 리스트를 json 응답으로 생성
	// localhost://json/data
	

	
}
