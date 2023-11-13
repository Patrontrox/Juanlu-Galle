package com.juanlu.proyecto1.Controladores;

import com.juanlu.proyecto1.Modelos.Departamento;
import com.juanlu.proyecto1.Modelos.Empleado;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ControladorCrearEmpleados {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @FXML
    private TextField tfApellidos;

    @FXML
    private TextField tfDNI;

    @FXML
    private TextField tfFecin;

    @FXML
    private TextField tfFecna;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfPass;

    @FXML
    private TextField tfUser;

    @FXML
    private ComboBox<Departamento> cbDepto;

    private Stage stage;
    private ObservableList<Departamento> lDepar;
    private ControladorEmpleado controlador;
    private Empleado empleado;


    @FXML
    void handleGuardar(ActionEvent event) {

        if (tfNombre.getText().isEmpty() || tfApellidos.getText().isEmpty() || tfDNI.getText().isEmpty() || tfUser.getText().isEmpty() || tfPass.getText().isEmpty() || tfFecna.getText().isEmpty() || tfFecin.getText().isEmpty() || cbDepto.getValue() == null) {
            ShowAlert.error("Todos los datos han de ser rellenados, inténtelo de nuevo");
            return;
        }

        LocalDate fechaNacimiento = LocalDate.parse(tfFecna.getText(), formatter);
        LocalDate fechaIncorporacion = LocalDate.parse(tfFecin.getText(), formatter);
        if (empleado == null) nuevoEmpleado(fechaNacimiento, fechaIncorporacion);
        else modificarEmpleado(fechaNacimiento, fechaIncorporacion);


    }

    private void modificarEmpleado(LocalDate fechaNacimiento, LocalDate fechaIncorporacion) {
        empleado.setNombre(tfNombre.getText());
        empleado.setUsuario(tfUser.getText());
        empleado.setPass(tfPass.getText());
        empleado.setApellidos(tfApellidos.getText());
        empleado.setDNI(tfDNI.getText());
        empleado.setFechaNacimiento(fechaNacimiento);
        empleado.setFechaIncorporacion(fechaIncorporacion);
        empleado.setDepartamento(cbDepto.getValue());
        try {
            if (empleado.actualizar()) {
                ShowAlert.info("Empleado " + tfNombre.getText() + " actualizado correctamente");
                controlador.actualizarTablaEmp();
                stage.close();
            }
        } catch (SQLException e) {
            int codError = e.getErrorCode();
            if (codError == 1062)
                ShowAlert.error("El nombre introducido ya existe, introduzca un nombre diferente.");
            else ShowAlert.error(e.getMessage());
        }

    }


    private void nuevoEmpleado(LocalDate fechaNacimiento, LocalDate fechaIncorporacion) {
        Empleado empleado = new Empleado(tfNombre.getText(), tfUser.getText(), tfPass.getText(), tfApellidos.getText(), tfDNI.getText(), fechaNacimiento, fechaIncorporacion, cbDepto.getValue());
        try {
            if (empleado.guardar()) {
                ShowAlert.info("Empleado " + tfNombre.getText() + " creado correctamente");
                controlador.actualizarTablaEmp();
                stage.close();
            }
        } catch (SQLException e) {
            int codError = e.getErrorCode();
            if (codError == 1062)
                ShowAlert.error("El empleado introducido ya existe, introduzca un empleado diferente.");
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


    public void setDepartamentos(ObservableList<Departamento> listDepartamentos) {
        this.lDepar = listDepartamentos;
        cbDepto.setItems(lDepar);
    }

    public void setController(ControladorEmpleado controladorEmpleado) {
        this.controlador = controladorEmpleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
        tfNombre.setText(empleado.getNombre());
        tfUser.setText(empleado.getUsuario());
        tfFecin.setText(empleado.getFechaIncorporacion().format(formatter));
        tfFecna.setText(empleado.getFechaNacimiento().format(formatter));
        tfApellidos.setText(empleado.getApellidos());
        tfDNI.setText(empleado.getDNI());
        cbDepto.setValue(empleado.getDepartamento());
        tfPass.setText(empleado.getPass());
    }


}
