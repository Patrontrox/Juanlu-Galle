package com.juanlu.proyecto1.Controladores;

import com.juanlu.proyecto1.Modelos.Departamento;
import com.juanlu.proyecto1.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ControladorDepartamento {

    private Stage stage;

    @FXML
    private Button bcrear;

    @FXML
    private Button beliminar;

    @FXML
    private Button bmodificar;

    @FXML
    private TableColumn tcNombre;

    @FXML
    private TableColumn tcResponsable;

    @FXML
    private TableView<Departamento> tvDepto;


    @FXML
    void handleEliminar(ActionEvent event) {

        Departamento departamento = tvDepto.getSelectionModel().getSelectedItem();
        if (departamento == null) {
            ShowAlert.error("Seleccione un departamento de la tabla antes de poder eliminarlo");
            return;
        } else {
            try {
                departamento.eliminar();
                tvDepto.getItems().remove(departamento);
            } catch (SQLException e) {
                if (e.getMessage().contains("FK_emp_depto"))
                    ShowAlert.aviso("No se puede eliminar el departamento porque tiene empleados");
                else ShowAlert.error(e.getMessage());
            }
        }

    }


    public void setState(Stage stage) {
        this.stage = stage;
    }


    @FXML
    void handleCrear(ActionEvent event) {
        try {

            //Cargar la vista
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("FormDepartamentos.fxml"));

            //Cargar la ventana
            Parent root = loader.load();

            //creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Crear departamento y añadir a la BD");
            ControladorFormDepart controlador = loader.getController();
            controlador.setState(stage);
            controlador.setController(this);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            ShowAlert.error("Error al abrir la ventana de creación de departamentos");
        }
    }

    @FXML
    void handleModificar(ActionEvent event) {
        Departamento departamento = tvDepto.getSelectionModel().getSelectedItem();
        if (departamento == null) {
            ShowAlert.error("Seleccione un departamento de la tabla antes de modificar");
            return;
        }
        try {
            //Cargar la vista
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("FormDepartamentos.fxml"));

            //Cargar la ventana
            Parent root = loader.load();

            //creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Editar departamento y añadir a la BD");
            ControladorFormDepart controlador = loader.getController();
            controlador.setState(stage);
            controlador.setController(this);
            controlador.setDepartamento(departamento);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (Exception e) {
            ShowAlert.error("Error al abrir la ventana de modificación de departamentos");
        }

    }

    @FXML
    public void initialize() {
        tcNombre.setCellValueFactory(new PropertyValueFactory<Departamento, String>("nombre"));
        tcResponsable.setCellValueFactory(new PropertyValueFactory<Departamento, String>("responsable"));
        actualizarTablaDepto();

    }

    @FXML
    void handleSalir(ActionEvent event) {
        if (stage != null) stage.close();
    }

    public void actualizarTablaDepto() {
        try {
            ObservableList<Departamento> lDepto = FXCollections.observableList(Departamento.consultarDepartamento());
            tvDepto.setItems(lDepto);
        } catch (SQLException e) {
            ShowAlert.error("Error al consultar los departamentos " + e.getMessage());
            e.printStackTrace();
        }

    }

}
