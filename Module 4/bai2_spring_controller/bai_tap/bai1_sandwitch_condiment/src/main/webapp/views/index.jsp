<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/13/2021
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>sandwich</title>
  </head>
  <body>
  <h1>Sandwich Condiment</h1>
  <form action="/save">
    <input type="checkbox" id="cond1" name="cond" value="Lettuce">
    <label for="cond1">Lettuce</label>
    <input type="checkbox" id="cond2" name="cond" value="Tomato">
    <label for="cond2">Tomato</label>
    <input type="checkbox" id="cond3" name="cond" value="Mustard">
    <label for="cond3">Mustard</label>
    <input type="checkbox" id="cond4" name="cond" value="Sprouts">
    <label for="cond4">Sprouts</label>
    <button type="submit">Save</button>
  </form>
  <hr>
  <span>I have choice
    <c:forEach items="${cond}" var="condiment">
      ${condiment}
    </c:forEach>
  </span>
  </body>
</html>
