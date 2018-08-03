package kr.or.ddit.ioc.placeholder;

public class JdbcInfo {
	private String url;
	private String driver;
	private String username;
	private String passward;
	
	
	//스프링 컨테이너로 부터 주입(DI)받는 방법
	//1.생성자
	//2.setter 
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	

	
	
}
