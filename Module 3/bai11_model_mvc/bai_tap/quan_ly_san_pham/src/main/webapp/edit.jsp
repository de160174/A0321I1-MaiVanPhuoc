<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/11/2021
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>edit</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Edit product</h1>
<p>
    <c:if test='${message!= null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/product">Back</a>
</p>
<form action="" method="post">
    <fieldset>
        <legend>edit</legend>
            <table>
                <tr>
                    <th>Name</th>
                    <td><input type="text" name="name" value="${product.name}"></td>
                </tr>
                <tr>
                    <th>Price</th>
                    <td><input type="text" name="price" value="${product.price}"></td>
                </tr>
                <tr>
                    <th>Description</th>
                    <td><input type="text" name="description" value="${product.description}"></td>
                </tr>
                <tr>
                    <th>Producer</th>
                    <td><input type="text" name="producer" value="${product.producer}"></td>
                </tr>
                <tr>
                    <th></th>
                    <td><input type="submit" value="update"></td>
                </tr>
            </table>

    </fieldset>

</form>
</body>
</html>
