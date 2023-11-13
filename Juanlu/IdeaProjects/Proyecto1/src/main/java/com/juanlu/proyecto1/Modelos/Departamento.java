package com.juanlu.proyecto1.Modelos;

import com.juanlu.proyecto1.AccesoDatos.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Departamento {

    private long id;
    private String nombre;
    private String responsable;

    public Departamento(String nombre, String responsable) {
        this.nombre = nombre;
        this.responsable = responsable;
    }

    public Departamento(long id, String nombre, String responsable) {
        this.id = id;
        this.nombre = nombre;
        this.responsable = responsable;
    }

    public long getId() {
        return id;
    }

    public static Departamento getDetpart(long idDepto) throws SQLException {
        Connection conn = ConexionBD.getConexion();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM Departamentos WHERE id = ?");
        statement.setLong(1, idDepto);
        ResultSet result = statement.executeQuery();
        Departamento dep = null;
        if (result.next()) dep = castDepartamentos(result);
        result.close();
        conn.close();
        return dep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return nombre;
    }


    public boolean guardar() throws SQLException {
        Connection conn = ConexionBD.getConexion();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO Departamentos(nombre,responsable) VALUES(?,?)");
        statement.setString(1, nombre);
        statement.setString(2, String.valueOf(responsable));
        int rows = statement.executeUpdate();
        statement.close();
        conn.close();
        return rows > 0;
    }

    public boolean actualizar() throws SQLException {
        Connection conn = ConexionBD.getConexion();
        PreparedStatement statement = conn.prepareStatement("UPDATE departamentos SET nombre=?, responsable=? WHERE id=?");
        statement.setString(1, nombre);
        statement.setString(2, responsable);
        statement.setLong(3, id);
        int filas = statement.executeUpdate();
        statement.close();
        conn.close();
        return filas > 0;
    }


    public boolean eliminar() throws SQLException {
        Connection conn = ConexionBD.getConexion();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM departamentos WHERE id=?");
        statement.setLong(1, id);
        int filas = statement.executeUpdate();
        statement.close();
        conn.close();
        return filas > 0;
    }

    public static List<Departamento> consultarDepartamento() throws SQLException {
        Connection conn = ConexionBD.getConexion();
        Statement statement = conn.createStatement();
        ResultSet resultado = statement.executeQuery("SELECT * FROM Departamentos");
        List<Departamento> lDepartamentos = new ArrayList<>();
        while (resultado.next()) lDepartamentos.add(castDepartamentos(resultado));
        resultado.close();
        statement.close();
        conn.close();
        return lDepartamentos;
    }

    public static Departamento getDepartamento(String nombre) throws SQLException {
        Connection conn = ConexionBD.getConexion();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM Departamentos WHERE Nombre LIKE ?");
        statement.setString(1, nombre);
        ResultSet result = statement.executeQuery();
        Departamento dep = null;
        if (result.next()) dep = castDepartamentos(result);
        result.close();
        conn.close();
        return dep;
    }

    private static Departamento castDepartamentos(ResultSet result) throws SQLException {
        String nombre = result.getString("nombre");
        String responsable = result.getString("responsable");
        return new Departamento(result.getLong("id"), nombre, responsable);

    }


}
