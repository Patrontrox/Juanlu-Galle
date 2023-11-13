package UT1Ficheros.Ej1;
/*
@author José Enrique Gallego León
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class ContarVocales {
    public static void main(String[] args) {
        /*
        Verifica si se proporcionaron nombres de archivos como argumentos al ejecutar el programa.
        Si no se proporcionaron argumentos, se muestra un mensaje de error y el programa termina.
         */
        if (args.length == 0) {
            System.out.println("Debe proporcionar nombres de archivos como argumentos.");
            return;
        }

        for (String nombreArchivo : args) {
            //Crea un objeto de tipo File que representa el archivo en el sistema de archivos.
            File archivo = new File(nombreArchivo);
            //Si el archivo existe, se procede a contar el número de vocales en el archivo.
            if (archivo.exists()) {
                //La función contarVocalesEnArchivo se encarga de contar el número de vocales en un archivo dado
                int contadorVocales = contarVocalesEnArchivo(archivo);
                System.out.println("Archivo: " + nombreArchivo + ", Número de vocales: " + contadorVocales);
            } else {
                System.out.println("Error: El archivo " + nombreArchivo + " no existe.");
            }
        }
    }

    /*
    Dentro de la función contarVocalesEnArchivo, se inicializa un contador de vocales en cero.
     */
    public static int contarVocalesEnArchivo(File archivo) {
        int contadorVocales = 0;
        try (FileInputStream fis = new FileInputStream(archivo);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            int c;
            /*
            Se utiliza un bucle while para leer cada carácter del archivo.
            El método read() de la clase BufferedReader devuelve el siguiente carácter como un entero.
            Si se llega al final del archivo, devuelve -1.
             */
            while ((c = br.read()) != -1) {
                char caracter = (char) c;
                /*
                Se llama a la función esVocal para verificar si el carácter es una vocal.
                Si es así, se incrementa el contador de vocales.
                 */
                if (esVocal(caracter)) {
                    contadorVocales++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contadorVocales;
    }
    //Función para comprobar si es vocal
    public static boolean esVocal(char caracter) {
        char c = Character.toLowerCase(caracter);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}