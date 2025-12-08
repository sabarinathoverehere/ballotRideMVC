package com.election.controller.owner;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.election.beans.DriverBean;
import com.election.beans.TenderBean;
import com.election.dao.DriverDao;
import com.election.dao.TenderDao;

@WebServlet("/viewOpenTenders")
public class OwnerViewTenders extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			Integer oid = (Integer) session.getAttribute("ownerId");
			int ownerId = oid;
			System.out.println("ownerId :" + ownerId);
			List<DriverBean> driversOwners = DriverDao.getOwnersDrivers(ownerId);
			if (driversOwners == null) {
			    System.out.println("Driver list is NULL");
			} else {
			    System.out.println("Driver list size = " + driversOwners.size());
			}
			request.setAttribute("DriverList", driversOwners);
			List<TenderBean> opentenders = TenderDao.getOpenTenders();
			request.setAttribute("opentenders", opentenders);
			request.getRequestDispatcher("owner/ownerViewTenders.jsp").forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
