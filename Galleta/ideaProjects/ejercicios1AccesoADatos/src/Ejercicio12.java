import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

    public class Ejercicio12 {
        public static void main(String[] args) {
            try {
                BufferedReader lector = new BufferedReader(new FileReader("array.txt"));
                String filas = lector.readLine();
                String columnas = lector.readLine();
                double[] array = new double[Integer.parseInt(filas) * Integer.parseInt(columnas)];

                for (int i = 0; i < array.length; i++) {
                    String valor = lector.readLine();
                    array[i] = Double.parseDouble(valor);
                }

                lector.close();

                for (int i = 0; i < Integer.parseInt(filas); i++) {
                    for (int j = 0; j < Integer.parseInt(columnas); j++) {
                        System.out.print(array[i * Integer.parseInt(columnas) + j] + " ");
                    }
                    System.out.println();
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo.");
            }
        }
    }

