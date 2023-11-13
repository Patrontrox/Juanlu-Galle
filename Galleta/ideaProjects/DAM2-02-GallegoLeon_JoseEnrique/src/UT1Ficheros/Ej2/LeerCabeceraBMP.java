package UT1Ficheros.Ej2;

import java.io.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class LeerCabeceraBMP {
    public static void main(String[] args) {
        try {
            //FileInputStream lee los primeros 54 bytes del archivo, que corresponden a la cabecera del archivo BMP
            FileInputStream archivo = new FileInputStream("tanque-lleno-alta-definicion_866593-1545.bmp");
            byte[] cabecera = new byte[54];
            archivo.read(cabecera);
            archivo.close();

            //Si los primeros dos bytes de la cabecera son 'B' y 'M', se considera que el archivo es un BMP válido
            if (cabecera[0] == 'B' && cabecera[1] == 'M') {
                System.out.println("Parece un BMP válido");
                // El programa extrae la información del ancho, alto y tamaño de la imagen de los bytes correspondientes en la cabecera
                int ancho = (cabecera[18] & 0xFF) | ((cabecera[19] & 0xFF) << 8) | ((cabecera[20] & 0xFF) << 16) | ((cabecera[21] & 0xFF) << 24);
                int alto = (cabecera[22] & 0xFF) | ((cabecera[23] & 0xFF) << 8) | ((cabecera[24] & 0xFF) << 16) | ((cabecera[25] & 0xFF) << 24);
                int tamano = (cabecera[34] & 0xFF) | ((cabecera[35] & 0xFF) << 8) | ((cabecera[36] & 0xFF) << 16) | ((cabecera[37] & 0xFF) << 24);
                boolean comprimido = tamano < (ancho * alto * 3 + 54);

                // Muestra la información obtenida de la cabecera, como el ancho, el alto, si está comprimido y el tamaño del archivo
                System.out.println("Ancho: " + ancho);
                System.out.println("Alto: " + alto);
                System.out.println("Comprimido: " + (comprimido ? "Sí" : "No"));
                System.out.println("Tamaño: " + tamano + " bytes");
            } else {
                System.out.println("No es un BMP válido");
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al leer el archivo");
        }
        System.out.println("");
                try {
                    // Lee una imagen GIF desde una URL utilizando la clase URL y ImageIO
                    URL url = new URL("https://imgs.search.brave.com/l9hJSkQaoF2bEQ9PKYNTys_Qt3l1WyY_CjbkGcmhPtY/rs:fit:860:0:0/g:ce/aHR0cHM6Ly93d3cu/Y2hpcXVpcGVkaWEu/Y29tL2ltYWdlbmVz/L2dpZnMtZGlidWpv/cy1hbmltYWRvcy10/aXRldWYtMS5naWY.gif"); // Reemplaza la URL con la ubicación de tu imagen GIF

                    //La almacena en un objeto BufferedImage
                    BufferedImage imagen = ImageIO.read(url);

                    //Obtiene información sobre la imagen, como la versión del formato GIF, el ancho, el alto y la cantidad de colores
                    Object versionProperty = imagen.getProperty("version");
                    int version = versionProperty instanceof Integer ? (int) versionProperty : -1;
                    int ancho = imagen.getWidth();
                    int alto = imagen.getHeight();
                    int cantidadColores = imagen.getColorModel().getColorSpace().getNumComponents();

                    System.out.println("Versión: " + version);
                    System.out.println("Ancho: " + ancho + " píxeles");
                    System.out.println("Alto: " + alto + " píxeles");
                    System.out.println("Cantidad de colores: " + cantidadColores);
                } catch (IOException e) {
                    System.out.println("Error al leer la imagen");
                }
            }
    }
