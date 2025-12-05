package com.election.controller.owner;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.VehicleBean;
import com.election.dao.VehicleDao;

@WebServlet("/findVehicle")
public class OwnerVehicleFind extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		try {
			String findVehicle = request.getParameter("vehicleId");
			int vehicleId = Integer.parseInt(findVehicle);
			VehicleBean resultVehicle =VehicleDao.getVehicleById(vehicleId);
			request.setAttribute("resultOfSearch", resultVehicle);
			request.getRequestDispatcher("owner/ownerVehicleUpdate.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
