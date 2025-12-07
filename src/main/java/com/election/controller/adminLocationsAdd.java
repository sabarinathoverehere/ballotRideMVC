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

@WebServlet("/addLocations")
public class adminLocationsAdd extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    try {
	        System.out.println("AddLocations servlet called");
	        String locationName = request.getParameter("locationName");
	        System.out.println("Location name received: " + locationName);
	        
	        LocationBean newLocation = new LocationBean();
	        newLocation.setLocationName(locationName);
	        
	        boolean insertLocation = LocationDao.insertLocation(newLocation);
	        if(insertLocation) response.sendRedirect(request.getContextPath() + "/showLocations");
	    } catch(Exception e) {
	        System.out.println("Exception occurred: " + e.getMessage());
	        e.printStackTrace();
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, 
	                          "Error adding location: " + e.getMessage());
	    }
	}

}
