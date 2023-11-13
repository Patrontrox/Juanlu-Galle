import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileOutputStream;
        import java.io.IOException;

public class Ejercicio8 {
    public static void main(String[] args) {
        String rutaOrigen = "ruta/al/archivo/origen.txt";
        String rutaDestino = "ruta/al/directorio/destino";

        copiaArchivo(rutaOrigen, rutaDestino);
    }

    public static void copiaArchivo(String rutaOrigen, String rutaDestino) {
        try {
            String archivoOrigen = String.valueOf(new File(rutaOrigen));
            File directorioDestino = new File(rutaDestino);

            if (directorioDestino.isDirectory()) {
                String nombreArchivo = archivoOrigen;
                File archivoDestino = new File(directorioDestino, nombreArchivo);
                copiaArchivo(archivoOrigen, String.valueOf(archivoDestino));
            } else {
                FileInputStream entrada = new FileInputStream(archivoOrigen);
                FileOutputStream salida = new FileOutputStream(rutaDestino);
                int caracter;

                while ((caracter = entrada.read())!= -1) {
                    salida.write(caracter);
                }

                entrada.close();
                salida.close();
            }
        } catch (IOException e) {
            System.out.println("Error al copiar el archivo.");
        }
    }
}
