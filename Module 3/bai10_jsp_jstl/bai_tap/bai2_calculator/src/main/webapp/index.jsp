<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/6/2021
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
  <style>
    input[type=text] {
      padding: 12px 20px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }
    #submit {
      background-color: #4CAF50;
      color: white;
      padding: 14px 20px;
      margin: 8px 0;
      border: none;
      border-radius: 4px;
    }
  </style>
</head>
<body>
<form action="/calculate" method="post">
    <h2>Calculator</h2>
    <label for="number1">First Number</label><br>
    <input type="text" name="number1" id="number1" placeholder="First Number"><br>
    <label for="operator">Operator</label><br>
    <select name="operator" id="operator">
        <option value="+">Addition</option>
        <option value="-">Subtraction</option>
        <option value="*">Multiplication</option>
        <option value="/">Division</option>
    </select><br><br>
    <label for="number2">Second Number</label><br>
    <input type="text" name="number2" id="number2" placeholder="Second Number"><br>
    <input type="submit" id="submit" value="Calculate">
</form>
</body>
</html>
