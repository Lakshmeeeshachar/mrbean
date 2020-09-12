package com.abc.controller;

import java.io.IOException;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sound.sampled.LineListener;

import com.abc.dto.Car;
import com.abc.factory.CarServiceFactory;
import com.abc.service.CarService;
import com.mysql.cj.x.protobuf.MysqlxExpr.ColumnIdentifier;

public class CarController extends HttpServlet{
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String action = request.getParameter("action");
		
//		module for adding record
	              if (action.equalsIgnoreCase("ADD")) {
	            		// Took the data from the client
	  				String cid = request.getParameter("cid");
	  				String company = request.getParameter("company");
	  				String model = request.getParameter("model");
	  				String dateofpurchase = request.getParameter("dateofpurchase");
	  				String price = request.getParameter("price");
	  				String enginecapacity = request.getParameter("enginecapacity");
	  				String licenceplatenumber = request.getParameter("licenceplatenumber");
	  				String seatingcapacity = request.getParameter("seatingcapacity");
	      
	  				// Create a student object use DTO pattern to transfer the data
	  			      
	  				 Car car=new Car();  				
	  				  car.setCid(cid);
	  				  car.setCompany(company);
	  				  car.setModel(model);
	  				  car.setDateofpurchase(dateofpurchase);
	  				  car.setPrice(price);
	  				  car.setEnginecapacity(enginecapacity);
	  				  car.setLicenceplatenumber(licenceplatenumber);
	  				  car.setSeatingcapacity(seatingcapacity);
	  		  
	  			       //Use Factory Design patter to the StudentService object
	  				  
	  				  
	  				
	  				 CarService carService= CarServiceFactory.getCarService(); 
	  					  String status =carService.save(car);
	  					  RequestDispatcher requestDispatcher = null;
	  					  if(status.equals("success")) {
	  							requestDispatcher = request.getRequestDispatcher("success.html");
	  							requestDispatcher.forward(request, response);
	  			  
	  					  }
	  					  if(status.equals("failure")) {
	  						  
	  						  requestDispatcher = request.getRequestDispatcher("failure.html");
	  							requestDispatcher.forward(request, response);
	  					  }
	  					  if (status.equals("alreadyExisted")) {
	  							requestDispatcher = request.getRequestDispatcher("existed.html");
	  							requestDispatcher.forward(request, response);
	  						}
					      }
	               
	              
	              if (action.equalsIgnoreCase("READ")) {
	            	  
	            		// Collect student id(cid) from the client
	      			String cid = request.getParameter("cid");
	      			 CarService carService= CarServiceFactory.getCarService();
	  			     	Car car   =	carService.findById(cid);
	      			
	      			
	      		
  				// Based on the student object send the response to the client
  					RequestDispatcher requestDispatcher = null;
  					if (car == null) {
  						requestDispatcher = request.getRequestDispatcher("notexisted.html");
  						requestDispatcher.forward(request, response);

  					} else {

  						// Keep the data in request object and redirect it to JSP page  
  						request.setAttribute("car", car);
  						requestDispatcher = request.getRequestDispatcher("displayRecord.jsp");
  						requestDispatcher.forward(request, response);
                     }
	              }
	           
	              
	              // Module for Deleting a student Record  
	              
	              if (action.equalsIgnoreCase("DELETE")) {
	            	  
	            		// Collect the data from the client                                             	
	      			String cid = request.getParameter("cid");
	      			
	      		// Use Factory Design pattern to the StudentService object
	      			
	      			CarService carService= CarServiceFactory.getCarService();
  			     	String status   =	carService.deleteById(cid);
	  			     	
	  			   // Based on status process the information to the client
	  					RequestDispatcher requestDispatcher = null;
	  					if (status.equals("success")) {
	  						requestDispatcher = request.getRequestDispatcher("success.html");
	  						requestDispatcher.forward(request, response);

	  					}
	  					if (status.equals("notexisted")) {
	  						requestDispatcher = request.getRequestDispatcher("notexisted.html");
	  						requestDispatcher.forward(request, response);
	  					}
	  					
	  					if (status.equals("failure")) {

	  						requestDispatcher = request.getRequestDispatcher("failure.html");
	  						requestDispatcher.forward(request, response);
	  					}
	              }
	              
	              
	              if (action.equalsIgnoreCase("update")) {
	            	  String cid = request.getParameter("cid");
	            	// Use Factory Design pattern to the StudentService object
	            		CarService carService= CarServiceFactory.getCarService();
	            		Car car=carService.findById(cid);
	            		RequestDispatcher requestDispatcher = null; 
	            		if(car==null) {
	            			requestDispatcher = request.getRequestDispatcher("notexisted.html");
	  						requestDispatcher.forward(request, response);
	            		}else {
	            			
	            			// Keep the data in request object and redirect it to JSP page
	  						request.setAttribute("car", car);
	  						requestDispatcher = request.getRequestDispatcher("editRecord.jsp");
	  						requestDispatcher.forward(request, response);
	            		}
	           }
	              
	            	  
	              if (action.equalsIgnoreCase("edit")) {
	            	// Took the data from the client
		  				String cid = request.getParameter("cid");
		  				String company = request.getParameter("company");
		  				String model = request.getParameter("model");
		  				String dateofpurchase = request.getParameter("dateofpurchase");
		  				String price = request.getParameter("price");
		  				String enginecapacity = request.getParameter("enginecapacity");
		  				String licenceplatenumber = request.getParameter("licenceplatenumber");
		  				String seatingcapacity = request.getParameter("seatingcapacity");
		      
		  				// Create a student object use DTO pattern to transfer the data
		  			      
		  				 Car car=new Car();  				
		  				  car.setCid(cid);
		  				  car.setCompany(company);
		  				  car.setModel(model);
		  				  car.setDateofpurchase(dateofpurchase);
		  				  car.setPrice(price);
		  				  car.setEnginecapacity(enginecapacity);
		  				  car.setLicenceplatenumber(licenceplatenumber);
		  				  car.setSeatingcapacity(seatingcapacity);
		  		  
		  			       //Use Factory Design patter to the StudentService object
		  				 CarService carService= CarServiceFactory.getCarService(); 
		  				String status =carService.update(car);
		  				
		  				// Based on status process the information to the client
		  				RequestDispatcher requestDispatcher = null;
		  				if (status.equals("success")) {
		  					requestDispatcher = request.getRequestDispatcher("success.html");
		  					requestDispatcher.forward(request, response);
		  				}
		  				if (status.equals("failure")) {
		  					requestDispatcher = request.getRequestDispatcher("failure.html");
		  					requestDispatcher.forward(request, response);
		  				}
	            	  
	              }
	              
	              
	              
	           
	              

	            	  
	           
	              
	 }

}

