import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej5L {
    public static void main(String[] args) throws IOException {
        try {
            Process process = Runtime.getRuntime().exec("ls -al");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;

            int sumaTamaños = 0;
            int mayorTamaño = 0;

            while ((linea = reader.readLine()) != null) {
                // Ver los datos de la columna que queremos
                String[] columns = linea.split("\\s+");
                if (columns.length >= 5) {
                    try {
                        int size = Integer.parseInt(columns[2]);
                        sumaTamaños += size;
                        if (size > mayorTamaño) {
                            mayorTamaño = size;
                        }
                    } catch (NumberFormatException e) { }
                }
            }
            reader.close();

            System.out.println("Los ficheros en conjunto tienen un tamaño de: " + sumaTamaños);
            System.out.println("El fichero que tiene un tamaño mayor es " + mayorTamaño);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}