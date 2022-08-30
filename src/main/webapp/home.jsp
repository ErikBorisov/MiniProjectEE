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
  <style>
    .input-row{
      margin: 8px;
    }
    .reg-error{
      color: red;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="login">

  </div>

  <div class="registration">
    <span style="color: aqua">Registration:</span>
    <form action="register" method="post">
      <div class="input-row"><label for="reg_name"> User name: <input type="text" name="reg_name" id="reg_name"></label><br></div>
      <div class="input-row"><label for="reg_surname"> User surname: <input type="text" name="reg_surname" id="reg_surname"></label><br></div>
      <div class="input-row"><label for="reg_age"> User age: <input type="number"  name="reg_age" id="reg_age"></label><br></div>
      <div class="input-row"><label for="reg_email"> User email: <input type="text" name="reg_email" id="reg_email"></label><br></div>
      <div class="input-row"><label for="reg_phone_number"> User phone: <input type="text" name="reg_phone_number" id="reg_phone_number"></label><br></div>
      <div class="input-row"><label for="reg_password"> User password: <input type="password" name="reg_password" id="reg_password"></label><br></div>
      <div class="input-row"><label for="reg_gender"> User gender: <select name="reg_gender" id="reg_gender">
        <option value="MALE">Male</option>
        <option value="FEMALE">Female</option>
        <option value="OTHER">Other</option>
      </select></label><br></div>

      <% if (request.getParameter("reg_error")!=null) { %>
      <div class="input-row reg-error"><%=request.getParameter("reg_error")%></div>
      <% } %>


      <div class="input-row"><button type="submit">Register</button></div>
    </form>
  </div>
</div>
</body>
</html>
