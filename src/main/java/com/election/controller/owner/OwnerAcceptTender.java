package com.election.controller.owner;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.election.dao.TenderDao;

@WebServlet("/acceptTender")
public class OwnerAcceptTender extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		try {
			doGet(request,response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		try {
			HttpSession session = request.getSession(false);
			Integer oid = (Integer) session.getAttribute("ownerId");
			int ownerId = oid;
			String id = request.getParameter("tenderId");
			int tId = Integer.parseInt(id);
			String did = request.getParameter("driverId");
			int driverId = Integer.parseInt(did);
			
			boolean approved = TenderDao.updateStatus(tId,ownerId,driverId);
			if(approved)request.getRequestDispatcher("owner/ownerViewTenders.jsp").forward(request, response);


			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
