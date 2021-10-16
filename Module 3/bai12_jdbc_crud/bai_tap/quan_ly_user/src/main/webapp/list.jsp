<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/15/2021
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/user?action=create">Add New User</a>
    </h2>
</center>
<div align="center">
    <table>
        <caption>
            <h2>List of Users</h2>
            <h3><a href="/user?action=sort">Sort by name</a></h3>
        </caption>
        <form action="/user?action=search" method="post">
            <input type="text" name="nameSearch" placeholder="Enter country">
            <input type="submit" value="search">
        </form>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/user?action=edit&id=${user.id}">Edit</a>
                    <a href="/user?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
