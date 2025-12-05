package com.election.controller.owner;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.election.beans.DriverBean;
import com.election.dao.DriverDao;

@WebServlet("/driversViewOwner")
public class DriversViewOwner extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<DriverBean> Drivers = DriverDao.getAllDrivers();
            request.setAttribute("DriversList", Drivers);
            request.getRequestDispatcher("owner/driversViewOwner.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

