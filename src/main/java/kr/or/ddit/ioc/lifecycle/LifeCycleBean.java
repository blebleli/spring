package kr.or.ddit.ioc.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class LifeCycleBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware{

	private Logger logger = LoggerFactory.getLogger(LifeCycleBean.class);
	
	@Override
	public void setBeanName(String name) {
		//중괄호 안에 name을 넣어라
		logger.isDebugEnabled();
		logger.debug("{}", "beanName : "+name);
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		LifeCycleBean lifeCycleBean = applicationContext.getBean("lifeCycleBean", LifeCycleBean.class);
		logger.debug("{}",lifeCycleBean);
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub
		
	}
	
}