package com.election.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.TenderBean;
import com.election.dao.TenderDao;

@WebServlet("/addTender")
public class AdminAddTender extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String locId = request.getParameter("locationId");
			int locationId = Integer.parseInt(locId);
			String dis = request.getParameter("distance");
			int distance = Integer.parseInt(dis);
			TenderBean tenderBean = new TenderBean();
			tenderBean.setLocationId(locationId);
			tenderBean.setTenderDistance(distance);
			
			boolean insertTender =TenderDao.insertTender(tenderBean);
			if(insertTender) response.sendRedirect(request.getContextPath() + "/showtenders");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
