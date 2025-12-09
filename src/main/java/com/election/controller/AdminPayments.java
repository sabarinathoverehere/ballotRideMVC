package com.election.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.PaymentBean;
import com.election.dao.PaymentDao;

@WebServlet("/payments")
public class AdminPayments extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		
		try {
			List<PaymentBean> payments = PaymentDao.getAllPayemnts();
			request.setAttribute("payments", payments);
			request.getRequestDispatcher("admin/adminViewPayments.jsp").forward(request, response);
		}catch(Exception e) {
			
		}
		
	}

}
