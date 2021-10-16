package controller;

import bean.User;
import repository.Impl.UserRepoImpl;
import repository.UserRepo;
import service.Impl.UserServiceImpl;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertUser(request, response);
                break;
            case "edit":
                updateUser(request, response);
                break;
            case "search":
                searchUser(request,response);
                break;
        }
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameSearch");
        List<User> userList=this.userService.findByCountry(name);
        RequestDispatcher dispatcher;
        request.setAttribute("listUser", userList);
        dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(id,name, email, country);
        this.userService.insertUser(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user=this.userService.selectUser(id);
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);
        this.userService.updateUser(user);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "sort":
                sortUser(request,response);
                break;
            default:
                listUser(request, response);
                break;
        }
    }

    private void sortUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList =this.userService.sortByName();
        request.setAttribute("listUser", userList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.userService.deleteUser(id);
        response.sendRedirect("/user");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = this.userService.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = this.userService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }
}


