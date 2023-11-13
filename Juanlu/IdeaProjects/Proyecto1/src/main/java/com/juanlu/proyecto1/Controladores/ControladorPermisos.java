package com.juanlu.proyecto1.Controladores;

import com.juanlu.proyecto1.Modelos.Empleado;
import com.juanlu.proyecto1.Modelos.Permiso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControladorPermisos {

    private ControladorPermisos controlador;
    private Stage stage;
    @FXML
    private Button btAtras;

    @FXML
    private Button btGuardar;

    @FXML
    private CheckBox cbConsultas;

    @FXML
    private CheckBox cbDepto;

    @FXML
    private CheckBox cbEmp;

    @FXML
    private CheckBox cbPerm;

    @FXML
    private Label lbEscritura;

    @FXML
    private Label lbLE;

    @FXML
    private Label lbLE1;

    @FXML
    private Label lbLectura;

    @FXML
    private TextField tfNombre;


    private Empleado empleado;

    public void setState(Stage stage) {
        this.stage = stage;
    }

    public void setEmpleado(Empleado emp) throws SQLException {
        emp.cargarPermisosUsuario();
        this.empleado = emp;
        tfNombre.setText(emp.getNombre());

        cbDepto.setSelected(emp.isPermiso(1));
        cbEmp.setSelected(emp.isPermiso(2));
        cbPerm.setSelected(emp.isPermiso(3));
        cbConsultas.setSelected(emp.isPermiso(4));
    }


    @FXML
    void handleGuardar(ActionEvent event) {
        List<Permiso> lPerm = new ArrayList<>();

        if (cbDepto.isSelected()) lPerm.add(new Permiso(1, "departamento", ""));
        if (cbEmp.isSelected()) lPerm.add(new Permiso(2, "empleado", ""));
        if (cbPerm.isSelected()) lPerm.add(new Permiso(3, "permiso", ""));
        if (cbConsultas.isSelected()) lPerm.add(new Permiso(4, "consultas", ""));

        try {
            boolean actualizado = empleado.actualizarPermisos(lPerm);
            if (actualizado) {
                ShowAlert.info("Permisos actualizados correctamente");
                stage.close();
            } else ShowAlert.aviso("No se ha actualizado los permisos");
        } catch (SQLException e) {
            ShowAlert.error("Error al actualizar los permisos. " + e.getMessage());
        }

    }


    @FXML
    void handleAtras(ActionEvent event) {
        if (stage != null) stage.close();
    }

}

