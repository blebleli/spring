package kr.or.ddit.ioc.service;

import kr.or.ddit.ioc.dao.IocDaoInf;



public interface IocServiceInf {
	
	String hello();

	IocDaoInf getIocDao();
	void setIocDao(IocDaoInf iocDao);
	
}
