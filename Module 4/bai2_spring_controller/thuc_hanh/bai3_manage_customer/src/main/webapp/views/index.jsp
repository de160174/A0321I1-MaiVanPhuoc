<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/13/2021
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.codegym.service.CustomerService" %>
<%@ page import="com.codegym.service.CustomerServiceFactory" %>
<%@ page import="com.codegym.model.Customer" %>
<%@ page import="java.util.List" %>
<%!
  private CustomerService customerService = CustomerServiceFactory.getInstance();
%>
<%
  long count = customerService.count();
  List<Customer> customers = customerService.findAll();
%>
<style>
  table {
    border: 1px solid #000;
  }

  th, td {
    border: 1px dotted #555;
  }
</style>
There are <%= count %> customer(s) in list.
<table>
  <caption>Customers List</caption>
  <thead>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Email</th>
    <th>Address</th>
  </tr>
  </thead>
  <tbody>
  <% for (Customer c : customers) { %>
  <tr>
    <td>
      <%= c.getId() %>
    </td>
    <td>
      <a href="/customer/${c.id}">${c.name}</a>
    </td>
    <td>
      <%= c.getEmail() %>
    </td>
    <td>
      <%= c.getAddress() %>
    </td>
  </tr>
  <% } %>
  </tbody>
</table>
