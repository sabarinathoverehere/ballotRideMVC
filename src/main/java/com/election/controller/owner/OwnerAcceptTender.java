package com.election.controller.owner;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.dao.TenderDao;

@WebServlet("/acceptTender")
public class OwnerAcceptTender extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		try {
			String id = request.getParameter("id");
			int tId = Integer.parseInt(id);
			boolean approved = TenderDao.updateStatus(tId);
			if(approved) response.sendRedirect("admin/adminDriverEdit");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
