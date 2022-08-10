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

@WebServlet(name = "ServletLogIn", value = "/user-login")
public class ServletLogIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("Email");
            String password = request.getParameter("Password");

            UserDAO udao = new UserDAO(DatabaseConnection.getConnection());
            User user = udao.userLogin(email,password);
            if (user != null) {
                request.getSession().setAttribute("auth", user);
                System.out.print("user logged in ");

                response.sendRedirect("index.jsp");
            } else {
                out.println("there is no user");
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
