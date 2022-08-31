<%--
  Created by IntelliJ IDEA.
  User: Erik
  Date: 8/30/2022
  Time: 17:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>MiniProjectEE</title>
  <link rel="stylesheet" href="./home.css">
</head>
<body>
<div class="container">
  <div class="registration">
    <h2 class="title">Registration</h2>
    <form action="register" method="get" class="register-form">
      <div class="input-row">
        <label for="reg_name">First name:</label>
        <input type="text" name="reg_name" id="reg_name" placeholder="First name">
      </div>
      <div class="input-row">
        <label for="reg_surname">Last name</label>
        <input type="text" name="reg_surname" id="reg_surname" placeholder="Last name">
      </div>
      <div class="input-row">
        <label for="reg_age">Age:</label>
        <input type="number"  name="reg_age" id="reg_age" placeholder="Age">
      </div>
      <div class="input-row">
        <label for="reg_email">Email:</label>
        <input type="text" name="reg_email" id="reg_email" placeholder="Email">
      </div>
      <div class="input-row">
        <label for="reg_phone_number">Phone number:</label>
        <input type="text" name="reg_phone_number" id="reg_phone_number" placeholder="Phone number">
      </div>
      <div class="input-row">
        <label for="reg_password">Password:</label>
        <input type="password" name="reg_password" id="reg_password" placeholder="password">
      </div>
      <div class="input-row"><label for="reg_gender">User gender:</label>
        <select name="reg_gender" id="reg_gender">
          <option value="MALE">Male</option>
          <option value="FEMALE">Female</option>
          <option value="OTHER">Other</option>
        </select>
      </div>

      <% if (request.getParameter("reg_error")!=null) { %>
      <div class="input-row reg-error"><%=request.getParameter("reg_error")%></div>
      <% } %>


      <div class="input-row">
        <button type="submit" class="submit" formmethod="get">Sign up</button>
      </div>

<%--      <div>Already have an account? <a href="/MiniProjectEE_war_exploded/sign-in">Sign in</a></div>--%>
      <div>Already have an account? <a href="sign-in.jsp">Sign in</a></div>
    </form>
  </div>
</div>
</body>
</html>
