<%--
  Created by IntelliJ IDEA.
  User: dec
  Date: 09/08/2022
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <%@include file="WEB-INF/includes/head.jsp"%>
</head>
<body>
<%@include file="WEB-INF/includes/NavBar.jsp"%>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">SignUp Here</div>
        <div class="card-body">
            <form action="Sign-Up-Servlet" method="post">
                <div class = "form-group">
                    <label>FirstName</label>
                    <input class ="form-control" name="Firstname" type="text" placeholder="First name" required>
                </div>
                <div class="form-group">
                    <label>Surname</label>
                    <input class = "form-control" name ="Surname" type="text" placeholder="surname" required>
                </div>
                <div class="form-group">
                    <label>Email Address</label>
                    <input class="form-control" name="email" type="email" placeholder="Enter your Email" required>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input class="form-control" name="password" type="password" placeholder="*******" min="7" max="15" required>
                </div>
                <div class="form-group">
                    <label>Address</label>
                    <input class="form-control" name="address" type="text" placeholder="Address" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary"> SignUp </button>
                </div>
            </form>
        </div>
    </div>
</div>
<br/>

<%@include file="WEB-INF/includes/footer.jsp"%>
</body>
</html>
