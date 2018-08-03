package kr.or.ddit.mvc.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;

import kr.or.ddit.util.FileUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@SessionAttributes("boardList") //클래스에 붙인다. model 한번만 호출하고, session에 저장한다.
@RequestMapping("/mvc")
@Controller("mvcController")
public class MvcContorller {

	private Logger logger = LoggerFactory.getLogger(MvcContorller.class);
	
	
	@ModelAttribute("boardList")
	public List<String> boardList(){
		
		logger.debug("{}","boardList");
		
		//db에서 조회한 보드 리스트
		List<String> boardList = new ArrayList<String>();
		boardList.add("자유게시판");
		boardList.add("QnA");
		boardList.add("공지사항");
		return boardList;
	}
	
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(){ //spring 에서 제공하는 model 객체

		return "mvc/view";

	}
	
	@RequestMapping(value="/view2", method=RequestMethod.GET)
	public String view2(){ //spring 에서 제공하는 model 객체
		
		return "mvc/view2";

	}

	
	//@requestParam : 특정이름의 파라미터를 메소드 인자에서 받을 수 있다.

	@RequestMapping(value="/requestParam",method=RequestMethod.GET)
	public String requestParam(@RequestParam("userId") String param){
		logger.debug("{}", "param : "+ param);

		return "mvc/view";
	}
	
	//@PathVriable Test
	@RequestMapping(value="/pathvariable/25")
	public String pathVariable(@PathVariable("boardNum")String boardNum,Model model){

		model.addAttribute("boardNum", boardNum);
		
		return "mvc/view";
		
	}
	
	//multipart test를 view
	@RequestMapping("/multipart/view")
	public String multipartView(){
		return"mvc/multipartView";
	}
	
	//muptipart upload 처리
	@RequestMapping("/multipart/upload")
	public String multipartUpload(@RequestParam("userId")String userId,
								  @RequestPart("uploadFile")MultipartFile file,
								  FileVo files,
								  MultipartHttpServletRequest request,
								  Model model){
		
		
		for (MultipartFile f: files.getFiles()) {
			logger.debug("{}","f.getOriginalFilename() : "+f.getOriginalFilename());
		}
		
		logger.debug("{}","userId : "+ userId);
		model.addAttribute("userId : ",userId);
		logger.debug("{}","file.getName() : "+ file.getName());
		logger.debug("{}","	file.getOriginalFilename() : "+ file.getOriginalFilename());
	
		String path = FileUtil.fileUploadPath;
		String fileName = UUID.randomUUID().toString();
		File uploadFile = new File(path + File.separator +fileName);
		
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.debug("{}","userId" + request.getParameter("userId"));
	
		try {
			request.getPart("uploadFile");
			request.getParts();
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "mvc/multipartView";
	}
	
	
	

	
}
