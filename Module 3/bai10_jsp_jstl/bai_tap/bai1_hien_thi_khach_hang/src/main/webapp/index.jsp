<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/6/2021
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list customer JSTL</title>
    <style>
        table {
            border-collapse: collapse;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even){background-color: #f2f2f2}

        th {
            background-color: #04AA6D;
            color: white;
        }
        img {
            width: 80px;
            height: 80px;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>Tên Khách Hàng</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th>Ảnh Khách Hàng</th>
    </tr>
    <c:forEach var="customer" items="${customerListServlet}">
        <tr>
            <td><c:out value="${customer.name}"></c:out></td>
            <td><c:out value="${customer.date}"></c:out></td>
            <td><c:out value="${customer.address}"></c:out></td>
            <td><img src="${customer.img}"></td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
