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
    <title>Add new Contract Detail</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <center>
        <h1 class="header">CREATE NEW CONTRACT DETAIL</h1>
    </center>
    <div class="row">
        <a href="/detail" class="btn btn-primary">List All Contract detail</a>
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
                <label for="id" class="col-sm-2 col-form-label">Contract Detail ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="id" name="id" placeholder="Enter Contract Detail ID..." required>
                </div>
            </div>
            <div class="form-group row">
                <label for="contract" class="col-sm-2 col-form-label">ContractID</label>
                <div class="col-sm-10">
                    <select class="form-control" id="contract" name="contract">
                        <c:forEach var="contract" items="${contractList}">
                            <option value="${contract.contract_id}">${contract.contract_id}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label for="attach" class="col-sm-2 col-form-label">Customer</label>
                <div class="col-sm-10">
                    <select class="form-control" id="attach" name="attach">
                        <c:forEach var="attach" items="${attachList}">
                            <option value="${attach.attach_service_id}">${attach.attach_service_name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label for="quantity" class="col-sm-2 col-form-label">Quantity</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" required id="quantity" name="quantity" placeholder="Enter Quantity...">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6" align="right">
                    <input type="submit" class="btn btn-success" value="Create"/>
                </div>
                <div class="col-lg-6" align="left">
                    <a href="/detail" class="btn btn-secondary">Cancel</a>
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
