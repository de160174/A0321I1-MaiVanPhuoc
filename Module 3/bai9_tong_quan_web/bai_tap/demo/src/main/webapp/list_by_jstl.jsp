<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/5/2021
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list student by jstl</title>
</head>
<body>
<h2>List student by JSTL</h2>
<table>
    <tr>
        <th>NO</th>
        <th>ID</th>
        <th>Name</th>
        <th>Date of birth</th>
        <th>Gender</th>
        <th>Degree</th>
    </tr>
    <%--for(Student student: studentListServlet)--%>
    <c:forEach var="student" items="${studentListServlet}" varStatus="loop">
        <tr>
                <%--count đếm từ 1 --%>
                <%--index đếm từ 0- -%>

               <%--tương đương với student.getId()--%>
            <td>${loop.count}</td>
            <%--Vì jstt sẽ tự động gọi phương get tương ứng
            Gửi lại chỗ c:out và ${}--%>
            <td><c:out value="${student.id}"></c:out></td>
            <td><c:out value="${student.name}"></c:out></td>
            <td>${student.dateOfBirth}</td>
            <td>
                <c:if test="${student.gender == 1}">
                    Male
                </c:if>
                <c:if test="${student.gender == 0}">
                    Female
                </c:if>
                    <%--Không có mệnh đề else trong jstl--%>
            </td>
            <td>
                <c:choose>
                    <c:when test="${student.grade <4}">
                        Bad
                    </c:when>
                    <c:when test="${student.grade <7}">
                        Good
                    </c:when>
                    <c:otherwise>
                        Very good
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
