package com.election.controller.owner;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.election.beans.PaymentBean;
import com.election.dao.PaymentDao;

@WebServlet("/ownerViewPayments")
public class OwnerViewPayments extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            int ownerId = (int) session.getAttribute("ownerId"); // assuming ownerId is stored in session
            List<PaymentBean> payments = PaymentDao.getPaymentsByOwner(ownerId);
            request.setAttribute("payments", payments);
            request.getRequestDispatcher("owner/ownerViewPayments.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
