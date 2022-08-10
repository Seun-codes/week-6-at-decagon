package com.example.ecomercestoreweek6.service;

import com.example.ecomercestoreweek6.DAO.ProductDAO;
import com.example.ecomercestoreweek6.Utility.DatabaseConnection;
import com.example.ecomercestoreweek6.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddProductServlet", value = "/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("ProductForm");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String productName = request.getParameter("productName");
            String category = request.getParameter("productCategory");
            double price = Double.parseDouble(request.getParameter("productPrice"));
            int quantity = Integer.parseInt(request.getParameter("productQuantity"));
            String image = request.getParameter("image");

        Product product = new Product();
        product.setProductName(productName);
        product.setProductCategory(category);
        product.setProductPrice(price);
        product.setProductQuantity(quantity);
        product.setImage(image);
        ProductDAO productDAO = null;
        try {
            productDAO = new ProductDAO(DatabaseConnection.getConnection());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        productDAO.addProduct(product);
        request.setAttribute("Success","Product added successfully");
        request.getRequestDispatcher("ProductForm.jsp").forward(request,response);
    }
}

