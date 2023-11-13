package com.juanlu.proyecto1.Controladores;

import java.net.URL;
import java.util.ResourceBundle;

import com.juanlu.proyecto1.Modelos.Empleado;
import com.juanlu.proyecto1.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ControladorLogin implements Initializable {

    @FXML
    private Button isesion;

    @FXML
    private PasswordField tfContrasena;

    @FXML
    private TextField tfUsuario;

    @FXML
    void handleKey(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) isesion.fire();
    }

    @FXML
    public void handleButtonAction(ActionEvent event) {
        InicioSesion inicio = new InicioSesion(tfContrasena, tfUsuario);
        Stage stage = (Stage) isesion.getScene().getWindow();
        if (inicio.iniciando()) mostrarMenu(stage, inicio.getusr());

    }

    public void mostrarMenu(Stage stage, Empleado emp) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("opcionesMenu.fxml"));
            Scene scene = new Scene(loader.load());
            ControladorInformacion controller = loader.getController();
            controller.setStage(stage);
            controller.setUsuario(emp);
            stage.setScene(scene);
            stage.setTitle("Opciones Menú");
            stage.centerOnScreen();
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleKeyEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            TextField field = (TextField) event.getSource();
            if (field.getId().equals("tfUsuario")) isesion.fire();
            if (field.getId().equals("tfContrasena")) isesion.fire();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void salir() {
        System.exit(0);
    }

    public void setState(Stage stage) {
    }
}
