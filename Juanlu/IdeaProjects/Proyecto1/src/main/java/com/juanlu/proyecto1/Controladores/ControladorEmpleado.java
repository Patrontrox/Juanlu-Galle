package com.juanlu.proyecto1.Controladores;


import com.juanlu.proyecto1.Modelos.Departamento;
import com.juanlu.proyecto1.Modelos.Empleado;
import com.juanlu.proyecto1.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDate;

public class ControladorEmpleado {

    private ComboBox comboBox;
    private StringBuilder sb;
    private ObservableList<Empleado> data;
    private boolean moveCaretToPos = false;
    private int caretPos;

    private Stage stage;

    @FXML
    private Button bPermisos;

    @FXML
    private Button bcrear;

    @FXML
    private Button beliminar;

    @FXML
    private Button bmodificar;

    @FXML
    private TableColumn tcDepto;

    @FXML
    private TableColumn tcActivo;

    @FXML
    private TableColumn tcApellidos;

    @FXML
    private TableColumn tcDNI;

    @FXML
    private TableColumn tcNombre;

    @FXML
    private TableView<Empleado> tvEmp;

    @FXML
    private DatePicker dtFecha;

    private ObservableList<Empleado> listaEmpleados;
    private ObservableList<Empleado> filtroEmpleados;

    @FXML
    void handleEliminar(ActionEvent event) {

        Empleado empleado1 = tvEmp.getSelectionModel().getSelectedItem();
        if (empleado1 == null) {
            ShowAlert.error("Seleccione un empleado de la tabla antes de poder eliminarlo");
            return;
        }
        if (empleado1.getActivoFormat() == "no") {
            try {
                empleado1.eliminar();
            } catch (SQLException e) {
                ShowAlert.error("No se puede eliminar el empleado porque sigue en activo " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @FXML
    void handleModificar(ActionEvent event) {

        Empleado empleado = tvEmp.getSelectionModel().getSelectedItem();
        if (empleado == null) {
            ShowAlert.error("Seleccione un empleado de la tabla antes de modificar");
            return;
        }

        try {
            ObservableList<Departamento> listDepartamentos = FXCollections.observableList(Departamento.consultarDepartamento());

            //Cargar la vista
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("FormEmpleados.fxml"));

            //Cargar la ventana
            Parent root = loader.load();

            //creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Editar empleado y añadir a la BD");
            ControladorCrearEmpleados controlador = loader.getController();
            controlador.setState(stage);
            controlador.setController(this);
            controlador.setDepartamentos(listDepartamentos);
            controlador.setEmpleado(empleado);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (Exception e) {
            ShowAlert.error("Error al abrir la ventana de modificación de empleados");
        }

    }

    @FXML
    void handleSalir(ActionEvent event) {
        if (stage != null) stage.close();
    }

    public void setState(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void handlePermisos(ActionEvent event) {
        Empleado empleado = tvEmp.getSelectionModel().getSelectedItem();
        if (empleado == null) {
            ShowAlert.error("Seleccione un empleado de la tabla");
            return;
        }

        try {

            //Cargar la vista
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("permiso.fxml"));

            //Cargar la ventana
            Parent root = loader.load();

            //creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Asignar permisos y añadir a la BD");
            ControladorPermisos controlador = loader.getController();
            controlador.setState(stage);
            controlador.setEmpleado(empleado);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (Exception e) {
            ShowAlert.error("Error al abrir la ventana de creación de empleados");
        }

    }

    @FXML
    void handleCrear(ActionEvent event) {

        try {
            ObservableList<Departamento> listDepartamentos = FXCollections.observableList(Departamento.consultarDepartamento());

            //Cargar la vista
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("FormEmpleados.fxml"));

            //Cargar la ventana
            Parent root = loader.load();

            //creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Crear empleado y añadir a la BD");
            ControladorCrearEmpleados controlador = loader.getController();
            controlador.setState(stage);
            controlador.setController(this);
            controlador.setDepartamentos(listDepartamentos);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (Exception e) {
            ShowAlert.error("Error al abrir la ventana de creación de empleados");
        }

    }

    @FXML
    public void initialize() {
        tcNombre.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre"));
        tcApellidos.setCellValueFactory(new PropertyValueFactory<Empleado, String>("apellidos"));
        tcDNI.setCellValueFactory(new PropertyValueFactory<Empleado, String>("DNI"));
        tcActivo.setCellValueFactory(new PropertyValueFactory<Empleado, String>("activoFormat"));
        tcDepto.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombreDepart"));
        controlarBtnPermisos();
        actualizarTablaEmp();
    }


    public void controlarBtnPermisos() {
        Empleado empLogin = ControladorInformacion.getEmpLogin();
        try {
            empLogin.cargarPermisosUsuario();
            bPermisos.setDisable(!empLogin.isPermiso(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void actualizarTablaEmp() {
        try {
            ObservableList<Empleado> lEmp = FXCollections.observableList(Empleado.consultarEmpleado());
            tvEmp.setItems(lEmp);
        } catch (SQLException e) {
            ShowAlert.error("Error al consultar los empleados " + e.getMessage());
            e.printStackTrace();
        }

    }

}
