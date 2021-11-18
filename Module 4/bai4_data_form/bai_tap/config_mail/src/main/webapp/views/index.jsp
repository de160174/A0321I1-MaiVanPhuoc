<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/18/2021
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>Setting</title>
  </head>
  <body>
  <h1>Setting</h1>
  <form:form method="post" action="submit" modelAttribute="email">
    <table>
      <tr>
        <td><form:label path="languages">language: </form:label></td>
        <td><form:select path="languages">
              <form:option value="English">English</form:option>
              <form:option value="Vietnamese">Vietnamese</form:option>
              <form:option value="Japanese">Japanese</form:option>
              <form:option value="Chinese">Chinese</form:option>
            </form:select>
        </td>
      </tr>
      <tr>
        <td><form:label path="pageSize">Page size: </form:label></td>
        <td><form:select path="pageSize">
          <form:option value="5">5</form:option>
          <form:option value="10">10</form:option>
          <form:option value="15">15</form:option>
          <form:option value="25">25</form:option>
          <form:option value="50">50</form:option>
          <form:option value="100">100</form:option>
        </form:select>
        </td>
      </tr>
      <tr>
        <td><form:label path="spamFilter">Spam Filter: </form:label></td>
        <td><form:checkbox path="spamFilter"/></td>
      </tr>
      <tr>
        <td><form:label path="signature">Signature: </form:label></td>
        <td><form:textarea path="signature"/></td>
      </tr>
      <tr>
        <td><input type="submit" value="Update"/></td>
      </tr>
    </table>
  </form:form>
  </body>
</html>
