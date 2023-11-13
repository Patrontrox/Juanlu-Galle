package com.juanlu.proyecto1.Controladores;

import javafx.scene.control.Alert;

public class ShowAlert {

    public static void info(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensaje de información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();
    }

    public static void error(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Mensaje de error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();
    }

    public static void aviso(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Mensaje de aviso");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();
    }


}
