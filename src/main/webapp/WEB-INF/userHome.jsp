<%@ page import="com.example.miniprojectee.models.User" %><%--
  Created by IntelliJ IDEA.
  User: Erik
  Date: 8/30/2022
  Time: 17:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserHome</title>
</head>
<body>
User home
<% User currentUser = (User)request.getSession().getAttribute("currentUser");%>
<%= currentUser.getName() %> <%= currentUser.getSurname() %>
</body>
</html>
