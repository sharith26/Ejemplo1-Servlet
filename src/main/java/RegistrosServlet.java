import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registros")
public class RegistrosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String guardado = request.getParameter("guardado");

        PrintWriter pw = response.getWriter();
        pw.println("<!DOCTYPE html><html lang='es'><head><meta charset='UTF-8'>");
        pw.println("<title>Registros guardados</title></head><body>");
        pw.println("<h1>Registros guardados</h1>");

        if ("get".equals(guardado)) {
            pw.println("<p><b>¡Dato del formulario GET guardado correctamente!</b></p>");
        } else if ("post".equals(guardado)) {
            pw.println("<p><b>¡Dato del formulario POST guardado correctamente!</b></p>");
        }

        pw.println("<p>Archivos guardados en: <code>" + Almacen.esc(Almacen.carpeta().toString()) + "</code></p>");

        tabla(pw, "Ejercicio 4 (GET)", Almacen.leer("get"));
        tabla(pw, "Ejercicio 5 (POST)", Almacen.leer("post"));

        pw.println("<br><a href='ejercicio4.html'>Formulario GET</a> | ");
        pw.println("<a href='ejercicio5.html'>Formulario POST</a> | ");
        pw.println("<a href='index.html'>Menú</a>");
        pw.println("</body></html>");
        pw.close();
    }

    private void tabla(PrintWriter pw, String titulo, List<String[]> filas) {
        pw.println("<h2>" + titulo + "</h2>");
        if (filas.isEmpty()) {
            pw.println("<p>Aún no hay registros.</p>");
            return;
        }
        pw.println("<table border='1' cellpadding='6' cellspacing='0'>");
        pw.println("<tr><th>#</th><th>Fecha y hora</th><th>Valor</th></tr>");
        int n = 1;
        for (String[] fila : filas) {
            pw.println("<tr><td>" + n++ + "</td><td>" + Almacen.esc(fila[0]) + "</td><td>"
                    + Almacen.esc(fila[1]) + "</td></tr>");
        }
        pw.println("</table>");
    }
}