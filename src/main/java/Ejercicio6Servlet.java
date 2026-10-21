import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicio6Servlet extends HttpServlet {
    private int contador = 0;

    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        contador++;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Contador de Visitas: " + contador + "</h1></body></html>");
    }
}