<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/25/2021
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Service</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">

</head>
<body>
<div class="container">
    <center>
        <h1 class="header">Service Management</h1>
    </center>
    <div class="row">
        <div class="col-lg-12">
            <div class="row">
                <div class="col-lg-12">
                    <a href="/service?action=create" class="btn btn-primary">Add New Service</a>
                </div>
            </div>
        </div>
    </div>
    <div align="center">
        <table id="service">
            <thead>
            <tr>
                <th>ServiceID</th>
                <th>Name</th>
                <th>Area</th>
                <th>Cost</th>
                <th>Max People</th>
                <th>Rent Type</th>
                <th>Service Type</th>
                <th>Standard room</th>
                <th>Description</th>
                <th>Pool Area</th>
                <th>Number Floor</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="service" items="${serviceList}">
                <tr>
                    <td><c:out value="${service.service_id}"/></td>
                    <td><c:out value="${service.service_name}"/></td>
                    <td><c:out value="${service.service_area}"/></td>
                    <td><c:out value="${service.service_cost}"/></td>
                    <td><c:out value="${service.service_max_people}"/></td>
                    <td>
                        <c:if test="${service.rent_type_id == 'K1'}">
                            Year
                        </c:if>
                        <c:if test="${service.rent_type_id == 'K2'}">
                            Month
                        </c:if>
                        <c:if test="${service.rent_type_id == 'K3'}">
                            Day
                        </c:if>
                        <c:if test="${service.rent_type_id == 'K4'}">
                            Hour
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${service.service_type_id == 'L1'}">
                            Villa
                        </c:if>
                        <c:if test="${service.service_type_id == 'L2'}">
                            House
                        </c:if>
                        <c:if test="${service.service_type_id == 'L3'}">
                            Room
                        </c:if>
                    </td>
                    <td><c:out value="${service.standard_room}"/></td>
                    <td><c:out value="${service.description}"/></td>
                    <td><c:out value="${service.pool_area}"/></td>
                    <td><c:out value="${service.number_of_floor}"/></td>
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
        $('#service').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        })
    })
</script>
</body>
</html>
