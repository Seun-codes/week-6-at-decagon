<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.example.ecomercestoreweek6.model.User" %>
<%@ page import="com.example.ecomercestoreweek6.constants.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.ecomercestoreweek6.DAO.ProductDAO" %>
<%@ page import="com.example.ecomercestoreweek6.Utility.DatabaseConnection" %>
<%@ page import="com.example.ecomercestoreweek6.model.Carts" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>


<%
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("person", auth);
    }
        ArrayList<Carts> cart_list = (ArrayList<Carts>) session.getAttribute("cart-list");
        List<Carts> cartProduct = null;
        if (cart_list != null) {
            ProductDAO pDao = new ProductDAO(DatabaseConnection.getConnection());
            cartProduct = pDao.getCartProducts(cart_list);
            double total = pDao.getTotalCartPrice(cart_list);
            request.setAttribute("total", total);
            request.setAttribute("cart_list", cart_list);
        }

%>
<html>
<head>
    <title>Cart</title>
    <%@include file="WEB-INF/includes/head.jsp"%>
    <style type="text/css">

        .table tbody td{
            vertical-align: middle;
        }
        .btn-incre, .btn-decre{
            box-shadow: none;
            font-size: 25px;
        }
    </style>
</head>
<body>
<%@include file="WEB-INF/includes/NavBar.jsp"%>
<div class="container my-3">
    <div class="d-flex py-3"><h3>Total Price: # ${(total>0)?dcf.format(total):0} </h3> <a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a></div>
    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Category</th>
            <th scope="col">Price</th>
            <th scope="col">Quantity</th>
            <th scope="col">Cancel</th>
        </tr>
        </thead>
        <tbody>
      <%
            if (cart_list != null) {
                for (Carts c : cartProduct) {
      %>
        <tr>
            <td><%=c.getProductName()%></td>
            <td><%=c.getProductCategory()%></td>
            <td><%= dcf.format(c.getProductPrice())%></td>
            <td>
                <form action="AddToCartServlet" method="post" class="form-inline">
                    <input type="hidden" name="id" value="<%= c.getId()%>" class="form-input">
                    <div class="form-group d-flex justify-content-between">
                        <a class="btn bnt-sm btn-incre" href="quantity-inc-dec?action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square"></i></a>
                        <input type="text" name="quantity" class="form-control"  value="<%=c.getQuantity()%>" readonly>
                        <a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"></i></a>
                    </div>
                    <button type="submit" class="btn btn-primary btn-sm">Buy</button>
                </form>
            </td>
            <td><a href="remove-from-cart?id=<%=c.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
        </tr>

        <%
                }}%>
        </tbody>
    </table>
</div>

<%@include file="WEB-INF/includes/footer.jsp"%>
</body>
</html>
