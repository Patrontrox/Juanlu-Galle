package com.juanlu.proyecto1.Modelos;

import com.juanlu.proyecto1.AccesoDatos.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Permiso {

    private long identificador;
    private String nombre;
    private String descripcion;

    public Permiso(long identificador, String nombre, String descripcion) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Permiso(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public static List<Permiso> getPermUsr(long idEmp) throws SQLException {
        Connection con = ConexionBD.getConexion();
        PreparedStatement statement = con.prepareStatement("SELECT P.* FROM permiso P INNER JOIN per_emp PE ON P.id=PE.IdPermiso WHERE PE.IdEmpleado=?");
        statement.setLong(1, idEmp);
        ResultSet resultSet = statement.executeQuery();
        List<Permiso> lPem = new ArrayList<>();
        while (resultSet.next()) lPem.add(castResult(resultSet));
        resultSet.close();
        statement.close();
        con.close();
        return lPem;
    }

    private static Permiso castResult(ResultSet resultSet) throws SQLException {
        long id = resultSet.getInt("id");
        String nombre = resultSet.getString("nombre");
        String descrip = resultSet.getString("descripcion");
        return new Permiso(id, nombre, descrip);
    }


    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Permiso{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public boolean actualizar() throws SQLException {
        Connection conn = ConexionBD.getConexion();
        PreparedStatement statement = conn.prepareStatement("UPDATE permisos SET nombre=? WHERE id=?");
        statement.setString(1, nombre);
        statement.setLong(2, identificador);
        int filas = statement.executeUpdate();
        statement.close();
        conn.close();
        return filas > 0;
    }


    public boolean eliminar() throws SQLException {
        Connection conn = ConexionBD.getConexion();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM permisos WHERE id=?");
        statement.setLong(1, identificador);
        int filas = statement.executeUpdate();
        statement.close();
        conn.close();
        return filas > 0;
    }

    public static List<Permiso> consultarPermisos() throws SQLException {
        Connection conn = ConexionBD.getConexion();
        Statement statement = conn.createStatement();
        ResultSet resultado = statement.executeQuery("SELECT * FROM permisos");
        List<Permiso> lPermisos = new ArrayList<>();
        while (resultado.next()) lPermisos.add(castResult(resultado));
        resultado.close();
        statement.close();
        conn.close();
        return lPermisos;
    }
}
