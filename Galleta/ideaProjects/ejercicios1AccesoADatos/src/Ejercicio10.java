import java.io.BufferedWriter;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] array = new double[0];
        int filas = 0;
        int columnas = 0;

        try {
            System.out.print("Introduce el número de filas del array: ");
            filas = scanner.nextInt();
            System.out.print("Introduce el número de columnas del array: ");
            columnas = scanner.nextInt();
            array = new double[filas * columnas];

            for (int i = 0; i < filas * columnas; i++) {
                System.out.print("Introduce el valor del elemento " + (i+1) + ": ");
                array[i] = scanner.nextDouble();
            }

            BufferedWriter escritor = new BufferedWriter(new FileWriter("array.txt"));
            escritor.write(filas + "\n");
            escritor.write(columnas + "\n");

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    escritor.write(array[i * columnas + j] + " ");
                }
                escritor.write("\n");
            }

            escritor.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }
}
