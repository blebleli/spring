package kr.or.ddit.mvc.web;

import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.exception.NoFileException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/exceptionController")
@Controller
public class ExceptionController {
	
	//ExceptionController/exception
	@RequestMapping("/exception")
	public String exceptionTest(){
		
		
		//예외를 강제로 발생시킨다.
		throw new ArithmeticException();
		
		//return "mvc/hello";
	}
	
	@ExceptionHandler({ArithmeticException.class})
	public String handleException(Throwable e , HttpServletResponse response){
		return "error/arith";
				
	}
	
	
	//noFileException(@ResponseStatus)
	//exceptionController/noFileException
	@RequestMapping("/noFileException")
	public String noFileException() throws NoFileException{
		
		try {
			throw new RuntimeException();
		} catch (Exception e) {
			throw new NoFileException();
		}

		
		//return "mvc/hello";
	}
	

}
