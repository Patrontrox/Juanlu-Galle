import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej4L {
    public static void main(String[] args) {
        try {
            // Ejecuta el comando "ps -e" y obtiene el resultado
            Process process = Runtime.getRuntime().exec("ps -e");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                // Filtra y muestra solo los procesos
                System.out.println(line);
            }

            // Cierra el lector
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
