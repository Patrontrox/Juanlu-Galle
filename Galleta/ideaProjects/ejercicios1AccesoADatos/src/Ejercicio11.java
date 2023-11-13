import java.io.DataInputStream;
        import java.io.EOFException;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.IOException;

public class Ejercicio11 {
    public static void main(String[] args) {
        try {
            File archivo = new File("datos.dat");
            DataInputStream entrada = new DataInputStream(new FileInputStream(archivo));
            int numero;

            while (true) {
                try {
                    numero = entrada.readInt();
                    System.out.println(numero);
                } catch (EOFException e) {
                    break;
                }
            }

            entrada.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }
}
