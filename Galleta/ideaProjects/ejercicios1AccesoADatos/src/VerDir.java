import java.io.File;
import java.util.Scanner;

public class VerDir {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        boolean bool2 = false;

        System.out.println("¿Quieres crear un nuevo directorio dentro de NUEVODIR? y/n");
        String resp = teclado.next();
        String resp2 = null;
        String resp3 = null;
        if (resp.equals("y")) {
            System.out.println("Nombre del nuevo directorio: ");
            String nuevo = teclado.next();
            File nu = new File("D:\\Desktop\\2º DAM A(Mañana)\\NUEVODIR\\" + nuevo);
            bool2 = nu.mkdirs();
            System.out.print("\nDirectorio dentro de directorio: \n" + bool2);
        } else {
            System.out.println("¿Quieres renombrar un directorio dentro de NUEVODIR? y/n");
            resp2 = teclado.next();
            if (resp2.equals("y")) {
                String directorio;
                String renombre;
                boolean bool3 = false;
                System.out.println("¿Que directorio quieres renombrar?");
                directorio = teclado.next();
                File directorioR = new File("D:\\Desktop\\2º DAM A(Mañana)\\NUEVODIR\\" + directorio);
                System.out.println("¿Como lo quieres renombrar?");
                renombre = teclado.next();
                File directR = new File("D:\\Desktop\\2º DAM A(Mañana)\\NUEVODIR\\" + renombre);
                bool3 = directorioR.renameTo(directR);
                System.out.print("\nDirectorio renombrado: \n" + bool3);
            } else {
                System.out.println("¿Quieres borrar un directorio dentro de NUEVODIR? y/n");
                resp3 = teclado.next();
                if (resp3.equals("y")) {
                    String borrar;
                    boolean bool4 = false;
                    System.out.println("¿Que directorio quieres borrar?");
                    borrar = teclado.next();
                    File borr = new File("D:\\Desktop\\2º DAM A(Mañana)\\NUEVODIR\\" + borrar);
                    bool4 = borr.delete();
                    System.out.print("\nDirectorio borrado: \n" + bool4);

                } else {

                    String direccion = "D:\\Desktop";
                    String direccion2 = "D:\\Desktop\\2º DAM A(Mañana)\\Acceso a datos";
                    String direct = "D:\\Desktop\\2º DAM A(Mañana)\\NUEVODIR";
                    File a = new File(direccion);
                    File n = new File(direccion2);
                    File d = new File(direct);

                    boolean bool = false;
                    bool = d.mkdir();
                    String[] archivos = a.list();
                    System.out.printf("Ficheros del directorio actual:  %d %n", archivos.length);
                    for (int i = 0; i < archivos.length; i++) {
                        File a2 = new File(a, archivos[i]);
                        System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n \n", archivos[i], a2.isFile(), a2.isDirectory());
                    }

                    System.out.println("Información: ");
                    System.out.printf("Nombre: %s, \n Ruta: %s, \n Ultima modificación: %d, \n Tamaño del archivo: %d. \n",
                            n.getName(), n.getPath(), n.lastModified(), n.length());

                    System.out.print("Creación del directorio NUEVODIR: \n" + bool);

                }
            }
        }
    }
}

