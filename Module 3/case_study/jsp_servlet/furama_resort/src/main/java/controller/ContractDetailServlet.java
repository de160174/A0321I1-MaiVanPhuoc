package controller;

import model.bean.Contract;
import model.bean.ContractDetail;
import model.service.AttachService;
import model.service.ContractDetailService;
import model.service.ContractService;
import model.service.Impl.AttachServiceImpl;
import model.service.Impl.ContractDetaiServiceImpl;
import model.service.Impl.ContractServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet",urlPatterns = "/detail")
public class ContractDetailServlet extends HttpServlet {
    private ContractDetailService contractDetailService=new ContractDetaiServiceImpl();
    private ContractService contractService=new ContractServiceImpl();
    private AttachService attachService=new AttachServiceImpl();
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
        String contract=request.getParameter("contract");
        String attach=request.getParameter("attach");
        int quantity= Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail=new ContractDetail(id,contract,attach,quantity);
        this.contractDetailService.create(contractDetail);
        RequestDispatcher dispatcher=request.getRequestDispatcher("contract_detail/create.jsp");
        request.setAttribute("message", "New contract detail was created");
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
                listContractDetail(request, response);
                break;
        }
    }

    private void listContractDetail(HttpServletRequest request, HttpServletResponse response) {
        List<ContractDetail> contractDetailList=this.contractDetailService.findAll();
        request.setAttribute("contractDetailList",contractDetailList);
        try {
            request.getRequestDispatcher("contract_detail/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("contractList",contractService.findAll());
        request.setAttribute("attachList",attachService.findAll());
        try {
            request.getRequestDispatcher("contract_detail/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
