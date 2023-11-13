package com.juanlu.proyecto1.Controladores;

import com.juanlu.proyecto1.Modelos.Empleado;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class InicioSesion {

    private final PasswordField contrasena;
    private final TextField usuario;
    Empleado empleado = null;

    public InicioSesion(PasswordField contrasena, TextField usuario) {
        this.contrasena = contrasena;
        this.usuario = usuario;
    }

    public boolean iniciando() {
        try {
            empleado = Empleado.getEmpleado(usuario.getText());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (empleado != null && empleado.getPass().equals(contrasena.getText())) return true;

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Mensaje del sistema");
        alert.setHeaderText(null);
        alert.setContentText("Usuario o contraseña incorrectos, inténtelo de nuevo.");

        alert.showAndWait();
        usuario.setText("");
        contrasena.setText("");
        return false;
    }

    public Empleado getusr() {
        return empleado;
    }
}
