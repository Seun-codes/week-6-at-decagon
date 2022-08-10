package com.example.ecomercestoreweek6.service;

import com.example.ecomercestoreweek6.DAO.UserDAO;
import com.example.ecomercestoreweek6.Utility.DatabaseConnection;
import com.example.ecomercestoreweek6.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "SignUpServlet", value = "/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("############ code got here");
        System.out.println(request.toString());

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String Firstname = request.getParameter("FirstName");
            String LastName = request.getParameter("LastName");
            String email = request.getParameter("Email");
            String password = request.getParameter("Password");
            String address = request.getParameter("Address");

            UserDAO udao = new UserDAO(DatabaseConnection.getConnection());
            User user = new User(Firstname, LastName, email, password, address);
            out.printf("########## user -> %s",user);
            udao.Register(user);
            response.sendRedirect("Login.jsp");

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }



    }
}
