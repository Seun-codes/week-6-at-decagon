<%@ page import="com.example.ecomercestoreweek6.Utility.DatabaseConnection" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SHOE EXPRESS</title>
    <%@include file="WEB-INF/includes/head.jsp"%>
</head>
<body>
    <%@include file="WEB-INF/includes/NavBar.jsp"%>

<br/>
<% out.print(DatabaseConnection.getConnection()); %>
<%@include file="WEB-INF/includes/footer.jsp"%>
</body>
</html>