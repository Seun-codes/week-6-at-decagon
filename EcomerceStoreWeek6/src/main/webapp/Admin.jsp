<%--
  Created by IntelliJ IDEA.
  User: dec
  Date: 09/08/2022
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN PAGE</title>
    <%@include file="WEB-INF/includes/head.jsp"%>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="Admin.jsp">DIPSON STORES ADMIN PAGE</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="Login.jsp">Login</a></li>
                <li class="nav-item"><a class="nav-link" href="SignUp.jsp">SignUp</a></li>
            </ul>
        </div>
    </div>
</nav>
<%@include file="WEB-INF/includes/footer.jsp"%>
</body>
</html>
