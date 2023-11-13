import java.io.BufferedOutputStream;
        import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
        import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataOutputStream salida = null;

        try {
            salida = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("datos.dat")));

            System.out.print("Introduce un número entero (o 0 para salir): ");
            int numero = scanner.nextInt();

            while (numero!= 0) {
                salida.writeInt(numero);
                System.out.print("Introduce un número entero (o 0 para salir): ");
                numero = scanner.nextInt();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        } finally {
            try {
                if (salida!= null) {
                    salida.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo.");
            }
        }
    }
}
