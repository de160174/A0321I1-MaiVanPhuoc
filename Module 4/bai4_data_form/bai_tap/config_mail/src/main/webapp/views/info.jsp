<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/18/2021
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
</head>
<body>
<h1>Config Email</h1>
<table>
    <tr>
        <td>Language :</td>
        <td>${languages}</td>
    </tr>
    <tr>
        <td>Page Size :</td>
        <td>${pageSize}</td>
    </tr>
    <tr>
        <td>Spam Filer :</td>
        <td>${spamFilter}</td>
    </tr>
    <tr>
        <td>Signature :</td>
        <td>${signature}</td>
    </tr>
</table>
</body>
</html>
