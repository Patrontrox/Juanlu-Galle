import java.io.*;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
public class Ejercicio15 {
    public Ejercicio15(String s, int i, double v) {
    }

    public class GuardarPedidos {
        public static <Pedido> void main(String[] args) {
            ArrayList<Ejercicio15> pedidos = new ArrayList<>();

            pedidos.add(new Ejercicio15("Pedido 1", 10, 10.5));
            pedidos.add(new Ejercicio15("Pedido 2", 20, 20.5));
            pedidos.add(new Ejercicio15("Pedido 3", 30, 30.5));

            try {
                FileOutputStream fileOut = new FileOutputStream("pedidos.dat");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);

                for (Ejercicio15 pedido : pedidos) {
                    out.writeObject(pedido);
                }

                out.close();
                fileOut.close();
                System.out.println("Los pedidos se han guardado correctamente.");
            } catch (Exception e) {
                System.out.println("Se ha producido un error al guardar los pedidos: " + e.getMessage());
            }
        }
    }

    public class VisualizarPedidos {

        String descripcion;
        int NumUnidades;
        int Precio;

        public VisualizarPedidos(String descripcion, int numUnidades, int precio) {
            this.descripcion = descripcion;
            NumUnidades = numUnidades;
            Precio = precio;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public int getNumUnidades() {
            return NumUnidades;
        }

        public void setNumUnidades(int numUnidades) {
            NumUnidades = numUnidades;
        }

        public int getPrecio() {
            return Precio;
        }

        public void setPrecio(int precio) {
            Precio = precio;
        }

        public static <Pedido> void main(String[] args) {
            ArrayList<Ejercicio15> pedidos = new ArrayList<>();


            try {
                FileInputStream fileIn = new FileInputStream("pedidos.dat");
                ObjectInputStream in = new ObjectInputStream(fileIn);

                while (true) {
                    Pedido pedido = (Pedido) in.readObject();
                    pedidos.add((Ejercicio15) pedido);
                }
            } catch (EOFException e) {
                // Se llegó al final del archivo
            } catch (Exception e) {
                System.out.println("Se ha producido un error al visualizar los pedidos: " + e.getMessage());
            }

            for (Ejercicio15 pedido : pedidos) {
                System.out.println("Descripción: " + pedido.getClass());
                System.out.println("Número de unidades: " + pedido.getNumUnidades());
                System.out.println("Precio: " + pedido.getPrecio());
                System.out.println();
            }
        }
    }

    private String getPrecio() {
        return getPrecio();
    }

    private String getNumUnidades() {
        return getNumUnidades();
    }


}
