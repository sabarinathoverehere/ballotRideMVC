package com.election.controller.owner;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.VehicleBean;
import com.election.dao.VehicleDao;

@WebServlet("/updateVehicle")
public class OwnerUpdateVehicle extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		try {
			String vid = request.getParameter("vehicleId");
			String oid = request.getParameter("ownerId");

			String vehicleNumber = request.getParameter("vehiclenumber");
			String vehicleType = request.getParameter("vehicleType");
						
			int OwnerId = Integer.parseInt(oid);
			int vehicleId = Integer.parseInt(vid);
			
			VehicleBean vehicleBean = new VehicleBean();
			vehicleBean.setVehicleId(vehicleId);
			vehicleBean.setOwnerId(OwnerId);
			vehicleBean.setVehicleNo(vehicleNumber);
			vehicleBean.setVehicleType(vehicleType);
			
			boolean updateVehicle = VehicleDao.updateVehicle(vehicleBean);
			if(updateVehicle)  response.sendRedirect(request.getContextPath() + "/readVehicles");

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
