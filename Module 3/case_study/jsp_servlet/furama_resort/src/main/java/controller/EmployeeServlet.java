package controller;


import model.bean.Employee;
import model.service.EmployeeService;
import model.service.Impl.EmployeeServiceImpl;
import model.service.Impl.UserServiceImpl;
import model.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService=new EmployeeServiceImpl();
    private UserService userService=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request,response);
                break;
            case "edit":
                editEmployee(request,response);
                break;
            case "search":
                searchEmployee(request,response);
                break;
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("nameSearch");
        List<Employee> employees=this.employeeService.search(name);
        request.setAttribute("employeeList",employees);
        try {
            request.getRequestDispatcher("employee/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String card = request.getParameter("card");
        Double salary = Double.valueOf(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email= request.getParameter("email");
        String address= request.getParameter("address");
        String position=request.getParameter("position");
        String degree=request.getParameter("degree");
        String division=request.getParameter("division");
        String username=request.getParameter("username");
        Employee employee = this.employeeService.findById(id);
        employee.setEmployee_name(name);
        employee.setEmployee_birthday(date);
        employee.setEmployee_id_card(card);
        employee.setEmployee_salary(salary);
        employee.setEmployee_phone(phone);
        employee.setEmployee_email(email);
        employee.setEmployee_address(address);
        employee.setPosition_id(position);
        employee.setEducation_degree_id(degree);
        employee.setDivision_id(division);
        employee.setUsername(username);
        this.employeeService.update(employee);
        request.setAttribute("employee", employee);
        request.setAttribute("message", "employee information was updated");
        try {
            request.getRequestDispatcher("employee/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String date=request.getParameter("date");
        String card=request.getParameter("card");
        Double salary= Double.valueOf(request.getParameter("salary"));
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        String position=request.getParameter("position");
        String degree=request.getParameter("degree");
        String division=request.getParameter("division");
        String username=request.getParameter("username");
        Employee employee=new Employee(id,name,date,card,salary,phone,email,address,position,degree,division,username);
        this.employeeService.create(employee);
        RequestDispatcher dispatcher=request.getRequestDispatcher("employee/create.jsp");
        request.setAttribute("message", "New employee was created");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request,response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            default:
                listEmployee(request, response);
                break;
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList=this.employeeService.findAll();
        request.setAttribute("employeeList",employeeList);
        try {
            request.getRequestDispatcher("employee/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("employee_id");
        this.employeeService.delete(id);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("id");
        Employee employee=this.employeeService.findById(id);
        request.setAttribute("employee",employee);
        try {
            request.getRequestDispatcher("employee/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("userList",userService.findAll());
        try {
            request.getRequestDispatcher("employee/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
