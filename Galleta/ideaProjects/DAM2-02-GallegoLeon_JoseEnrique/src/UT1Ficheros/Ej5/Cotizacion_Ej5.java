package UT1Ficheros.Ej5;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cotizacion_Ej5 implements Serializable {
    private String nombreEmpresa;
    private Date fecha;
    private String hora;
    private double valor;

    public Cotizacion_Ej5(String empresa, double valor) {
        this.nombreEmpresa = empresa;
        this.fecha = new Date();
        this.hora = new SimpleDateFormat("HH:mm").format(new Date());
        this.valor = valor;
    }

    // Get y set para empresa, fecha, hora y valor

    @Override
    public String toString() {
        return "Empresa: " + nombreEmpresa + ", Fecha: " + fecha + ", Hora: " + hora + ", Valor: " + valor;
    }

    public String getEmpresa() {
        return nombreEmpresa;
    }

    public void setEmpresa(String empresa) {
        this.nombreEmpresa = empresa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

