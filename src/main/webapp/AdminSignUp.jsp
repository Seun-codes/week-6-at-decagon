<%--
  Created by IntelliJ IDEA.
  User: dec
  Date: 15/08/2022
  Time: 15:14
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
            <form action="${pageContext.request.contextPath}/AdminSignUpServlet" method="POST">
                <div class = "form-group">
                    <label>Name</label>
                    <input class ="form-control" name="Name" type="text" placeholder="First name" required>
                </div>

                <div class="form-group">
                    <label>Email</label>
                    <input class="form-control" name="Email" type="email" placeholder="Enter your Email" required>
                </div>
                <div class="form-group">
                    <label>password</label>
                    <input class="form-control" name="password" type="password" placeholder="*******" min="7" max="15" required>
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

