<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/4/2021
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
  <title>Product Discount Calculator</title>
  <style>
    input[type=text] {
      width: 300px;
      font-size: 16px;
      border: 2px solid #ccc;
      border-radius: 4px;
      padding: 12px 10px 12px 10px;
    }
    #submit {
      border-radius: 2px;
      padding: 10px 32px;
      font-size: 16px;
    }
  </style>
</head>
<body>
<h2>Product Discount Calculator</h2>
<form action="/discount" method="post">
  <input type="text" name="txtDesc" placeholder="Enter your description"/>
  <input type="text" name="txtPrice" placeholder="Enter price"/>
  <input type="text" name="txtPercent" placeholder="Enter discount percent"/>
  <input type = "submit" id = "submit" value = "calculator"/>
</form>
</body>
</html>
