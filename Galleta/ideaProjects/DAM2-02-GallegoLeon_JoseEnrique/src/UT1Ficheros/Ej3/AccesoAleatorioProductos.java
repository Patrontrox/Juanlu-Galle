package UT1Ficheros.Ej3;

import java.io.*;
import java.util.Scanner;

public class AccesoAleatorioProductos {
    //private static final int TAMANIO_REGISTRO = 100;

    public static void main(String[] args) {
        try {
            //Se crea un objeto RandomAccessFile llamado fichero que representa el archivo "productos.dat" en modo de lectura y escritura
            RandomAccessFile fichero = new RandomAccessFile("productos.dat", "rw");
            //Leer la entrada del usuario desde la consola
            Scanner scanner = new Scanner(System.in);

            int opcion;
            /*
            Se muestra un menú de opciones al usuario utilizando el método mostrarMenu(),
            y se utiliza una estructura de control do-while para repetir el proceso hasta que
            el usuario seleccione la opción de salida (opción 5)
             */
            do {
                mostrarMenu();
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        introducirDatos(fichero);
                        break;
                    case 2:
                        borrarProducto(fichero);
                        break;
                    case 3:
                        consultarProducto(fichero);
                        break;
                    case 4:
                        verFichero(fichero);
                        break;
                    case 5:
                        System.out.println("Fin del programa");
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } while (opcion != 5);

            //Después de que el usuario selecciona la opción de salida, se cierra el archivo utilizando el método fichero.close()
            fichero.close();
        } catch (IOException e) {
            System.out.println("Error al abrir el fichero");
        }
    }

    //Creacion del menu
    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1- Introducir datos");
        System.out.println("2- Borrar un producto");
        System.out.println("3- Consultar un producto");
        System.out.println("4- Ver fichero");
        System.out.println("5- Fin");
        System.out.print("Seleccione una opción: ");
    }

    //Permite al usuario ingresar los datos de un nuevo producto y los escribe en el archivo
    private static void introducirDatos(RandomAccessFile fichero) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del producto: ");
        int id = scanner.nextInt();

        // Comprobar si el ID ya existe en el fichero
        if (buscarProducto(fichero, id) != null) {
            System.out.println("El ID del producto ya existe");
            return;
        }

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.next();

        System.out.print("Ingrese el stock del producto: ");
        int stock = scanner.nextInt();

        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        // Escribir los datos en el fichero
        fichero.seek(fichero.length());
        escribirEntero(fichero, id);
        escribirCadena(fichero, nombre, 20);
        escribirEntero(fichero, stock);
        escribirDouble(fichero, precio);

        System.out.println("Datos del producto guardados correctamente");
    }

    //Permite al usuario ingresar el ID de un producto y marca el producto como borrado en el archivo
    private static void borrarProducto(RandomAccessFile fichero) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del producto a borrar: ");
        int id = scanner.nextInt();

        Producto producto = buscarProducto(fichero, id);
        if (producto == null) {
            System.out.println("No se encontró el producto con el ID especificado");
            return;
        }

        // Borrar el producto marcando su ID como -1
        fichero.seek(producto.getPosicion());
        escribirEntero(fichero, -1);

        System.out.println("UT1Ficheros.Ej3.Producto borrado correctamente");
    }

    //Permite al usuario ingresar el ID de un producto y muestra los datos del producto en la consola
    private static void consultarProducto(RandomAccessFile fichero) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del producto a consultar: ");
        int id = scanner.nextInt();

        Producto producto = buscarProducto(fichero, id);
        if (producto == null) {
            System.out.println("No se encontró el producto con el ID especificado");
            return;
        }

        System.out.println("Datos del producto:");
        System.out.println("ID: " + producto.getId());
        System.out.println("Nombre: " + producto.getNombre());
        System.out.println("Stock: " + producto.getStock());
        System.out.println("Precio: " + producto.getPrecio());
    }

    //Muestra todos los productos almacenados en el archivo en la consola
    private static void verFichero(RandomAccessFile fichero) throws IOException {
        fichero.seek(0);

        System.out.println("Contenido del fichero:");
        while (fichero.getFilePointer() < fichero.length()) {
            int id = leerEntero(fichero);
            String nombre = leerCadena(fichero, 20);
            int stock = leerEntero(fichero);
            double precio = leerDouble(fichero);

            if (id != -1) {
                System.out.println("ID: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Stock: " + stock);
                System.out.println("Precio: " + precio);
                System.out.println("--------------------");
            }
        }
    }

    /*
    Busca un producto en el archivo utilizando su ID y devuelve un objeto
    Producto si se encuentra, o null si no se encuentra
    */
    private static Producto buscarProducto(RandomAccessFile fichero, int id) throws IOException {
        fichero.seek(0);

        while (fichero.getFilePointer() < fichero.length()) {
            int posicion = (int) fichero.getFilePointer();
            int productoId = leerEntero(fichero);

            if (productoId == id) {
                String nombre = leerCadena(fichero, 20);
                int stock = leerEntero(fichero);
                double precio = leerDouble(fichero);

                return new Producto(productoId, nombre, stock, precio, posicion);
            }
        }

        return null;
    }

    //Escribe un entero en el archivo.
    private static void escribirEntero(RandomAccessFile fichero, int valor) throws IOException {
        fichero.writeInt(valor);
    }

    //Lee un entero del archivo
    private static int leerEntero(RandomAccessFile fichero) throws IOException {
        return fichero.readInt();
    }

    //Escribe una cadena de caracteres en el archivo con una longitud específica
    private static void escribirCadena(RandomAccessFile fichero, String cadena, int longitud) throws IOException {
        StringBuilder builder = new StringBuilder(cadena);
        builder.setLength(longitud);
        fichero.writeChars(builder.toString());
    }

    //Lee una cadena de caracteres del archivo con una longitud específica
    private static String leerCadena(RandomAccessFile fichero, int longitud) throws IOException {
        char[] buffer = new char[longitud];
        for (int i = 0; i < longitud; i++) {
            buffer[i] = fichero.readChar();
        }
        return new String(buffer).replace('\0', ' ');
    }

    //Escribe un número de tipo double en el archivo
    private static void escribirDouble(RandomAccessFile fichero, double valor) throws IOException {
        fichero.writeDouble(valor);
    }

    //Lee un número de tipo double del archivo
    private static double leerDouble(RandomAccessFile fichero) throws IOException {
        return fichero.readDouble();
    }
}

//Creacion del objeto producto
class Producto {
    private final int id;
    private final String nombre;
    private final int stock;
    private final double precio;
    private final int posicion;

    public Producto(int id, String nombre, int stock, double precio, int posicion) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.posicion = posicion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public int getPosicion() {
        return posicion;
    }
}
