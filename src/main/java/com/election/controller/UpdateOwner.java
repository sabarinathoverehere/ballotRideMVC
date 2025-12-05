package com.election.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.OwnerBean;
import com.election.dao.OwnerDao;

@WebServlet("/updateOwner")
public class UpdateOwner extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException {
		
		try {
			
			String ownerId = request.getParameter("oId");
			int oid =Integer.parseInt(ownerId);
			String userId = request.getParameter("userId");
			int userID = Integer.parseInt(userId);
			String ownerName = request.getParameter("oName");
			String ownerAddress = request.getParameter("oAddress");
			String ownerContact = request.getParameter("oContact");
			
			OwnerBean ownerBean = new OwnerBean();
			ownerBean.setoId(oid);
			ownerBean.setUserId(userID);
			ownerBean.setoName(ownerName);
			ownerBean.setoAddress(ownerAddress);
			ownerBean.setoContact(ownerContact);
			
			boolean updateOwner = OwnerDao.updateOwner(ownerBean);
			if(updateOwner) {
				response.sendRedirect("admin/adminOwner.jsp?v=0");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
