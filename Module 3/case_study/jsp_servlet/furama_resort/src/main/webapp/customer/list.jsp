<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/18/2021
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">

</head>
<body>
<div class="container">
    <center>
        <h1 class="header">Customer Management</h1>
    </center>
    <div class="row">
        <div class="col-lg-6">
            <div class="row">
                <div class="col-lg-6">
                    <div class="row">
                        <a href="/customer?action=create" class="btn btn-primary">Add New Customer</a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <a href="/customer_using" class="btn btn-secondary">Customer using Service</a>
                </div>
            </div>
        </div>
        <div class="col-lg-6 mr-0">
            <div class="row">
                <div class="col-lg-12">
                    <form action="/customer?action=search" method="post">
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" placeholder="Enter name..." name="nameSearch">
                            <div class="input-group-append">
                                <input type="submit" value="search" class="btn btn-light">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div align="center">
        <table id="customer">
            <thead>
            <tr>
                <th>CustomerID</th>
                <th>Type</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Gender</th>
                <th>IDCard</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Action</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="customer" items="${customerList}">
                <tr>
                    <td><c:out value="${customer.customer_id}"/></td>
                    <td>
                        <c:if test="${customer.customer_type_id == 'T1'}">
                            Diamond
                        </c:if>
                        <c:if test="${customer.customer_type_id == 'T2'}">
                            Platinum
                        </c:if>
                        <c:if test="${customer.customer_type_id == 'T3'}">
                            Gold
                        </c:if>
                        <c:if test="${customer.customer_type_id == 'T4'}">
                            Silver
                        </c:if>
                        <c:if test="${customer.customer_type_id == 'T5'}">
                            Member
                        </c:if>
                    </td>
                    <td><c:out value="${customer.customer_name}"/></td>
                    <td><c:out value="${customer.customer_birthday}"/></td>
                    <td>
                        <c:if test="${customer.customer_gender == true}">
                            Male
                        </c:if>
                        <c:if test="${customer.customer_gender == false}">
                            Female
                        </c:if>
                    </td>
                    <td><c:out value="${customer.customer_id_card}"/></td>
                    <td><c:out value="${customer.customer_phone}"/></td>
                    <td><c:out value="${customer.customer_email}"/></td>
                    <td><c:out value="${customer.customer_address}"/></td>
                    <td>
                        <a class="btn btn-success" href="/customer?action=edit&id=${customer.customer_id}">Edit</a>
                    </td>
                    <td>
                        <a class="btn btn-danger" href="" onclick="submitDelete('${customer.customer_id}','${customer.customer_name}')"
                           role="button" data-toggle="modal" data-target="#exampleModal">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Delete Customer</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="/customer">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="customer_id" id="id">

                        <div class="modal-body">
                            Are you want delete ?
                            <input type="text" id="name" size="50" disabled="true">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Delete</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="/assert/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#customer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        })
    })
</script>
<script>
    function submitDelete(customer_id,customer_name) {
        document.getElementById("id").value=customer_id;
        document.getElementById("name").value=customer_name;
    }
</script>
</body>
</html>
