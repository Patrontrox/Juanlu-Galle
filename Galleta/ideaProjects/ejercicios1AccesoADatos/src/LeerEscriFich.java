import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerEscriFich {
    public static void main(String[] args) {
        // Verificar si se especificó un archivo como argumento
        if (args.length == 0) {
            System.out.println("Debe especificar un archivo como argumento.");
            return;
        }

        // Abrir el archivo especificado en la línea de comandos
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String linea;
            // Leer el contenido del archivo y imprimir cada línea
            while ((linea = br.readLine())!= null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
