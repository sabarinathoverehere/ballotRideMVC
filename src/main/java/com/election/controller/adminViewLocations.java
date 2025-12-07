package com.election.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.LocationBean;
import com.election.dao.LocationDao;

@WebServlet("/showLocations")
public class adminViewLocations extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		try {
			List<LocationBean> locBeans = LocationDao.getAllLocations();
			request.setAttribute("allLocations", locBeans);
			 System.out.println("inside show");
			request.getRequestDispatcher("admin/adminViewLocations.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
