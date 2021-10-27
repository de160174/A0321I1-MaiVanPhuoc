package controller;

import model.bean.Customer;
import model.bean.Employee;
import model.service.*;
import model.service.Impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerUsingServlet", urlPatterns = "/customer_using")
public class CustomerUsingServlet extends HttpServlet {
//    private CustomerService customerService=new CustomerServiceImpl();
//    private ContractService contractService=new ContractServiceImpl();
//    private ContractDetailService contractDetailService=new ContractDetaiServiceImpl();
//    private AttachService attachService=new AttachServiceImpl();
    private CustomerUsingService customerUsingService=new CustomerUsingServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                editCustomer(request,response);
                break;
            case "search":
                searchCustomer(request,response);
                break;
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerUsingList=this.customerUsingService.selectCustomer();
        request.setAttribute("customerUsingList",customerUsingList);
        try {
            request.getRequestDispatcher("customer_using/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
