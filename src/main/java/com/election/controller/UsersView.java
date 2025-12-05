package com.election.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.UserBean;
import com.election.dao.UserDao;

@WebServlet("/userView")
public class UsersView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			doPost(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		try {
			List<UserBean> usersList = UserDao.getAllUsers();
			request.setAttribute("userViews", usersList);
			request.getRequestDispatcher("/admin/adminUserView.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
