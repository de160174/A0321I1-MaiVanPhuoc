package controller;

import model.bean.BenhAn;
import model.bean.Product;
import model.service.BenhAnService;
import model.service.BenhNhanService;
import model.service.Impl.BenhAnServiceImpl;
import model.service.Impl.BenhNhanServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BenhAnServlet", urlPatterns = "/benhAn")
public class BenhAnServlet extends HttpServlet {
    private BenhAnService benhAnService=new BenhAnServiceImpl();
    private BenhNhanService benhNhanService=new BenhNhanServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                editBenhAn(request,response);
                break;
        }
    }

    private void editBenhAn(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String start=request.getParameter("start");
        String end=request.getParameter("end");
        String lyDo=request.getParameter("lyDo");
        String BNid=request.getParameter("BNid");
        BenhAn benhAn=this.benhAnService.findById(id);
        benhAn.setBenh_nhan_id(BNid);
        benhAn.setBenh_nhan_name(name);
        benhAn.setNgay_nhap(start);
        benhAn.setNgay_ra(end);
        benhAn.setLy_do(lyDo);
        this.benhAnService.update(benhAn);
        RequestDispatcher dispatcher=request.getRequestDispatcher("benh_an/edit.jsp");
        request.setAttribute("message", "Thông tin bệnh án đã được cập nhật");
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
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
                deleteBenhAn(request,response);
                break;
            default:
                listBenhAn(request, response);
                break;
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("id");
        BenhAn benhAn=this.benhAnService.findById(id);
        request.setAttribute("benhAn",benhAn);
        request.setAttribute("listBenhNhan", benhNhanService.findAll());
        try {
            request.getRequestDispatcher("benh_an/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteBenhAn(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("benh_an_id");
        this.benhAnService.delete(id);
        try {
            response.sendRedirect("/benhAn");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listBenhAn(HttpServletRequest request, HttpServletResponse response) {
        List<BenhAn> benhAnList=this.benhAnService.findAll();
        request.setAttribute("benhAnList",benhAnList);
        try {
            request.getRequestDispatcher("benh_an/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
