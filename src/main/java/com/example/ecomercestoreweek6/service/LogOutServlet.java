package com.example.ecomercestoreweek6.service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogOutServlet", value = "/LogOutServlet")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try(PrintWriter out = response.getWriter()){
            if (request.getSession().getAttribute("auth") != null){
                request.getSession().removeAttribute("auth");

                response.sendRedirect("Login.jsp");
                System.out.println("Logged out");
            }else{
                response.sendRedirect("index.jsp");
                out.println("how are you");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
