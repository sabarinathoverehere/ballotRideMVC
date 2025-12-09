package com.election.controller.owner;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.dao.PaymentDao;
import com.election.dao.TenderDao;

@WebServlet("/closeTender")
public class closeCurrentTender extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
        	
            int tenderId = Integer.parseInt(request.getParameter("id"));
            
           
            
            // call DAO for closing tender
            if(TenderDao.closeTender(tenderId)) {
            	 
                // create payment record right after a tender is closed
                PaymentDao.createPaymentTender(tenderId);
                
                response.sendRedirect("closeTenders");
            }
           

        } catch (Exception e) {
            e.printStackTrace();
                 }
    }
}