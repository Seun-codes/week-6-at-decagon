<%@ page import="com.example.ecomercestoreweek6.Utility.DatabaseConnection" %>
<%@ page import="com.example.ecomercestoreweek6.model.User" %>
<%@ page import="com.example.ecomercestoreweek6.DAO.ProductDAO" %>
<%@ page import="com.example.ecomercestoreweek6.model.Product" %>
<%@ page import="com.example.ecomercestoreweek6.constants.Cart" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.ecomercestoreweek6.model.Carts" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%
   User auth = (User) request.getSession().getAttribute("auth");
   if (auth != null) {
        request.setAttribute("person", auth);
    }

    ProductDAO pd = new ProductDAO(DatabaseConnection.getConnection());
    List<Product> products = pd.getAllProducts();
    ArrayList<Carts> cart_List = (ArrayList<Carts>) session.getAttribute("cart-list");
    if(cart_List != null){
        request.setAttribute("cart_List", cart_List);
    }
    %>
<!DOCTYPE html>
<html>
<head>
    <title>SHOE EXPRESS</title>
    <%@include file="WEB-INF/includes/head.jsp"%>
</head>
<body>
    <%@include file="WEB-INF/includes/NavBar.jsp"%>
    <div class="container">
        <div class="card-header my-3">All Products</div>
        <div class="row">
            <%

                if (!products.isEmpty()) {
                    for (Product product : products) {
            %>
            <div class="col-md-3 my-3">
                <div class="card w-100" style="width: 18rem;">
                    <img src="Products/<%=product.getImage()%>" class="card-img-top" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title"><%=product.getProductName() %></h5>
                        <h6 class="price">Price: #<%=product.getProductPrice() %></h6>
                        <h6 class="category">Category: <%=product.getProductCategory() %></h6>
                        <div class="mt-3 d-flex justify-content-between">
                            <a class="btn btn-dark" href="AddToCartServlet?id=<%=product.getId()%>">Add to Cart</a>

                        </div>
                    </div>
                </div>
            </div>
            <%
                    }
                } else {
                    out.println("There is no product");
                }
            %>

        </div>
    </div>

<br/>
<%--<script type="text/javascript">--%>
<%--    $(document).ready(function (){--%>
<%--    $("#buttonAddToCart").click(function (){--%>
<%--        window.location = 'AddToCartServlet?id=' + ${product.id};--%>
<%--    })--%>
<%--    })--%>
<%--</script>--%>

</body>
</html>



