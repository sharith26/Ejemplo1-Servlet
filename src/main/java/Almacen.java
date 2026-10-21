import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private static final Path CARPETA = Paths.get(System.getProperty("user.home"), "ejemplo1-datos");
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static Path carpeta() {
        return CARPETA;
    }

    public static synchronized void guardar(String tipo, String valor) throws IOException {
        Files.createDirectories(CARPETA);
        String limpio = valor.replace("\t", " ").replace("\r", " ").replace("\n", " ");
        String linea = LocalDateTime.now().format(FMT) + "\t" + limpio + System.lineSeparator();
        Files.writeString(CARPETA.resolve(tipo + ".txt"), linea, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public static synchronized List<String[]> leer(String tipo) throws IOException {
        List<String[]> filas = new ArrayList<>();
        Path archivo = CARPETA.resolve(tipo + ".txt");
        if (!Files.exists(archivo)) {
            return filas;
        }
        for (String linea : Files.readAllLines(archivo, StandardCharsets.UTF_8)) {
            String[] partes = linea.split("\t", 2);
            if (partes.length == 2) {
                filas.add(partes);
            }
        }
        return filas;
    }

    public static String esc(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&#39;");
    }
}