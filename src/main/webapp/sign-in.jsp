<%--
  Created by IntelliJ IDEA.
  User: Erik
  Date: 8/30/2022
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="./home.css">
  <title>Sign up</title>
</head>
<body>
<div class="container">
  <div class="login">
    <h2 class="title">Login</h2>
    <form action="login" method="post" class="login-form">
      <div class="input-row">
        <label for="login_email">Email:</label>
        <input type="text" name="login_email" id="login_email" placeholder="Email">
      </div>
      <div class="input-row">
        <label for="login_password">Password:</label>
        <input type="password" name="login_password" id="login_password" placeholder="Password">
      </div>


      <% if (request.getParameter("log_error")!=null) { %>
      <div class="input-row reg-error"><%=request.getParameter("log_error")%></div>
      <% } %>


      <div class="input-row">
        <button type="submit" class="submit">Sign in</button>
      </div>
      <%--      <div>Don’t have an account yet? <a href="/MiniProjectEE_war_exploded/sign-up">Sign up</a></div>--%>
      <div>Don’t have an account yet? <a href="sign-up.jsp">Sign up</a></div>
    </form>
  </div>
</div>
</body>
</html>
