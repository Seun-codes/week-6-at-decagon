package com.example.ecomercestoreweek6.service;

import com.example.ecomercestoreweek6.DAO.AdminDAO;
import com.example.ecomercestoreweek6.DAO.UserDAO;
import com.example.ecomercestoreweek6.Utility.DatabaseConnection;
import com.example.ecomercestoreweek6.model.Admin;
import com.example.ecomercestoreweek6.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AdminSignUpServlet", value = "/AdminSignUpServlet")
public class AdminSignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.toString());

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String email = request.getParameter("Email");
            String password = request.getParameter("password");
            String name = request.getParameter("Name");


            AdminDAO udao = new AdminDAO(DatabaseConnection.getConnection());
            Admin admin = new Admin(email,password,name);
            out.printf("########## user -> %s",admin);
            udao.Register(admin);
            response.sendRedirect("AdminLogin.jsp");

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
