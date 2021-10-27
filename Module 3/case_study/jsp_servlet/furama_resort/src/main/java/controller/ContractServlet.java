package controller;

import model.bean.Contract;
import model.bean.Employee;
import model.service.ContractService;
import model.service.CustomerService;
import model.service.EmployeeService;
import model.service.Impl.ContractServiceImpl;
import model.service.Impl.CustomerServiceImpl;
import model.service.Impl.EmployeeServiceImpl;
import model.service.Impl.ServiceImpl;
import model.service.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet",urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    private ContractService contractService=new ContractServiceImpl();
    private CustomerService customerService=new CustomerServiceImpl();
    private EmployeeService employeeService=new EmployeeServiceImpl();
    private Service service=new ServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContract(request,response);
                break;
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("id");
        String start=request.getParameter("start");
        String end=request.getParameter("end");
        Double deposit= Double.valueOf(request.getParameter("deposit"));
        Double total= Double.valueOf(request.getParameter("total"));
        String employee=request.getParameter("employee");
        String customer=request.getParameter("customer");
        String service=request.getParameter("service");
        Contract contract=new Contract(id,start,end,deposit,total,employee,customer,service);
        this.contractService.create(contract);
        RequestDispatcher dispatcher=request.getRequestDispatcher("contract/create.jsp");
        request.setAttribute("message", "New contract was created");
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
            default:
                listContract(request, response);
                break;
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("employeeList",employeeService.findAll());
        request.setAttribute("customerList",customerService.findAll());
        request.setAttribute("serviceList",service.findAll());
        try {
            request.getRequestDispatcher("contract/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList=this.contractService.findAll();
        request.setAttribute("contractList",contractList);
        try {
            request.getRequestDispatcher("contract/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
