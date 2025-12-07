package com.election.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.LocationBean;
import com.election.dao.LocationDao;

@WebServlet("/updateLocation")
public class adminLocationUpdate extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		try {
			String locId = request.getParameter("locationId");
			int locationId = Integer.parseInt(locId);
			String locatioName = request.getParameter("locationName");
			
			LocationBean locationBean = new LocationBean();
			locationBean.setLocationId(locationId);
			locationBean.setLocationName(locatioName);
			
			boolean updateLoc = LocationDao.updateLocation(locationBean);
			if(updateLoc) response.sendRedirect(request.getContextPath() +"/showLocations");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
