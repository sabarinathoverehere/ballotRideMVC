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

@WebServlet("/approveDrivers")
public class ApproveServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		try {
			String id = request.getParameter("id");
			int dId = Integer.parseInt(id);
			boolean approved = DriverDao.updateStatus(dId);
			if(approved) response.sendRedirect("admin/adminDriverEdit");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
