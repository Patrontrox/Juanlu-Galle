package com.juanlu.proyecto1.Modelos;

import com.juanlu.proyecto1.AccesoDatos.ConexionBD;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado {

    private long id;
    private String nombre;
    private String usuario;
    private String pass;
    private String apellidos;
    private String DNI;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIncorporacion;
    private Departamento departamento;
    private List<Permiso> permisos;
    private boolean activo;
    private LocalDate fechaBaja;


    public Empleado() {
        this.id=-1;
    }

    public Empleado(long id, String nombre, String usuario, String pass, String apellidos, String DNI, LocalDate fechaNacimiento, LocalDate fechaIncorporacion, Departamento departamento, List<Permiso> permisos, boolean activo, LocalDate fechaBaja) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.pass = pass;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIncorporacion = fechaIncorporacion;
        this.departamento = departamento;
        this.permisos = permisos;
        this.activo = activo;
        this.fechaBaja = fechaBaja;
    }

    public Empleado(String nombre, String usuario, String pass, String apellidos, String DNI, LocalDate fechaNacimiento, LocalDate fechaIncorporacion) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.pass = pass;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIncorporacion = fechaIncorporacion;
        this.permisos = new ArrayList<>();
    }

    public Empleado(String nombre, String usuario, String pass, String apellidos, String DNI, LocalDate fechaNacimiento, LocalDate fechaIncorporacion, Departamento departamento) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.pass = pass;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIncorporacion = fechaIncorporacion;
        this.departamento = departamento;
        this.permisos = new ArrayList<>();
    }

    public Empleado(String nombre, String apellidos, String DNI, LocalDate fechaNacimiento, Departamento departamento, boolean activo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.departamento = departamento;
        this.activo = activo;
    }

    public long getId() {
        return id;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }


    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getActivoFormat() {
        return activo ? "SI" : "NO";
    }

    public String getNombreDepart() {
        return departamento.getNombre();
    }


    @Override
    public String toString() {
        if(id==-1) return  "TODOS";
        return id+"-"+nombre+ " "+apellidos +" "+DNI;
    }

    public boolean guardar() throws SQLException {
        Connection conn = ConexionBD.getConexion();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO Empleados(nombre,usuario,DNI,apellidos,fecna,fechaInc,pass,iddepart) VALUES(?,?,?,?,?,?,?,?)");
        statement.setString(1, nombre);
        statement.setString(2, usuario);
        statement.setString(3, DNI);
        statement.setString(4, apellidos);
        statement.setDate(5, Date.valueOf(fechaNacimiento));
        statement.setDate(6, Date.valueOf(fechaIncorporacion));
        statement.setString(7, pass);
        statement.setLong(8, departamento.getId());
        int rows = statement.executeUpdate();
        statement.close();
        conn.close();
        return rows > 0;
    }


    public boolean actualizar() throws SQLException {
        Connection conn = ConexionBD.getConexion();
        PreparedStatement statement = conn.prepareStatement("UPDATE empleados SET nombre=?, usuario=?, DNI=?, apellidos=?, fecna=?, fechaInc=?, pass=?, iddepart=? WHERE id=?");
        statement.setString(1, nombre);
        statement.setString(2, usuario);
        statement.setString(3, DNI);
        statement.setString(4, apellidos);
        statement.setDate(5, Date.valueOf(fechaNacimiento));
        statement.setDate(6, Date.valueOf(fechaIncorporacion));
        statement.setString(7, pass);
        statement.setLong(8, departamento.getId());
        statement.setLong(9, id);
        int rows = statement.executeUpdate();
        statement.close();
        conn.close();
        return rows > 0;
    }

    public static List<Empleado> consultarEmpleado() throws SQLException {
        Connection conn = ConexionBD.getConexion();
        Statement statement = conn.createStatement();
        ResultSet resultado = statement.executeQuery("SELECT * FROM Empleados");
        List<Empleado> lEmpleado = new ArrayList<>();
        while (resultado.next()) lEmpleado.add(castEmpleado(resultado));
        resultado.close();
        statement.close();
        conn.close();
        return lEmpleado;
    }

    public static Empleado getEmpleado(String nombreUsuario) throws SQLException {
        Connection conn = ConexionBD.getConexion();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM Empleados WHERE Usuario LIKE ?");
        statement.setString(1, nombreUsuario);
        ResultSet result = statement.executeQuery();
        Empleado emp = null;
        if (result.next()) emp = castEmpleado(result);
        result.close();
        conn.close();
        return emp;
    }

    public static Empleado getEmpleado(long idEmp) throws SQLException {
        Connection conn = ConexionBD.getConexion();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM Empleados WHERE id= ?");
        statement.setLong(1, idEmp);
        ResultSet result = statement.executeQuery();
        Empleado emp = null;
        if (result.next()) emp = castEmpleado(result);
        result.close();
        conn.close();
        return emp;
    }

    public static Empleado castEmpleado(ResultSet result) throws SQLException {
        long id = result.getLong("id");
        String nombre = result.getString("nombre");
        String usuario = result.getString("usuario");
        String pass = result.getString("pass");
        String dni = result.getString("dni");
        String apellidos = result.getString("apellidos");
        LocalDate fechanac = result.getDate("fecNa").toLocalDate();
        LocalDate fechaInc = result.getDate("fechaInc").toLocalDate();
        var depto = Departamento.getDetpart(result.getLong("idDepart"));
        boolean activo = result.getBoolean("activo");
        Date dateBajaSQl = result.getDate("fechaBaja");
        LocalDate fechaBaja = dateBajaSQl == null ? null : dateBajaSQl.toLocalDate();
        List<Permiso> permUsr = Permiso.getPermUsr(id);
        return new Empleado(id, nombre, usuario, pass, apellidos, dni, fechanac, fechaInc, depto, permUsr, activo, fechaBaja);

    }


    public boolean eliminar() throws SQLException {
        Connection conn = ConexionBD.getConexion();
        PreparedStatement statement = conn.prepareStatement("Delete empleados WHERE id=?");
        statement.setLong(1, id);
        int rows = statement.executeUpdate();
        statement.close();
        conn.close();
        return rows > 0;
    }


    public void cargarPermisosUsuario() throws SQLException {
        permisos = Permiso.getPermUsr(id);
    }

    public boolean isPermiso(int idPermiso) {
        for (var perm : permisos)
            if (perm.getIdentificador() == idPermiso) return true;
        return false;
    }


    public boolean actualizarPermisos(List<Permiso> nuevosPerm) throws SQLException {
        Connection conn = ConexionBD.getConexion();
        PreparedStatement stmDelete = conn.prepareStatement("DELETE FROM per_emp WHERE idEmpleado=?");
        stmDelete.setLong(1, id);
        stmDelete.executeUpdate();
        stmDelete.close();
        int permisosInsertados = 0;
        for (Permiso pem : nuevosPerm) {
            PreparedStatement stmPerm = conn.prepareStatement("INSERT INTO per_emp(idPermiso,idEmpleado) VALUES (?,?)");
            stmPerm.setLong(1, pem.getIdentificador());
            stmPerm.setLong(2, id);
            permisosInsertados += stmPerm.executeUpdate();
            stmPerm.close();
        }
        conn.close();
        permisos = nuevosPerm;
        return nuevosPerm.size() == permisosInsertados;
    }


}
