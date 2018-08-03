package kr.or.ddit.ioc.dao;

import org.springframework.stereotype.Repository;

@Repository("iocDao") //id= iocDao 라는 뜻
public class IocDao implements IocDaoInf {

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return "sayHello";
	}

}
