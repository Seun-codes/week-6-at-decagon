package com.example.ecomercestoreweek6.service;

import com.example.ecomercestoreweek6.model.Carts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "QuantityServlet", value = "/quantity-inc-dec")
public class QuantityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            String action = request.getParameter("action");
            int id = Integer.parseInt(request.getParameter("id"));
            ArrayList<Carts> cart_list = (ArrayList<Carts>) request.getSession().getAttribute("cart-list");
            if (action != null && id >= 1) {
                if (action.equals("inc")) {
                    for (Carts c : cart_list) {
                        if (c.getId() == id) {
                            int quantity = c.getQuantity();
                            quantity++;
                            c.setQuantity(quantity);
                            response.sendRedirect("Cart.jsp");
                        }
                    }
                }
                if (action.equals("dec")) {
                    for (Carts c : cart_list) {
                        if (c.getId() == id && c.getQuantity() > 1) {
                            int quantity = c.getQuantity();
                            quantity--;
                            c.setQuantity(quantity);
                            break;
                        }
                    }
                    response.sendRedirect("Cart.jsp");
                }
            } else {
                response.sendRedirect("Cart.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
