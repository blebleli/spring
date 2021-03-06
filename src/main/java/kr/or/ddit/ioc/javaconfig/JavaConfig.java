package kr.or.ddit.ioc.javaconfig;

import kr.or.ddit.ioc.dao.IocDao;
import kr.or.ddit.ioc.service.IocService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//string config 임을 알려주는 annotation
@Configuration
public class JavaConfig {
	//<bean id="iocDao" class="kr.or.ddir.ioc.dao.IocDao"/>
	
	@Bean(name={"iocDao"})
	public IocDao getIocDao(){
		return new IocDao();
	}
	
	/*
	 * 
	 * <bean id="iocService class="kr.or.ddir.ioc.service.IocService>
	 * 		<property name="iocDao" ref="iocDao"/>
	 * </bean?
	 */
	
	@Bean(name={"iocService"})
	public IocService getIocService(){
		IocService iocService = new IocService();
		iocService.setIocDao(getIocDao());
		return iocService;
	}
}
