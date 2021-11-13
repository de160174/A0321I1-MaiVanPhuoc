<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/13/2021
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="/calculate">
    <input type="number" name="num1">
    <input type="number" name="num2"><br><br>
    <input type="submit" name="operation" value="add">
    <input type="submit" name="operation" value="sub">
    <input type="submit" name="operation" value="mul">
    <input type="submit" name="operation" value="div">
    <hr>
    <span>result: ${calculate}</span>
  </form>
  </body>
</html>
