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
    <title>Edit employee</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <center>
        <h1 class="header">EDIT INFORMATION EMPLOYEE</h1>
    </center>
    <div class="row">
        <a href="/employee" class="btn btn-primary">List All employee</a>
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
                <label class="col-sm-2 col-form-label">EmployeeID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" disabled="true" name="id" id="id"
                           value="${employee.employee_id}">
                </div>
            </div>

            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" id="name"
                           value="${employee.employee_name}">
                </div>
            </div>
            <div class="form-group row">
                <label for="date" class="col-sm-2 col-form-label">Day of Birth</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="date" name="date" value="${employee.employee_birthday}">
                </div>
            </div>
            <div class="form-group row">
                <label for="card" class="col-sm-2 col-form-label">ID Card</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="card" name="card" value="${employee.employee_id_card}">
                </div>
            </div>
            <div class="form-group row">
                <label for="salary" class="col-sm-2 col-form-label">Salary</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="salary" name="salary" value="${employee.employee_salary}">
                </div>
            </div>
            <div class="form-group row">
                <label for="phone" class="col-sm-2 col-form-label">Phone</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="phone" name="phone" value="${employee.employee_phone}">
                </div>
            </div>
            <div class="form-group row">
                <label for="email" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="email" name="email" value="${employee.employee_email}">
                </div>
            </div>
            <div class="form-group row">
                <label for="address" class="col-sm-2 col-form-label">Address</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="address" name="address" value="${employee.employee_address}">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Position</label>
                <div class="col-sm-10">
                    <select class="form-control" id="position" name="position">
                        <option value="VT1">Lễ tân</option>
                        <option value="VT2">Phục vụ</option>
                        <option value="VT3">Chuyên viên</option>
                        <option value="VT4">Giám sát</option>
                        <option value="VT5">Quản lý</option>
                        <option value="VT6">Giám đốc</option>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Education degree</label>
                <div class="col-sm-10">
                    <select class="form-control" id="degree" name="degree">
                        <option value="TD1">Trung cấp</option>
                        <option value="TD2">Cao đẳng</option>
                        <option value="TD3">Đại học</option>
                        <option value="TD4">Sau đại học</option>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Division</label>
                <div class="col-sm-10">
                    <select class="form-control" id="division" name="division">
                        <option value="BP1">Sale – Marketing</option>
                        <option value="BP2">Hành Chính</option>
                        <option value="BP3">Phục vụ</option>
                        <option value="BP4">Quản lý</option>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label for="address" class="col-sm-2 col-form-label">Username</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="username" name="username" value="${employee.username}">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6" align="right">
                    <input type="submit" class="btn btn-success" value="Update"/>
                </div>
                <div class="col-lg-6" align="left">
                    <a href="/employee" class="btn btn-secondary">Cancel</a>
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
