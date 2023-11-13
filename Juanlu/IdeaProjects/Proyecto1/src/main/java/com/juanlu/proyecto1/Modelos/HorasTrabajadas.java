package com.juanlu.proyecto1.Modelos;

import com.juanlu.proyecto1.AccesoDatos.ConexionBD;

import java.sql.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HorasTrabajadas {

    private long id;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private Empleado empleado;
    private String tiempoTrabajado;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public HorasTrabajadas(long id, LocalDateTime fechaEntrada, LocalDateTime fechaSalida, Empleado empleado, String tiempoTrabajado) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.empleado = empleado;
        this.tiempoTrabajado = tiempoTrabajado;
    }

    public HorasTrabajadas(LocalDateTime fechaEntrada, LocalDateTime fechaSalida, Empleado empleado, String tiempoTrabajado) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.empleado = empleado;
        this.tiempoTrabajado = tiempoTrabajado;
    }

    public long getId() {
        return id;
    }


    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getTiempoTrabajado() {
        return tiempoTrabajado;
    }

    public void setTiempoTrabajado(String tiempoTrabajado) {
        this.tiempoTrabajado = tiempoTrabajado;
    }




    public  String getFechaEntradaFormat(){
        return fechaEntrada.format(formatter);
    }

    public String getFechaSalidaFormat(){
        return fechaSalida.format(formatter);
    }


    public boolean guardar() throws SQLException {

        Connection conn = ConexionBD.getConexion();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO horas_trabajadas (fechaEntrada,fechaSalida,idEmpleado,tiempoTrabajado) VALUES(?,?,?,?)");
        statement.setTimestamp(1, Timestamp.valueOf(fechaEntrada));
        statement.setTimestamp(2, Timestamp.valueOf(fechaSalida));
        statement.setLong(3, empleado.getId());
        statement.setString(4, tiempoTrabajado);
        int rows = statement.executeUpdate();
        statement.close();
        conn.close();
        return rows > 0;
    }

    public static List<HorasTrabajadas> consultarHoras() throws SQLException {
        Connection conn = ConexionBD.getConexion();
        Statement statement = conn.createStatement();
        ResultSet resultado = statement.executeQuery("SELECT * FROM horas_trabajadas");
        List<HorasTrabajadas> lHoras = new ArrayList<>();
        while (resultado.next()) lHoras.add(castHoras(resultado));
        resultado.close();
        statement.close();
        conn.close();
        return lHoras;
    }

    public static List<HorasTrabajadas> consultarHoras(LocalDate inicio, LocalDate fin, Empleado emp) throws SQLException {
        Connection conn = ConexionBD.getConexion();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM horas_trabajadas WHERE (idEmpleado =? || ?=-1) AND " +
                "((fechaEntrada >= ? AND fechaEntrada <= ?) " +
                "OR(fechaSalida >= ? AND fechaSalida <= ?))");

        LocalDateTime inicioTime = inicio.atTime(LocalTime.of(0, 0, 0));
        LocalDateTime finTime = fin.atTime(LocalTime.of(23, 59, 59));


        statement.setLong(1, emp.getId());
        statement.setLong(2, emp.getId());
        statement.setTimestamp(3, Timestamp.valueOf(inicioTime));
        statement.setTimestamp(4, Timestamp.valueOf(finTime));
        statement.setTimestamp(5, Timestamp.valueOf(inicioTime));
        statement.setTimestamp(6, Timestamp.valueOf(finTime));
        ResultSet resultado = statement.executeQuery();
        List<HorasTrabajadas> lHoras = new ArrayList<>();
        while (resultado.next()) lHoras.add(castHoras(resultado));
        resultado.close();
        statement.close();
        conn.close();
        return lHoras;
    }


    public static HorasTrabajadas castHoras(ResultSet result) throws SQLException {
        long id = result.getLong("id");
        String tiempoTrabajado = result.getString("tiempoTrabajado");
        LocalDateTime fechaEntrada = result.getTimestamp("fechaEntrada").toLocalDateTime();
        LocalDateTime fechaSalida = result.getTimestamp("fechaSalida").toLocalDateTime();
        var emp = Empleado.getEmpleado(result.getLong("idEmpleado"));
        return new HorasTrabajadas(id, fechaEntrada, fechaSalida, emp, tiempoTrabajado);

    }



    /*private long id;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private Empleado empleado;
    private String tiempoTrabajado;*/

}
