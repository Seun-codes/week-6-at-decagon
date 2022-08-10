<%--
  Created by IntelliJ IDEA.
  User: dec
  Date: 13/08/2022
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN LOGIN</title>
    <%@include file="WEB-INF/includes/head.jsp"%>
</head>
<body>
<%@include file="WEB-INF/includes/NavBar.jsp"%>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-body text-center">Admin Login</div>
        <div class="card-body">
            <form  action="AdminLogInServlet" method="post">
                <div class="form-group">
                    <label>Email</label>
                    <input class="form-control" name="Email" type="email" placeholder="Enter your Email" required>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input class="form-control" name="Password" type="password" placeholder="*******" min="7" max="15" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary"> Login </button>
                    <a class ="btn btn-primary" href="AdminSignUp.jsp">Sign Up</a>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
<br/>

<%@include file="WEB-INF/includes/footer.jsp"%>
</body>
</html>
