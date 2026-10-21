import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicio2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nombre = request.getParameter("nombre");
        if (nombre == null) nombre = "Anónimo";
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Hola " + nombre + " desde Ejercicio2Servlet</h1></body></html>");
    }
}