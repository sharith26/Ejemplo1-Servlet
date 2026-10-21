import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicio8Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body><table border='1'><tr><th>Número</th><th>Cuadrado</th></tr>");
        for (int i = 1; i <= 10; i++) {
            out.println("<tr><td>" + i + "</td><td>" + (i * i) + "</td></tr>");
        }
        out.println("</table></body></html>");
    }
}