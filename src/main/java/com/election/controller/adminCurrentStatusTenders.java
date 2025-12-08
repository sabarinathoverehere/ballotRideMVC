package com.election.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.TenderAssignmentViewBean;
import com.election.dao.TenderDao;

@WebServlet("/adminCurrentStatusTenders")
public class adminCurrentStatusTenders extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<TenderAssignmentViewBean> list = TenderDao.getAllAssignedTenders();
			request.setAttribute("tenders", list);
			request.getRequestDispatcher("admin/adminCurrentStatusView.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
