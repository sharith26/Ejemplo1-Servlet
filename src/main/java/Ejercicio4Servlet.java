import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicio4Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Datos GET Recibidos</h1>");
        out.println("<p>Nombre: " + nombre + "</p>");
        out.println("<p>Correo: " + correo + "</p>");
        out.println("<a href='ejercicio4.html'>Volver</a></body></html>");
    }
}