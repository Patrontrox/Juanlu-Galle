import java.io.BufferedOutputStream;
        import java.io.DataOutputStream;
        import java.io.FileOutputStream;
        import java.io.IOException;

public class Ejercicio14 {
    public static void main(String[] args) {
        String[] descripciones = {"Pedido 1", "Pedido 2", "Pedido 3"};
        int[] numUnidades = {10, 20, 30};
        double[] precios = {10.5, 20.5, 30.5};

        try {
            // Abrir el archivo para escritura
            FileOutputStream fileOutputStream = new FileOutputStream("pedidos.dat");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);

            // Guardar los pedidos en el archivo
            for (int i = 0; i < descripciones.length; i++) {
                dataOutputStream.writeUTF(descripciones[i]);
                dataOutputStream.writeInt(numUnidades[i]);
                dataOutputStream.writeDouble(precios[i]);
            }

            // Cerrar el archivo
            dataOutputStream.close();
            bufferedOutputStream.close();
            fileOutputStream.close();

            System.out.println("Pedidos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los pedidos: " + e.getMessage());
        }
    }
}
