import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicio5Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("contrasena");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Datos POST Procesados</h1>");
        out.println("<p>Usuario: " + usuario + "</p>");
        out.println("<p>Contraseña: " + pass + "</p>");
        out.println("<a href='ejercicio5.html'>Volver</a></body></html>");
    }
}