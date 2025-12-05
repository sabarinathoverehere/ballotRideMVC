package com.election.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.UserBean;
import com.election.dao.UserDao;

@WebServlet("/addUser")
public class AddUser extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException {
		try {
			String userName = request.getParameter("name");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			
			UserBean userBean = new UserBean();
			userBean.setUserName(userName);
			userBean.setUserPassword(password);
			userBean.setUserRole(role);
			
			boolean InsertUser = UserDao.insertUser(userBean);
			if(InsertUser) response.sendRedirect("admin/adminHome.jsp");

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
