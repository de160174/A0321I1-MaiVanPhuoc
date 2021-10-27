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
    <title>Contract Detail</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">

</head>
<body>
<div class="container">
    <center>
        <h1 class="header">Contract Detail Management</h1>
    </center>
    <div class="row">
        <div class="col-lg-6">
            <a href="/detail?action=create" class="btn btn-primary">Add New Contract Detail</a>
        </div>
        <div class="col-lg-6" align="right">
            <a href="/contract" class="btn btn-light">Back to Contract</a>
        </div>
    </div>
    <div align="center">
        <table id="contractDetail">
            <thead>
            <tr>
                <th>ContractDetail ID</th>
                <th>ContractID</th>
                <th>Attach Service</th>
                <th>Quantity</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="contractDetail" items="${contractDetailList}">
                <tr>
                    <td><c:out value="${contractDetail.contract_detail_id}"/></td>
                    <td><c:out value="${contractDetail.contract_id}"/></td>
                    <td><c:out value="${contractDetail.attach_service_id}"/></td>
                    <td><c:out value="${contractDetail.quantity}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
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
        $('#contractDetail').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 10
        })
    })
</script>
</body>
</html>
