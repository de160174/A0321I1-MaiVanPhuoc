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
    <title>Contract</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">

</head>
<body>
<div class="container">
    <center>
        <h1 class="header">Contract Management</h1>
    </center>
    <div class="row">
        <div class="col-lg-6">
            <a href="/contract?action=create" class="btn btn-primary">Add New Contract</a>
        </div>
        <div class="col-lg-6" align="right">
            <a href="/detail" class="btn btn-success">Contract detail</a>
        </div>
    </div>
    <div align="center">
        <table id="contract">
            <thead>
            <tr>
                <th>ContractID</th>
                <th>Start date</th>
                <th>End date</th>
                <th>Deposit</th>
                <th>Total money</th>
                <th>Employee made</th>
                <th>Customer</th>
                <th>Service</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="contract" items="${contractList}">
                <tr>
                    <td><c:out value="${contract.contract_id}"/></td>
                    <td><c:out value="${contract.contract_start_date}"/></td>
                    <td><c:out value="${contract.contract_end_date}"/></td>
                    <td><c:out value="${contract.contract_deposit}"/></td>
                    <td><c:out value="${contract.contract_total_money}"/></td>
                    <td><c:out value="${contract.employee_id}"/></td>
                    <td><c:out value="${contract.customer_id}"/></td>
                    <td><c:out value="${contract.service_id}"/></td>
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
        $('#contract').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 10
        })
    })
</script>
</body>
</html>
