package com.election.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.OwnerBean;
import com.election.dao.OwnerDao;

@WebServlet("/find")
public class SearchServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException {
				
		try {
			String id = request.getParameter("searchowner");
			int oid = Integer.parseInt(id);
			OwnerBean ownerBeanSearch = OwnerDao.getOwnerById(oid);
			request.setAttribute("ownerBean", ownerBeanSearch);
			RequestDispatcher rd = request.getRequestDispatcher("admin/editOwner.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
