package kr.or.ddit.user.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserVo implements HttpSessionBindingListener{
	
	private Logger logger = LoggerFactory.getLogger(UserVo.class);
	
	private String userId;
	private String password;
	private String userNm;
	
	public UserVo(){}
	

	
	public Logger getLogger() {
		return logger;
	}



	public void setLogger(Logger logger) {
		this.logger = logger;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUserNm() {
		return userNm;
	}



	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}



	public boolean validataUser(String userId, String password){
		if (this.getUserId().equals(userId)&&this.getPassword().equals(password))
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", passward=" + password
				+ ", userNm=" + userNm + "]";
	}
	

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		//session객체에서 session.setAttribute("userVo",userVo_가 호출 되었을때
		logger.debug("httpSessionBinding valueBound : "+event.getName());
	
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		//session객체에서 session.removeAttribute("userVo",userVo_가 호출 되었을때
		logger.debug("httpSessionBinding valueUnBound : "+event.getName());
	}
	
	
	
}
