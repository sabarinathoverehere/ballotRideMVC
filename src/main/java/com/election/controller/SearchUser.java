package com.election.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.UserBean;
import com.election.dao.UserDao;

@WebServlet("/findUser")
public class SearchUser extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException {
		try {
			String useId = request.getParameter("searchUser");
			int userId = Integer.parseInt(useId);
			UserBean UserBeanSearch = UserDao.getUserById(userId);
			request.setAttribute("userBeansSearch", UserBeanSearch);
			request.getRequestDispatcher("/admin/adminUserUpdate.jsp").forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
