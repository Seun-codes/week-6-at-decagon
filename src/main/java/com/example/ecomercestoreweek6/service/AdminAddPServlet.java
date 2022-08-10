package com.example.ecomercestoreweek6.service;

import com.example.ecomercestoreweek6.DAO.ProductDAO;
import com.example.ecomercestoreweek6.Utility.DatabaseConnection;
import com.example.ecomercestoreweek6.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminAddPServlet", value = "/AdminAddPServlet")
public class AdminAddPServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productCategory = request.getParameter("productCategory");
        double productPrice = Double.parseDouble(request.getParameter("ProductPrice"));
        String productName = request.getParameter("productName");
        int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
        String image = request.getParameter("image");
       // String available = request.getParameter("available");

//        System.out.println(price);
//        System.out.println(name);
        //System.out.println(productQuantity);

        ProductDAO productDao = null;
        try {
            productDao = new ProductDAO(DatabaseConnection.getConnection());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Product product = new Product(productCategory,productName,productPrice,productQuantity,image);
        if (productDao.addProduct(product)) {
            request.setAttribute("message", "Product added successfully");
            response.sendRedirect("ProductForm.jsp?msg=valid");

        }else {
            response.sendRedirect("ProductForm.jsp?msg=invalid");

        }

    }
}
