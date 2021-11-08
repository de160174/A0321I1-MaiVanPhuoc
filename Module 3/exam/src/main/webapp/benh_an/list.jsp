<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/2/2021
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title >Bệnh Án</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assert/datatables/css/dataTables.bootstrap4.min.css">

</head>
<body>
<div class="container">
    <center>
        <h1 class="header">Quản lý bệnh án</h1>
    </center>
<%--    <div class="row">--%>
<%--        <div class="col-lg-6">--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-12">--%>
<%--                    <a href="/product?action=create" class="btn btn-success">Add New Product</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col-lg-6 mr-0">--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-12">--%>
<%--                    <form action="/product?action=search" method="post">--%>
<%--                        <div class="input-group mb-3">--%>
<%--                            <input type="text" class="form-control" placeholder="Enter name..." name="nameSearch">--%>
<%--                            <input type="text" class="form-control" placeholder="Enter category..." name="categorySearch">--%>
<%--                            <div class="input-group-append">--%>
<%--                                <input type="submit" value="search" class="btn btn-dark">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
    <div>
        <table id="benh_an">
            <thead>
            <tr align="center">
                <th>STT</th>
                <th>Mã bệnh án</th>
                <th>Tên bệnh nhân</th>
                <th>Ngày nhập viện</th>
                <th>Ngày ra viện</th>
                <th>Lý do</th>
                <th>Mã bệnh nhân</th>
                <th>Tác vụ</th>
                <th>Tác vụ</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="benhAn" items="${benhAnList}" varStatus="loop">
                <tr>
                    <td>${loop.count}</td>
                    <td><c:out value="${benhAn.benh_an_id}"/></td>
                    <td><c:out value="${benhAn.benh_nhan_name}"/></td>
                    <td><c:out value="${benhAn.ngay_nhap}"/></td>
                    <td><c:out value="${benhAn.ngay_ra}"/></td>
                    <td><c:out value="${benhAn.ly_do}"/></td>
                    <td><c:out value="${benhAn.benh_nhan_id}"/></td>

                    <td>
                        <a class="btn btn-secondary" href="/benhAn?action=edit&id=${benhAn.benh_an_id}">Edit</a>
                    </td>
                    <td>
                        <a class="btn btn-danger" href=""
                           onclick="submitDelete('${benhAn.benh_an_id}')"
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
                        <h5 class="modal-title" id="exampleModalLabel">Xóa Bệnh án</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="/benhAn">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="benh_an_id" id="id">

                        <div class="modal-body">
                            Bạn có muốn xóa ?
                            <input type="text" id="name" size="50" disabled="true">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="../assert/jquery/jquery-3.5.1.min.js"></script>
<script src="../assert/bootstrap413/js/popper.min.js"></script>
<script src="../assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="../assert/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="../assert/bootstrap413/js/bootstrap.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#benh_an').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        })
    })
</script>
<script>
    function submitDelete(benh_an_id) {
        document.getElementById("id").value = benh_an_id;
        document.getElementById("name").value = benh_an_id;
    }
</script>
</body>
</html>
