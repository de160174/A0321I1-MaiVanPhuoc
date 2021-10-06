import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "DiscountServlet",urlPatterns = "/discount")
public class DiscountServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        float price = Float.parseFloat(request.getParameter("txtPrice"));
        float percent = Float.parseFloat(request.getParameter("txtPercent"));
        float amount = (float) (price * percent * 0.01);
        double total =  price-amount;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Discount Amount: " + amount+ "</h1>");
        writer.println("<h1>Discount Price: " + total+ "</h1>");
        writer.println("</html>");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
