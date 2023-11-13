package UT1Ficheros.Ej5;

import UT1Ficheros.Ej5.Cotizacion_Ej5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Administrar_Cotizacion {
    private List<Cotizacion_Ej5> cotizaciones = new ArrayList<>();
    private String filePath = "cotizaciones.dat";

    public void grabarCotizacion(Cotizacion_Ej5 cotizacion) {
        cargarCotizaciones();
        cotizaciones.add(cotizacion);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(cotizaciones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerCotizaciones() {
        cargarCotizaciones();
        for (Cotizacion_Ej5 cotizacion : cotizaciones) {
            System.out.println(cotizacion);
        }
    }

    public void verCotizaciones(String dia, String hora) {
        cargarCotizaciones();
        for (Cotizacion_Ej5 cotizacion : cotizaciones) {
            if (cotizacion.getFecha().toString().contains(dia) && cotizacion.getHora().equals(hora)) {
                System.out.println(cotizacion);
            }
        }
    }

    private void cargarCotizaciones() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            List<Cotizacion_Ej5> loadedCotizaciones = (List<Cotizacion_Ej5>) ois.readObject();
            cotizaciones = loadedCotizaciones;

        } catch (IOException | ClassNotFoundException e) {
            // El archivo no existe o está vacío, no hay cotizaciones previas
        }
    }
}