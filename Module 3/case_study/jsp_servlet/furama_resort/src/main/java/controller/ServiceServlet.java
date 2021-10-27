package controller;

import model.bean.Customer;
import model.bean.Service;
import model.service.Impl.ServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet",urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private model.service.Service services=new ServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request,response);
                break;
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        int area= Integer.parseInt(request.getParameter("area"));
        Double cost= Double.valueOf(request.getParameter("cost"));
        int people= Integer.parseInt(request.getParameter("people"));
        String rent=request.getParameter("rent_type");
        String type=request.getParameter("type");
        String room=request.getParameter("room");
        String desc=request.getParameter("desc");
        Double pool= Double.valueOf(request.getParameter("pool"));
        int floor= Integer.parseInt(request.getParameter("floor"));
        Service service=new Service(id,name,area,cost,people,room,desc,pool,floor,rent,type);
        this.services.create(service);
        RequestDispatcher dispatcher=request.getRequestDispatcher("service/create.jsp");
        request.setAttribute("message", "New service was created");
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
                listService(request, response);
                break;
        }
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList=this.services.findAll();
        request.setAttribute("serviceList",serviceList);
        try {
            request.getRequestDispatcher("/service/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/service/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
