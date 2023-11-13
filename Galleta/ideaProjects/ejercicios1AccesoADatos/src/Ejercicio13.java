import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileOutputStream;
        import java.io.IOException;

public class Ejercicio13 {
    public static void main(String[] args) {
        String rutaOriginal = "ruta/a/la/imagen.jpg";
        String rutaCopia = "ruta/a/la/copia.jpg";

        try {
            // Abrir el archivo original
            FileInputStream inputStream = new FileInputStream(new File(rutaOriginal));

            // Crear un nuevo archivo para la copia
            FileOutputStream outputStream = new FileOutputStream(new File(rutaCopia));

            // Copiar los bytes del archivo original al archivo de copia
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer))!= -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // Cerrar los archivos
            inputStream.close();
            outputStream.close();

            System.out.println("Imagen copiada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al copiar la imagen: " + e.getMessage());
        }
    }
}
