import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float num1=Float.parseFloat(request.getParameter("number1"));
        float num2=Float.parseFloat(request.getParameter("number2"));
        char operator=request.getParameter("operator").charAt(0);
        PrintWriter writer=response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result:</h1>");
        try{
            float result=Calculator.calculate(num1,num2,operator);
            writer.println(num1 + " " + operator + " " + num2 + " = " + result);
        }catch (Exception e){
            writer.println(e.getMessage());
        }
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
