package com.election.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.TenderBean;
import com.election.dao.TenderDao;

@WebServlet("/showtenders")
public class AdminViewTenders extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		try {
			List<TenderBean> tenders = TenderDao.getAllTenders();
			request.setAttribute("tenders", tenders);
			request.getRequestDispatcher("admin/adminViewTenders.jsp").forward(request, response);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
