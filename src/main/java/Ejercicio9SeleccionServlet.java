import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

@WebServlet("/operaciones-seleccion")
public class Ejercicio9SeleccionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String[] ops = request.getParameterValues("operacion");

        try {
            double n1 = Double.parseDouble(request.getParameter("num1").trim().replace(',', '.'));
            double n2 = Double.parseDouble(request.getParameter("num2").trim().replace(',', '.'));

            out.println("<html><body><h1>Resultados</h1>");
            out.println("<p>Número 1: <b>" + fmt(n1) + "</b> | Número 2: <b>" + fmt(n2) + "</b></p>");

            if (ops == null || ops.length == 0) {
                out.println("<p><b>No marcaste ninguna operación.</b> Elige al menos una casilla.</p>");
            } else {
                for (String op : ops) {
                    switch (op) {
                        case "suma":
                            out.println("<p>Suma: " + fmt(n1) + " + " + fmt(n2) + " = <b>" + fmt(n1 + n2) + "</b></p>");
                            break;
                        case "resta":
                            out.println("<p>Resta: " + fmt(n1) + " − " + fmt(n2) + " = <b>" + fmt(n1 - n2) + "</b></p>");
                            break;
                        case "multiplicacion":
                            out.println("<p>Multiplicación: " + fmt(n1) + " × " + fmt(n2) + " = <b>" + fmt(n1 * n2) + "</b></p>");
                            break;
                        case "division":
                            out.println("<p>División: " + fmt(n1) + " ÷ " + fmt(n2) + " = <b>"
                                    + (n2 != 0 ? fmt(n1 / n2) : "No se puede dividir entre cero") + "</b></p>");
                            break;
                        default:
                            break;
                    }
                }
            }
            out.println("<br><a href='ejercicio9.html'>Nueva operación</a> | <a href='index.html'>Menú</a>");
            out.println("</body></html>");
        } catch (Exception e) {
            out.println("<html><body><h3>Por favor ingrese números válidos.</h3>");
            out.println("<a href='ejercicio9.html'>Volver</a></body></html>");
        }
    }

    private String fmt(double d) {
        if (!Double.isFinite(d)) {
            return "indefinido";
        }
        return BigDecimal.valueOf(d).setScale(6, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();
    }
}