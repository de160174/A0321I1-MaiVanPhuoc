<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/11/2021
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
    <h1>Create new product</h1>
<p>
    <c:if test='${message!=null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/product">Back</a>
</p>
    <form action="" method="post">
        <fieldset>
            <legend>Product information</legend>
            <table>
                <tr>
                    <th>Name</th>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <th>Price</th>
                    <td><input type="text" name="price" id="Price"></td>
                </tr>
                <tr>
                    <th>Description</th>
                    <td><input type="text" name="description" id="Description"></td>
                </tr>
                <tr>
                    <th>Producer</th>
                    <td><input type="text" name="producer" id="Producer"></td>
                </tr>
                <tr>
                    <th></th>
                    <td><input type="submit" value="create"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
