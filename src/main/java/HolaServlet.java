import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class HolaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println("<html><body>");
        pw.println("<h1>Ejercicio 1: Hola Mundo</h1>");
        pw.println("<br><a href='index.html'>Menú</a>");
        pw.println("</body></html>");
        pw.close();
    }
}
