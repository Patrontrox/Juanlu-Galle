package com.juanlu.proyecto1.AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String HOST = "localhost";
    private static final String BD = "controlpresencia";
    private static final int PUERTO = 3306;
    private static final String USER = "root";
    private static final String PASS = "";


    public static Connection getConexion() throws SQLException {
        String url = "jdbc:mysql://" + HOST + ":" + PUERTO + "/" + BD + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Connection conexion = DriverManager.getConnection(url, USER, PASS);
        return conexion;
    }

}
