package com.example.ecomercestoreweek6.service;

import com.example.ecomercestoreweek6.DAO.UserDAO;
import com.example.ecomercestoreweek6.Utility.DatabaseConnection;
import com.example.ecomercestoreweek6.model.User;

import javax.servlet.Servlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("login-email");
            String password = request.getParameter("login-password");

            UserDAO udao = new UserDAO(DatabaseConnection.getConnection());
            User user = udao.userLogin(email,password);
            if (user != null) {
                request.getSession().setAttribute("auth", user);
//				System.out.print("user logged in");
                response.sendRedirect("index.jsp");
            } else {
                out.println("there is no user");
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
