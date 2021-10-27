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
    <title>Employee</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">

</head>
<body>
<div class="container-fluid">
    <center>
        <h1 class="header">Employee Management</h1>
    </center>
    <div class="row">
        <div class="col-lg-6">
            <div class="row">
                <div class="col-lg-12">
                    <a href="/employee?action=create" class="btn btn-primary">Add New Employee</a>
                </div>
            </div>
        </div>
        <div class="col-lg-6 mr-0">
            <div class="row">
                <div class="col-lg-12">
                    <form action="/employee?action=search" method="post">
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
    <div>
        <table id="employee">
            <thead>
            <tr>
                <th>EmployeeID</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>IDCard</th>
                <th>Salary</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Position</th>
                <th>Education degree</th>
                <th>Division</th>
                <th>Username</th>
                <th>Action</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" items="${employeeList}">
                <tr>
                    <td><c:out value="${employee.employee_id}"/></td>
                    <td><c:out value="${employee.employee_name}"/></td>
                    <td><c:out value="${employee.employee_birthday}"/></td>
                    <td><c:out value="${employee.employee_id_card}"/></td>
                    <td><c:out value="${employee.employee_salary}"/></td>
                    <td><c:out value="${employee.employee_phone}"/></td>
                    <td><c:out value="${employee.employee_email}"/></td>
                    <td><c:out value="${employee.employee_address}"/></td>
                    <td>
                        <c:if test="${employee.position_id == 'VT1'}">
                            Lễ tân
                        </c:if>
                        <c:if test="${employee.position_id == 'VT2'}">
                            Phục vụ
                        </c:if>
                        <c:if test="${employee.position_id == 'VT3'}">
                            Chuyên viên
                        </c:if>
                        <c:if test="${employee.position_id == 'VT4'}">
                            Giám sát
                        </c:if>
                        <c:if test="${employee.position_id == 'VT5'}">
                            Quản lý
                        </c:if>
                        <c:if test="${employee.position_id == 'VT6'}">
                            Giám đốc
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${employee.education_degree_id == 'TD1'}">
                            Trung cấp
                        </c:if>
                        <c:if test="${employee.education_degree_id == 'TD2'}">
                            Cao đẳng
                        </c:if>
                        <c:if test="${employee.education_degree_id == 'TD3'}">
                            Đại học
                        </c:if>
                        <c:if test="${employee.education_degree_id == 'TD4'}">
                            Sau đại học
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${employee.division_id == 'BP1'}">
                            Sale – Marketing
                        </c:if>
                        <c:if test="${employee.division_id == 'BP2'}">
                            Hành Chính
                        </c:if>
                        <c:if test="${employee.division_id == 'BP3'}">
                            Phục vụ
                        </c:if>
                        <c:if test="${employee.division_id == 'BP4'}">
                            Quản lý
                        </c:if>
                    </td>
                    <td><c:out value="${employee.username}"/></td>
                    <td>
                        <a class="btn btn-success" href="/employee?action=edit&id=${employee.employee_id}">Edit</a>
                    </td>
                    <td>
                        <a class="btn btn-danger" href="" onclick="submitDelete('${employee.employee_id}','${employee.employee_name}')"
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
                        <h5 class="modal-title" id="exampleModalLabel">Delete employee</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="/employee">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="employee_id" id="id">

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
        $('#employee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        })
    })
</script>
<script>
    function submitDelete(employee_id,employee_name) {
        document.getElementById("id").value=employee_id;
        document.getElementById("name").value=employee_name;
    }
</script>
</body>
</html>
