package com.election.controller.owner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.VehicleBean;
import com.election.dao.VehicleDao;

@WebServlet("/readVehicles")
public class ownerReadVehicles extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<VehicleBean> readVehicles = VehicleDao.getAllVehicles();
			request.setAttribute("readVehicles", readVehicles);
			request.getRequestDispatcher("owner/Ownervehicles.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
