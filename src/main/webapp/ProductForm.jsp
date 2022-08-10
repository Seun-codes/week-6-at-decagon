<%@ page import="com.example.ecomercestoreweek6.Utility.DatabaseConnection" %>
<%@ page import="com.example.ecomercestoreweek6.model.Product" %>
<%@ page import="com.example.ecomercestoreweek6.DAO.ProductDAO" %>
<%@ page import="com.example.ecomercestoreweek6.model.Carts" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.ecomercestoreweek6.model.User" %>
<%@ page import="com.example.ecomercestoreweek6.model.Admin" %><%--
  Created by IntelliJ IDEA.
  User: dec
  Date: 15/08/2022
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Admin auth = (Admin) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("person", auth);
    }
    ProductDAO pd = new ProductDAO(DatabaseConnection.getConnection());
    List<Product> products = pd.getAllProducts();
    ArrayList<Carts> cart_list = (ArrayList<Carts>) session.getAttribute("cart-list");
    if (cart_list != null) {
        request.setAttribute("cart_list", cart_list);
    }
    %>
<html>
<head>
    <title>Title</title>
    <%@include file="WEB-INF/includes/head.jsp"%>
</head>
<body>

<%@include file="WEB-INF/includes/AdminNavBar.jsp"%>
<%--<%--%>
<%--    String productCategory = (String) request.getAttribute("productCategory");--%>
<%--    String productName = (String) request.getAttribute("productName");--%>
<%--    int productQuantity = (int) request.getAttribute("productQuantity");--%>
<%--    String productPrice = (String) request.getAttribute("productPrice");--%>
<%--%>--%>
<form  action="AddProductServlet" method="post">
<div class="container">
    <div class="d-flex align-items-center mb-3 pb-1">
        <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
        <span class="h1 fw-bold mb-0">Add Product</span>
    </div>


    <div class="form-outline mb-2">
        <input class="form-control" type="text" name="productName"  placeholder="Product name" required />
    </div>
    <div class="form-outline mb-2">
        <input class="form-control" type="text" name="productCategory"  placeholder="Category" required/>
    </div>

    <div class="pt-1 mb-2">
        <input class="form-control" type="text" name="productPrice"  placeholder="Price" required/>
    </div>
    <div>
        <input class="form-control" type="text" name="productQuantity"  placeholder="Quantity" required/>
    </div>
    <div>
        <input class="form-control" type="text" name="image"  placeholder="image" required/>
    </div>


    <button type="submit" value="addProduct" class="btn btn-success" onclick="return confirm('Are you sure you want to add this product?');">Add Product</button>
    <button type="reset" class="btn btn-danger">Reset</button>
</div>

</form>
<%@include file="WEB-INF/includes/footer.jsp"%>
</body>
</html>
