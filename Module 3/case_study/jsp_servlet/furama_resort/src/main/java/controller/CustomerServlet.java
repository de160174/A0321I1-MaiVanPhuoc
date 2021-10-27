package controller;

import model.bean.Customer;
import model.service.CustomerService;
import model.service.Impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService=new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request,response);
                break;
            case "edit":
                editCustomer(request,response);
                break;
            case "search":
                searchCustomer(request,response);
                break;
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("nameSearch");
        List<Customer> customers=this.customerService.search(name);
        request.setAttribute("customerList",customers);
        try {
            request.getRequestDispatcher("customer/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        Boolean gender = Boolean.valueOf(request.getParameter("gender"));
        String card = request.getParameter("card");
        String phone = request.getParameter("phone");
        String email= request.getParameter("email");
        String address= request.getParameter("address");
        Customer customer = this.customerService.findById(id);
        customer.setCustomer_type_id(type);
        customer.setCustomer_name(name);
        customer.setCustomer_birthday(date);
        customer.setCustomer_gender(gender);
        customer.setCustomer_id_card(card);
        customer.setCustomer_phone(phone);
        customer.setCustomer_email(email);
        customer.setCustomer_address(address);
        this.customerService.update(customer);
        request.setAttribute("customer", customer);
        request.setAttribute("message", "Customer information was updated");
        try {
            request.getRequestDispatcher("customer/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("id");
        String type=request.getParameter("type");
        String name=request.getParameter("name");
        String date=request.getParameter("date");
        Boolean gender= Boolean.valueOf(request.getParameter("gender"));
        String card=request.getParameter("card");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        Customer customer=new Customer(id,type,name,date,gender,card,phone,email,address);
        this.customerService.create(customer);
        RequestDispatcher dispatcher=request.getRequestDispatcher("customer/create.jsp");
        request.setAttribute("message", "New customer was created");
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
                deleteCustomer(request,response);
                break;
            default:
                listUser(request, response);
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("customer_id");
        this.customerService.delete(id);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("id");
        Customer customer=this.customerService.findById(id);
        request.setAttribute("customer",customer);
        try {
            request.getRequestDispatcher("/customer/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/customer/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList=this.customerService.findAll();
        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("customer/list.jsp").forward(request,response);
    }
}
