<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/19/2021
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add new Contract</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <center>
        <h1 class="header">CREATE NEW CONTRACT</h1>
    </center>
    <div class="row">
        <a href="/contract" class="btn btn-primary">List All Contract</a>
    </div>
    <p>
        <c:if test='${message!= null}'>
    <div class="alert alert-success message" role="alert">
            ${message}
    </div>
    </c:if>
    </p>
    <div>
        <form method="post">
            <div class="form-group row">
                <label for="id" class="col-sm-2 col-form-label">ContractID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="id" name="id" placeholder="Enter ContractID..." required>
                </div>
            </div>
            <div class="form-group row">
                <label for="start" class="col-sm-2 col-form-label">Start date</label>
                <div class="col-sm-10">
                    <input type="datetime-local" class="form-control" id="start" name="start" placeholder="Enter Start date YYYY-MM-DD HH:MM:SS...">
                </div>
            </div>
            <div class="form-group row">
                <label for="end" class="col-sm-2 col-form-label">End date</label>
                <div class="col-sm-10">
                    <input type="datetime-local" class="form-control" id="end" name="end" placeholder="Enter End date YYYY-MM-DD HH:MM:SS...">
                </div>
            </div>
            <div class="form-group row">
                <label for="deposit" class="col-sm-2 col-form-label">Deposit</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="deposit" name="deposit" placeholder="Enter Deposit...">
                    <c:if test="${messDeposit != null}">
                        <small class="form-text text-danger">${messDeposit}</small>
                    </c:if>
                </div>
            </div>
            <div class="form-group row">
                <label for="total" class="col-sm-2 col-form-label">Total Money</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="total" name="total" placeholder="Enter total money...">
                    <c:if test="${messTotal != null}">
                        <small class="form-text text-danger">${messTotal}</small>
                    </c:if>
                </div>
            </div>

            <div class="form-group row">
                <label for="employee" class="col-sm-2 col-form-label">Employee</label>
                <div class="col-sm-10">
                    <select class="form-control" id="employee" name="employee">
                        <c:forEach var="employee" items="${employeeList}">
                            <option value="${employee.employee_id}">${employee.employee_name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label for="customer" class="col-sm-2 col-form-label">Customer</label>
                <div class="col-sm-10">
                    <select class="form-control" id="customer" name="customer">
                        <c:forEach var="customer" items="${customerList}">
                            <option value="${customer.customer_id}">${customer.customer_name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label for="service" class="col-sm-2 col-form-label">Employee</label>
                <div class="col-sm-10">
                    <select class="form-control" id="service" name="service">
                        <c:forEach var="service" items="${serviceList}">
                            <option value="${service.service_id}">${service.service_name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6" align="right">
                    <input type="submit" class="btn btn-success" value="Create"/>
                </div>
                <div class="col-lg-6" align="left">
                    <a href="/contract" class="btn btn-secondary">Cancel</a>
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
