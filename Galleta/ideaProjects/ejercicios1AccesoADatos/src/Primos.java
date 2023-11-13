import java.io.FileWriter;
        import java.io.IOException;

public class Primos {
    public static void main(String[] args) {
        try {
            FileWriter archivo = new FileWriter("numprimos.txt");
            int contador = 0;
            for (int i = 2; contador < 20; i++) {
                if (EsPrimo(i)) {
                    archivo.write(i + "\n");
                    contador++;
                }
            }
            archivo.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }

        try {
            FileWriter archivo = new FileWriter("numprimos.txt");
            String linea;
            while ((linea = archivo.toString())!= null) {
                System.out.println(linea);
            }
            archivo.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    public static boolean EsPrimo(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
