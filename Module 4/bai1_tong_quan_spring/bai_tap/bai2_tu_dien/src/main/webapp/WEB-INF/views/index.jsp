<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/11/2021
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Dictionary</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <div class="form-group">
    <form action="/dictionary">
      <div>
        <label>English</label>
        <input class="form-control" name="eng" type="text" placeholder="Enter word..." value="${eng}">
      </div>
      <button type="submit" class="btn btn-primary m-2">dictionary</button>
    </form>
  </div>
  <div class="form-group">
    <label>Vietnamese</label>
    <input class="form-control" name="vie" value="${vie}" disabled>
  </div>

</div>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</html>
