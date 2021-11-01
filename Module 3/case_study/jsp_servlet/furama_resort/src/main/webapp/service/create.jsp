<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/25/2021
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add new Service</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <center>
        <h1 class="header">CREATE NEW SERVICE</h1>
    </center>
    <div class="row">
        <a href="/service" class="btn btn-primary">List All Service</a>
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
                <label for="id" class="col-sm-2 col-form-label">ServiceID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="id" name="id" placeholder="Enter ServiceID...">
                    <c:if test="${messServiceID != null}">
                        <small class="form-text text-danger">${messServiceID}</small>
                    </c:if>
                </div>
            </div>
            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">Service Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" required placeholder="Enter Name...">
                </div>
            </div>
            <div class="form-group row">
                <label for="area" class="col-sm-2 col-form-label">Service Area</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="area" name="area" placeholder="Enter Area...">
                </div>
            </div>
            <div class="form-group row">
                <label for="cost" class="col-sm-2 col-form-label">Service cost</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="cost" name="cost" placeholder="Enter cost...">
                    <c:if test="${messServiceCost != null}">
                        <small class="form-text text-danger">${messServiceCost}</small>
                    </c:if>
                </div>
            </div><div class="form-group row">
                <label for="people" class="col-sm-2 col-form-label">Max people </label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="people" name="people" placeholder="Enter max people...">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Rent Type</label>
                <div class="col-sm-10">
                    <select class="form-control" id="rent_type" name="rent_type">
                        <option value="K1">Year</option>
                        <option value="K2">Month</option>
                        <option value="K3">Day</option>
                        <option value="K4">Hour</option>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Service Type</label>
                <div class="col-sm-10">
                    <select class="form-control" id="type" name="type">
                        <option value="L1">Villa</option>
                        <option value="L2">House</option>
                        <option value="L3">Room</option>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label for="room" class="col-sm-2 col-form-label">Standard room</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="room" name="room" placeholder="Enter Standard room...">
                </div>
            </div>
            <div class="form-group row">
                <label for="desc" class="col-sm-2 col-form-label">Description</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="desc" name="desc" placeholder="Enter Description...">
                </div>
            </div>
            <div class="form-group row">
                <label for="pool" class="col-sm-2 col-form-label">Pool Area</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="pool"  name="pool" placeholder="Enter Pool Area...">
                </div>
            </div>
            <div class="form-group row">
                <label for="floor" class="col-sm-2 col-form-label">Number of floor</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="floor" name="floor" placeholder="Enter Number of floor...">
                    <c:if test="${messNumber != null}">
                        <small class="form-text text-danger">${messNumber}</small>
                    </c:if>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6" align="right">
                    <input type="submit" class="btn btn-success" value="Create"/>
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
