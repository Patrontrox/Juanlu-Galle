package com.juanlu.proyecto1.Controladores;

import com.juanlu.proyecto1.Modelos.Empleado;
import com.juanlu.proyecto1.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ControladorInformacion {

    @FXML
    private Button btCerrarSesion;
    private Stage stage;

    @FXML
    private Button bAtras;

    @FXML
    void handleConsultas(ActionEvent event) {
        try {

            //Cargar la vista
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("consultas.fxml"));

            //Cargar la ventana
            Parent root = loader.load();

            //creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Realizar consultas accediendo a la BD");
            ControladorConsultas controlador = loader.getController();
            controlador.setState(stage);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            ShowAlert.error("Error al abrir la ventana de consultas");
        }
    }

    @FXML
    private Button btConsultas;

    @FXML
    private Button bdepartamento;

    @FXML
    private Button bes;

    @FXML
    private Button btEmpleado;


    private static Empleado empLogin;

    private static ControladorLogin controladorLogin;

    @FXML
    void handleEntradaSalida(ActionEvent event) {
        try {

            //Cargar la vista
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("entradaSalida.fxml"));

            //Cargar la ventana
            Parent root = loader.load();

            //creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Fichajes empleados");
            ControladorFichajes controlador = loader.getController();
            controlador.setStage(stage);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            ShowAlert.error("Error al abrir la ventana de los fichajes");
        }
    }


    @FXML
    void handleSalir(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void handleCerrarSesion(ActionEvent event) {
        //TODO new InicioSesion();
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(loader.load());
            ControladorLogin controller = loader.getController();
            controller.setState(stage);
            stage.setScene(scene);
            stage.setTitle("Opciones Menú");
            stage.centerOnScreen();
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleShowFormEmployee(ActionEvent event) {
        try {

            //Cargar la vista
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("empleado.fxml"));

            //Cargar la ventana
            Parent root = loader.load();

            //creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Añadir empleado a la BD");
            ControladorEmpleado controlador = loader.getController();
            controlador.setState(stage);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            ShowAlert.error("Error al abrir la ventana de los empleados");
        }
    }

    @FXML
    void handleShowFormDepartment(ActionEvent event) {
        try {

            //Cargar la vista
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("departamento.fxml"));

            //Cargar la ventana
            Parent root = loader.load();

            //creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Añadir departamento a la BD");
            ControladorDepartamento controlador = loader.getController();
            controlador.setState(stage);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            ShowAlert.error("Error al abrir la ventana de los departamentos");
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setUsuario(Empleado emp) {
        empLogin = emp;
        try {
            emp.cargarPermisosUsuario();
            //Permiso de empleado
            if (emp.isPermiso(1)) bdepartamento.setDisable(false);
            if (emp.isPermiso(2)) btEmpleado.setDisable(false);
            if (emp.isPermiso(4)) btConsultas.setDisable(false);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            ;
        }
    }

    public static Empleado getEmpLogin() {
        return empLogin;
    }


}
