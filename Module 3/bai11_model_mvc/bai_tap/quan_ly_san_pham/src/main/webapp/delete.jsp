<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/11/2021
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/product">Back</a>
</p>
<form action="" method="post">
    <h3>are u sure?</h3>
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
            <tr>
                <th></th>
                <td><input type="submit" value="delete"></td>
            </tr>
        </table>

    </fieldset>
</form>
</body>
</html>
