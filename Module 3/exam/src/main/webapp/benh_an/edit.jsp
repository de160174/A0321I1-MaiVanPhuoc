<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/2/2021
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sửa bệnh án</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../assert/bootstrap413/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <center>
        <h1 class="header">SỬA THÔNG TIN BỆNH ÁN</h1>
    </center>
    <div class="row">
        <a href="/benhAn" class="btn btn-primary">Danh sách bệnh án</a>
    </div>
    <p>
        <c:if test='${message!= null}'>
    <div class="alert alert-info message" role="alert">
            ${message}
    </div>
    </c:if>
    </p>
    <div>
        <form method="post">
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Mã bệnh án</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" disabled="true" name="id" id="id"
                           value="${benhAn.benh_an_id}">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Mã bệnh nhân</label>
                <div class="col-sm-10">

                    <input type="text" class="form-control" disabled="true" name="BNid" id="BNid"
                           value="${benhAn.benh_nhan_id}">
                    <input type="hidden" class="form-control" name="BNid"
                           value="${benhAn.benh_nhan_id}">
                </div>
            </div>
            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">Tên bệnh nhân</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" required id="name"
                           value="${benhAn.benh_nhan_name}">
                </div>
            </div>
            <div class="form-group row">
                <label for="start" class="col-sm-2 col-form-label">Ngày Nhập viện</label>
                <div class="col-sm-10">
                    <input type="date" class="form-control" id="start" name="start" value="${benhAn.ngay_nhap}">
                </div>
            </div>
            <div class="form-group row">
                <label for="end" class="col-sm-2 col-form-label">Ngày Ra viện</label>
                <div class="col-sm-10">
                    <input type="date" class="form-control" id="end" name="end" value="${benhAn.ngay_ra}">
                </div>
            </div>
            <div class="form-group row">
                <label for="lyDo" class="col-sm-2 col-form-label">Lý do</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="lyDo" name="lyDo" value="${benhAn.ly_do}">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6" align="right">
                    <input type="submit" class="btn btn-success" value="Sửa"/>
                </div>
                <div class="col-lg-6" align="left">
                    <a href="/benhAn" class="btn btn-secondary">Trở về</a>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="../assert/jquery/jquery-3.5.1.min.js"></script>
<script src="../assert/bootstrap413/js/popper.min.js"></script>
<script src="../assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="../assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
