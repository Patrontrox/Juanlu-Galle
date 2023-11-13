import java.io.IOException;

public class Ej7L {
    public static void main(String[] args) {
        // Arrancar un proceso
        Process proceso = null;
        try {
            proceso = Runtime.getRuntime().exec("snap-store");
            System.out.println("Proceso arrancado.");
        } catch (IOException e) {
            System.out.println("Error al arrancar el proceso: " + e.getMessage());
        }

        // Comunicarse con el proceso
        if (proceso != null) {
            // Leer la salida del proceso
            try {
                java.io.InputStream inputStream = proceso.getInputStream();
                java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println("Salida del proceso: " + linea);
                }
            } catch (IOException e) {
                System.out.println("Error al leer la salida del proceso: " + e.getMessage());
            }

            // Detener el proceso
            proceso.destroy();
            System.out.println("Proceso detenido.");
        }
    }
}
