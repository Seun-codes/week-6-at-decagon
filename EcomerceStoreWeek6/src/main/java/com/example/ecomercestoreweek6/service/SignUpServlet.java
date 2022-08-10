package com.example.ecomercestoreweek6.service;

import com.example.ecomercestoreweek6.DAO.UserDAO;
import com.example.ecomercestoreweek6.Utility.DatabaseConnection;
import com.example.ecomercestoreweek6.model.User;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SignUpServlet", value = "/Sign-Up-Servlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("signup-email");
            String password = request.getParameter("signup-password");
            String address = request.getParameter("signup-address");
            String Firstname = request.getParameter("Firstname");
            String LastName = request.getParameter("LastName");

            UserDAO udao = new UserDAO(DatabaseConnection.getConnection());
            User user = new User(Firstname, LastName, email, password, address);
            udao.Register(user);
            out.println(user);
            response.sendRedirect("Login.jsp");

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
}