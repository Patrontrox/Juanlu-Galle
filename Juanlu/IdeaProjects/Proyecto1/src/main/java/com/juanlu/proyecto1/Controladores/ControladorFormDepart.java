package com.juanlu.proyecto1.Controladores;

import com.juanlu.proyecto1.Modelos.Departamento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ControladorFormDepart {

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfResponsable;

    private Stage stage;
    private ControladorDepartamento controlador;
    private Departamento departamento;


    @FXML
    void handleGuardar(ActionEvent event) {

        if (tfNombre.getText().isEmpty() && tfResponsable.getText().isEmpty()) {
            ShowAlert.error("Introduzca un nombre y responsable para poder crear el departamento");
            return;
        }
        if (departamento == null) nuevoDepartamento();
        else modificarDepartamento();
    }

    private void modificarDepartamento() {
        departamento.setNombre(tfNombre.getText());
        departamento.setResponsable(tfResponsable.getText());
        try {
            if (departamento.actualizar()) {
                controlador.actualizarTablaDepto();
                stage.close();
            }
        } catch (SQLException e) {
            int codError = e.getErrorCode();
            if (codError == 1062)
                ShowAlert.error("El departamento introducido ya existe, introduzca un nombre de departamento diferente.");
            else ShowAlert.error(e.getMessage());
        }

    }


    private void nuevoDepartamento() {
        Departamento departamento = new Departamento(tfNombre.getText(), tfResponsable.getText());
        try {
            if (departamento.guardar()) {
                controlador.actualizarTablaDepto();
                stage.close();
            }
        } catch (SQLException e) {
            int codError = e.getErrorCode();
            if (codError == 1062)
                ShowAlert.error("El departamento introducido ya existe, introduzca un nombre de departamento diferente.");
            else ShowAlert.error(e.getMessage());
        }
    }


    @FXML
    void handleSalir(ActionEvent event) {
        if (stage != null) stage.close();
    }


    public void setState(Stage stage) {
        this.stage = stage;
    }

    public void setController(ControladorDepartamento controladorDepartamento) {
        this.controlador = controladorDepartamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
        tfNombre.setText(departamento.getNombre());
        tfResponsable.setText(departamento.getResponsable());
    }
}
