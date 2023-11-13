package com.juanlu.proyecto1.Controladores;

import com.juanlu.proyecto1.Modelos.Empleado;
import com.juanlu.proyecto1.Modelos.HorasTrabajadas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ControladorConsultas {


    private Stage stage;

    @FXML
    private Button btAtras;
    @FXML
    private Button btBuscar;

    @FXML
    private ComboBox<Empleado> cbEmpleado;

    @FXML
    private DatePicker dtDesde;

    @FXML
    private DatePicker dtHasta;

    @FXML
    private TableColumn tcFechEn;

    @FXML
    private TableColumn tcFechaSal;

    @FXML
    private TableColumn tcHoras;

    @FXML
    private TableColumn tcEmpleado;

    @FXML
    private TableView<HorasTrabajadas> tvConsultas;

    private ObservableList<Empleado> lEmpleados;


    @FXML
    void handleBuscar(ActionEvent event) {

        if (dtDesde.getValue() == null && dtHasta.getValue() == null) {
            ShowAlert.error("Debe elegir dos fechas");
            return;
        }

        if (cbEmpleado.getValue() == null) {
            ShowAlert.error("Debes seleccionar un empleado");
            return;
        }
        LocalDate inicioRango = dtDesde.getValue();
        LocalDate finRango = dtHasta.getValue();

        if (inicioRango.compareTo(finRango) > 0) {
            ShowAlert.error("La fecha de fin ha de ser posterior a la fecha de inicio");
            return;
        }

        actualizarTablaHoras(inicioRango, finRango, cbEmpleado.getValue());
    }


    @FXML
    void initialize() {
        cargaCbEmpleados();
        tcFechEn.setCellValueFactory(new PropertyValueFactory<HorasTrabajadas, String>("fechaEntradaFormat"));
        tcFechaSal.setCellValueFactory(new PropertyValueFactory<HorasTrabajadas, String>("fechaSalidaFormat"));
        tcHoras.setCellValueFactory(new PropertyValueFactory<HorasTrabajadas, String>("tiempoTrabajado"));
        tcEmpleado.setCellValueFactory(new PropertyValueFactory<HorasTrabajadas, String>("empleado"));


    }

    private void cargaCbEmpleados() {
        try {
            lEmpleados = FXCollections.observableArrayList();
            Empleado empTodos = new Empleado();
            lEmpleados.add(empTodos);
            lEmpleados.addAll(Empleado.consultarEmpleado());
            cbEmpleado.setItems(lEmpleados);
            cbEmpleado.setValue(empTodos);
        } catch (Exception e) {
            ShowAlert.error("Error al obtener los empleados->" + e.getMessage());
            e.printStackTrace();
        }

    }


    public void setState(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void handleAtras(ActionEvent event) {
        if (stage != null) stage.close();
    }

    public void actualizarTablaHoras(LocalDate inicio, LocalDate fin, Empleado emp) {
        try {
            ObservableList<HorasTrabajadas> lHoras = FXCollections.observableList(HorasTrabajadas.consultarHoras(inicio, fin, emp));
            tvConsultas.setItems(lHoras);
        } catch (SQLException e) {
            ShowAlert.error("Error al consultar las horas " + e.getMessage());
            e.printStackTrace();
        }


    }
}

