package com.abc.factory;

import com.abc.dao.CarDao;
import com.abc.dao.CarDaoImpl;

public class CarDaoFactory {

	public static CarDao carDao;
	
	static {
		carDao= new CarDaoImpl();	
}
  public static CarDao getCarDao() {
	  return carDao;
  }
}