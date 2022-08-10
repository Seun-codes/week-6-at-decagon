package com.example.ecomercestoreweek6.service;

import com.example.ecomercestoreweek6.DAO.AdminDAO;
import com.example.ecomercestoreweek6.Utility.DatabaseConnection;
import com.example.ecomercestoreweek6.model.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AdminLogInServlet", value = "/AdminLogInServlet")
public class AdminLogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            String email = request.getParameter("Email");
            String password = request.getParameter("Password");
            AdminDAO newAdmin = new AdminDAO(DatabaseConnection.getConnection());
            Admin admin = newAdmin.adminLogin(email,password);
            if (admin.getPassword() != null) {
                request.getSession().setAttribute("auth", admin);
                System.out.print("admin logged in");
                response.sendRedirect("Admin.jsp");
            } else {
                out.println("there is no user");
                response.sendRedirect("Login.jsp");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
