package com.example.ecomercestoreweek6.service;

import com.example.ecomercestoreweek6.model.Carts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "RemoveFromCartServlet", value = "/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            String id = request.getParameter("id");
            if(id != null){
                ArrayList<Carts> cart_list =(ArrayList<Carts>) request.getSession().getAttribute("cart-list");
                if(cart_list !=null){
                    for(Carts cart : cart_list){
                        if(cart.getId() == Integer.parseInt(id)){
                            cart_list.remove(cart_list.indexOf(cart));
                            break;
                        }
                    }
                }
                response.sendRedirect("Cart.jsp");
            }else {
                response.sendRedirect("Cart.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
