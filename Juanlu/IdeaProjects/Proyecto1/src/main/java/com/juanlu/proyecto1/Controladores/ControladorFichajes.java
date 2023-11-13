package com.juanlu.proyecto1.Controladores;

import com.juanlu.proyecto1.Modelos.Fichaje;
import com.juanlu.proyecto1.Modelos.HorasTrabajadas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ControladorFichajes {

    private Stage stage;
    @FXML
    private Button btAtras;

    @FXML
    private Button btEntrada;

    @FXML
    private Button btSalida;

    @FXML
    void handleEntrada(ActionEvent event) {
        crearFichaje(Fichaje.TIPOS_FICH.ENTRADA);
    }

    private void crearFichaje(Fichaje.TIPOS_FICH tipo) {
        var emp = ControladorInformacion.getEmpLogin();
        Fichaje fichaje = new Fichaje(emp, LocalDateTime.now(), tipo);
        try {
            if (fichaje.guardar()) {
                ShowAlert.info("Fichaje registrado");
                if(tipo== Fichaje.TIPOS_FICH.SALIDA) registrarHorasTrabajadas(fichaje);
                stage.close();
            } else ShowAlert.error("Error, no se ha podido guardar el fichaje");
        } catch (SQLException e) {
            ShowAlert.error(e.getMessage());
        }
    }

    private void registrarHorasTrabajadas(Fichaje fichSalida) throws SQLException {
        var emp = ControladorInformacion.getEmpLogin();
        Fichaje ultFichEntrada = Fichaje.getUtimoFich(emp.getId(), Fichaje.TIPOS_FICH.ENTRADA);
        if(ultFichEntrada==null) return;
        var fechaEntrada = ultFichEntrada.getFecha();
        var fechaSalida = fichSalida.getFecha();
        long horas = ChronoUnit.HOURS.between(fechaEntrada,fechaSalida);
        long min = ChronoUnit.MINUTES.between(fechaEntrada,fechaSalida) - (horas*60);
        String horasTrabajadas = horas+"h "+min+"m";
        var jornada = new HorasTrabajadas(fechaEntrada,fechaSalida,emp,horasTrabajadas);
        if(!jornada.guardar())ShowAlert.error("Error al guardar la jornada de trabajo");
    }


    @FXML
    void handleSalida(ActionEvent event) {
        crearFichaje(Fichaje.TIPOS_FICH.SALIDA);
    }


    @FXML
    void handleAtras(ActionEvent event) {
        if (stage != null) stage.close();
    }

    public void setStage(Stage stage) {
        this.stage = stage;

    }

    @FXML
    public void initialize() {
        try {
            Fichaje ultfichaje = Fichaje.getUtimoFich(ControladorInformacion.getEmpLogin().getId());
            if (ultfichaje == null || ultfichaje.getTipo() == Fichaje.TIPOS_FICH.SALIDA) btEntrada.setDisable(false);
            else btSalida.setDisable(false);
        } catch (SQLException e) {
            ShowAlert.error("Error al consultar el último fichaje");
            e.printStackTrace();
        }



    }


}
