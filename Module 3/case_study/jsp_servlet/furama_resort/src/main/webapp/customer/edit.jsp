<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/20/2021
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit customer</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <center>
        <h1 class="header">EDIT INFORMATION CUSTOMER</h1>
    </center>
    <div class="row">
        <a href="/customer" class="btn btn-primary">List All Customer</a>
    </div>
    <p>
        <c:if test='${message!= null}'>
    <div class="alert alert-primary message" role="alert">
            ${message}
    </div>
    </c:if>
    </p>
    <div>
        <form method="post">
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">CustomerID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" disabled="true" name="id" id="id"
                           value="${customer.customer_id}">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Customer Type</label>
                <div class="col-sm-10">
                    <select class="form-control" id="type" name="type">
                        <option value="T1">Diamond</option>
                        <option value="T2">Platinum</option>
                        <option value="T3">Gold</option>
                        <option value="T4">Silver</option>
                        <option value="T5">Member</option>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" id="name"
                           value="${customer.customer_name}">
                </div>
            </div>
            <div class="form-group row">
                <label for="date" class="col-sm-2 col-form-label">Day of Birth</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="date" name="date" value="${customer.customer_birthday}">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Gender</label>
                <div class="col-sm-1">
                    <label class="radio-inline">Male</label>
                    <input type="radio" name="gender" value="true" ${customer.customer_gender==true?'checked':''}>
                </div>
                <div class="col-sm-9">
                    <label class="radio-inline">Female</label>
                    <input type="radio" name="gender" value="false" ${customer.customer_gender==false?'checked':''}>
                </div>
            </div>
            <div class="form-group row">
                <label for="card" class="col-sm-2 col-form-label">ID Card</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="card" name="card" value="${customer.customer_id_card}">
                </div>
            </div>
            <div class="form-group row">
                <label for="phone" class="col-sm-2 col-form-label">Phone</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="phone" name="phone" value="${customer.customer_phone}">
                </div>
            </div>
            <div class="form-group row">
                <label for="email" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="email" name="email" value="${customer.customer_email}">
                </div>
            </div>
            <div class="form-group row">
                <label for="address" class="col-sm-2 col-form-label">Address</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="address" name="address" value="${customer.customer_address}">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6" align="right">
                    <input type="submit" class="btn btn-success" value="Update"/>
                </div>
                <div class="col-lg-6" align="left">
                    <a href="/customer" class="btn btn-secondary">Cancel</a>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
