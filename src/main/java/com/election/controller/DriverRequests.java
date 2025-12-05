package com.election.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.DriverBean;
import com.election.dao.DriverDao;

@WebServlet("/driverReqs")
public class DriverRequests extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		try {
			List<DriverBean> drivers = DriverDao.getAllDrivers();
			request.setAttribute("drivers", drivers);
			request.getRequestDispatcher("admin/adminDriverEdit.jsp").forward(request,response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
