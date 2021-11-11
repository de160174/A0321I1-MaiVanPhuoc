<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/10/2021
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>change money</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="form-group">
        <form action="/change">
            <div>
                <label>USD</label>
                <input class="form-control" name="usd" type="number" placeholder="Enter USD..." value="${usd}">
            </div>
            <button type="submit" class="btn btn-primary m-2">Change</button>
        </form>
    </div>
    <div class="form-group">
        <label>VND</label>
        <input class="form-control" name="vnd" value="${vnd}" disabled>
    </div>

</div>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</html>
