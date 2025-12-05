package com.election.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.UserBean;
import com.election.dao.UserDao;

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException ,IOException { 
		try {
			String userId = request.getParameter("userId");
			int userID = Integer.parseInt(userId);
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			
			UserBean useBean = new UserBean();
			useBean.setUserId(userID);
			useBean.setUserName(name);
			useBean.setUserPassword(password);
			useBean.setUserRole(role);
			
			boolean userUpdate = UserDao.UpdateUser(useBean);
			if(userUpdate) {
				
				response.sendRedirect(request.getContextPath() + "/userView");
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
