package com.juanlu.proyecto1.Modelos;

import com.juanlu.proyecto1.AccesoDatos.ConexionBD;

import java.sql.*;
import java.time.LocalDateTime;

//TODO Crear vista consultas, basada en vista empleados
//TODO Filtrar empleado con un comboBox, datePicker inicio y fin
//TODO Boton buscar para hacer consulta.
//TODO Fondos ventanas

public class Fichaje {

    private long identificador;
    private Empleado empleado;
    private LocalDateTime fecha;
    private TIPOS_FICH tipo;


    public Fichaje(long identificador, Empleado empleado, LocalDateTime fecha, TIPOS_FICH tipo) {
        this.identificador = identificador;
        this.empleado = empleado;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public Fichaje(Empleado empleado, LocalDateTime fecha, TIPOS_FICH tipo) {
        this.empleado = empleado;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public TIPOS_FICH getTipo() {
        return tipo;
    }

    public void setTipo(TIPOS_FICH tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Fichaje{" +
                "identificador=" + identificador +
                ", empleado=" + empleado +
                ", fecha=" + fecha +
                ", tipo=" + tipo +
                '}';
    }


    public boolean guardar() throws SQLException {
        Connection conn = ConexionBD.getConexion();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO Fichajes(empleado, fecha, tipo) VALUES(?,?,?)");
        statement.setLong(1, empleado.getId());
        statement.setTimestamp(2, Timestamp.valueOf(fecha));
        statement.setInt(3, tipo.ordinal());
        int rows = statement.executeUpdate();
        statement.close();
        conn.close();
        return rows > 0;
    }


    public static Fichaje getUtimoFich(long idEmpleado) throws SQLException {
        Connection connection = ConexionBD.getConexion();
        PreparedStatement statement = connection.prepareStatement("SELECT e.*, f.id AS idFich, f.empleado,f.fecha,f.tipo FROM fichajes f " +
                "INNER JOIN empleados e ON f.empleado= e.id " +
                "WHERE f.empleado = ? " +
                "ORDER BY f.id DESC LIMIT 1");
        statement.setLong(1, idEmpleado);
        ResultSet resultSet = statement.executeQuery();
        Fichaje fich = null;
        if (resultSet.next()) fich = castFich(resultSet,true);
        resultSet.close();
        statement.close();
        connection.close();
        return fich;
    }
    public static Fichaje getUtimoFich(long idEmpleado, TIPOS_FICH tipo) throws SQLException {
        Connection connection = ConexionBD.getConexion();
        PreparedStatement statement = connection.prepareStatement("SELECT e.*, f.id AS idFich, f.empleado,f.fecha,f.tipo FROM fichajes f " +
                "INNER JOIN empleados e ON f.empleado= e.id " +
                "WHERE f.empleado = ? AND f.tipo = ? " +
                "ORDER BY f.id DESC LIMIT 1");
        statement.setLong(1, idEmpleado);
        statement.setInt(2,tipo.ordinal());
        ResultSet resultSet = statement.executeQuery();
        Fichaje fich = null;
        if (resultSet.next()) fich = castFich(resultSet,true);
        resultSet.close();
        statement.close();
        connection.close();
        return fich;
    }

    public static Fichaje castFich(ResultSet resultSet, boolean isDatEmp) throws SQLException {
        long id = isDatEmp ? resultSet.getLong("idFich") : resultSet.getLong("id");
        var emp = isDatEmp ?  Empleado.castEmpleado(resultSet): Empleado.getEmpleado(resultSet.getLong("empleado"));
        LocalDateTime fecha = resultSet.getTimestamp("fecha").toLocalDateTime();
        TIPOS_FICH tipo = TIPOS_FICH.get(resultSet.getInt("tipo"));
        return new Fichaje(id, emp, fecha, tipo);
    }

    public static Fichaje castFich(ResultSet resultSet) throws SQLException {
        return castFich(resultSet,false);
    }

    public enum TIPOS_FICH {
        ENTRADA, SALIDA;

        public static TIPOS_FICH get(int idTipo) {
            switch (idTipo) {
                case 0:
                    return ENTRADA;
                case 1:
                    return SALIDA;
                default:
                    return null;
            }
        }


    }

}
