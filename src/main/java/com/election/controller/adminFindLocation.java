package com.election.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.LocationBean;
import com.election.dao.LocationDao;

@WebServlet("/findLocation")
public class adminFindLocation extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		try {
			String id = request.getParameter("searchLocation");
			int locationId = Integer.parseInt(id);
			LocationBean locationBean = LocationDao.getLocationById(locationId);
			request.setAttribute("editedLocation", locationBean);
			request.getRequestDispatcher("admin/adminLocationUpdate.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
