import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns ={"","/list"} )
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(  432, "Nguyen Van A",
                "09/04/2021", 1, 4.0));
        studentList.add(new Student (986,"Nguyen Van B",
                "10/04/2021", 0,  6.0));
        studentList.add(new Student ( 876, "Le Van C",
                "11/04/2021",  2, 9.0));
        request.setAttribute( "studentListServlet", studentList);
        request.getRequestDispatcher("list_by_jstl.jsp"). forward(request, response);
    }
}
