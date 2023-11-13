import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej4W {
    public static void main(String[] args) {
        try {
            // Ejecuta el comando "tasklist" y obtiene el resultado
            Process process = Runtime.getRuntime().exec("tasklist");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                // Filtra y muestra solo los servicios
                if (line.toLowerCase().contains(".exe") || line.toLowerCase().contains("svchost.exe")) {
                    System.out.println(line);
                }
            }

            // Cierra el lector
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}