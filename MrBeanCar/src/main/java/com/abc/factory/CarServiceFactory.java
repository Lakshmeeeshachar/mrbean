package com.abc.factory;

import com.abc.service.CarService;
import com.abc.service.CarServiceImpl;

public class CarServiceFactory {
	
	private static CarService carService;
	
	static {
		carService=new CarServiceImpl();
		
	}

	public static CarService getCarService() {
		return carService;
	}
}
