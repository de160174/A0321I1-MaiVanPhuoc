<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/8/2021
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<form method="post">
    <p>Name: </p>
    <input type="text" name="name" value="${student.name}">
    <p>Date of birth: </p>
    <input type="text" name="dateOfBirth" value="${student.dateOfBirth}">
    <button type="submit">Cập nhật</button>
</form>
</body>
</html>
