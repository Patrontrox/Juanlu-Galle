package UT1Ficheros.Ej5;

public class Main {
    public static void main(String[] args) {
        Administrar_Cotizacion administrador = new Administrar_Cotizacion();

        // Podremos grabar una cotizacion de esta manera
        Cotizacion_Ej5 cotizacion1 = new Cotizacion_Ej5("Empresa A", 100.50);
        administrador.grabarCotizacion(cotizacion1);

        Cotizacion_Ej5 cotizacion2 = new Cotizacion_Ej5("Empresa B", 75.25);
        administrador.grabarCotizacion(cotizacion2);

        // Así podremos leer las cotizaciones
        System.out.println("Todas las cotizaciones:");
        administrador.leerCotizaciones();

        // Aquí podremos ver el dia y hora de las cotizaciones
        System.out.println("\nCotizaciones para hoy a las 14:30:");
        administrador.verCotizaciones("2023-10-27", "14:30");
    }
}
