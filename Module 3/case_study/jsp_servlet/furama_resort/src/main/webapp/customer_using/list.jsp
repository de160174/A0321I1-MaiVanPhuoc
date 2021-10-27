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
    <title>Customer Using Service</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">

</head>
<body>
<div class="container-fluid">
    <center>
        <h1 class="header">Customer Using Service</h1>
    </center>
    <div class="row">
        <div class="col-lg-12">
            <div class="row">
                <div class="col-lg-12">
                    <a href="/customer" class="btn btn-light">Back to list Customer</a>
                </div>
            </div>
        </div>
    </div>
    <div align="center">
        <table id="customer_using">
            <thead>
            <tr>
                <th>CustomerID</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Gender</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>ContractID</th>
                <th>Total money</th>
                <th>Contract detailID</th>
                <th>AttachID</th>
                <th>Attach name</th>
                <th>Action</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="customer" items="${customerUsingList}">
                <tr>
                    <td><c:out value="${customer.customer_id}"/></td>
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
                    <td><c:out value="${customer.customer_phone}"/></td>
                    <td><c:out value="${customer.customer_email}"/></td>
                    <td><c:out value="${customer.customer_address}"/></td>
                    <td><c:out value="${customer.contract_id}"/></td>
                    <td><c:out value="${customer.contract_total_money}"/></td>
                    <td><c:out value="${customer.contract_detail_id}"/></td>
                    <td><c:out value="${customer.attach_service_id}"/></td>
                    <td><c:out value="${customer.attach_service_name}"/></td>
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
        $('#customer_using').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
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
