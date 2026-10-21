import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicio7Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userAgent = request.getHeader("User-Agent");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Info del Cliente</h1>");
        out.println("<p>User-Agent: " + userAgent + "</p></body></html>");
    }
}