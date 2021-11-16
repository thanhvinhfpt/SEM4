<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 11/15/2021
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<h1 style="padding-left: 390px;"> Login Form</h1>
<form  action="LoginController" method="post" style="padding: 2% 25%">
        <div class="mb-3">
            <label for="name" class="form-label">Username</label>
            <input type="text" class="form-control" name="username" id="name" required required oninvalid="this.setCustomValidity('Vui lòng nhập username')" placeholder="Input Username">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Password</label>
            <input type="password" class="form-control" name="pass" id="price" required placeholder="Input Password" required oninvalid="this.setCustomValidity('Vui lòng nhập password')">
        </div>
        <div style="color:red">${mess}</div>
        <button type="submit">Đăng nhập</button>


</form>
</body>
</html>
