package com.abc.dao;

import java.util.List;

import com.abc.dto.Car;

public interface CarDao {
	
	public String save(Car car);
	public Car findById(String cid);
	public String deleteById(String cid);
	public String update(Car car);
	
	

}
