package kr.or.ddit.ioc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.ioc.dao.IocDaoInf;

@Service("iocAnnotationService")
public class IocAnnotationService implements IocServiceInf {

	@Resource(name="iocDao")
	private IocDaoInf iocDao;
	
	public IocAnnotationService(){}
	
	public void setIocDao(IocDaoInf iocDao) {
		//this.iocDao = iocDao;
	}
	
	public IocDaoInf getIocDao() {
		return iocDao;
	}
	
	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return iocDao.hello();
	}



}
