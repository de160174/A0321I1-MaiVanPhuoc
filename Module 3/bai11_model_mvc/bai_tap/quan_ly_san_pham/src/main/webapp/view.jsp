<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/11/2021
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view product</title>
</head>
<body>
<h1>view product</h1>
<p>
    <a href="/product">Back</a>
</p>
<form action="" method="post">
    <fieldset>
        <legend>product information</legend>
        <table>
            <tr>
                <th>Name</th>
                <td>${product.name}</td>
            </tr>
            <tr>
                <th>Price</th>
                <td>${product.price}</td>
            </tr>
            <tr>
                <th>Description</th>
                <td>${product.description}</td>
            </tr>
            <tr>
                <th>Producer</th>
                <td>${product.producer}</td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
