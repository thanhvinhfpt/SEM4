<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <title>Create employee</title>
</head>
<body>
    <h1 style="margin-left: 500px">ADD NEW EMPLOYEE</h1>
<form action="/save" modelAttribute="employees" method="post" style="margin-left: 500px">
    <input name="id" value="${employees.id}"hidden/>
    <div class="col-md-6">
        <div class="form-group">
            <label for="name">Employee name</label><br>
            <input class="form-control" type="text" id="name" required name="name" value="${employees.name}"><br>
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <label for="wage">Employee Wage</label><br>
            <input class="form-control" type="number" id="wage" required name="wage" value="${employees.wage}"><br><br>
        </div>
    </div>
    <input class="btn-primary" type="submit" value="Submit">
</form>
</body>
</html>