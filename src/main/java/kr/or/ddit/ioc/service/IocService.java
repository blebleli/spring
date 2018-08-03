package kr.or.ddit.ioc.service;

import kr.or.ddit.ioc.dao.IocDaoInf;


public class IocService implements IocServiceInf {

	private IocDaoInf iocDao;
	

	public IocService() {}

	//생성자를 통한 주입
	
	//생성자 만들어준다..
	public IocService(IocDaoInf iocDao) {
		this.iocDao = iocDao;
	}
	
	public void setIocDao(IocDaoInf iocDao) {
		this.iocDao = iocDao;
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
