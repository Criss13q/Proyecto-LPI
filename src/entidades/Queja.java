package entidades;

import java.sql.Timestamp;

public class Queja {
    private int idQueja;
    private int idUsuario;
    private String nombreCliente;
    private String correoCliente;
    private String telefonoCliente;
    private String detalle;
    private Timestamp fechaRegistro;

    public Queja() {
    }

    public Queja(int idQueja, int idUsuario, String nombreCliente, String correoCliente, String telefonoCliente, String detalle, Timestamp fechaRegistro) {
        this.idQueja = idQueja;
        this.idUsuario = idUsuario;
        this.nombreCliente = nombreCliente;
        this.correoCliente = correoCliente;
        this.telefonoCliente = telefonoCliente;
        this.detalle = detalle;
        this.fechaRegistro = fechaRegistro;
    }

    public Queja(String nombreCliente, String correoCliente, String telefonoCliente, String detalle) {
        this.nombreCliente = nombreCliente;
        this.correoCliente = correoCliente;
        this.telefonoCliente = telefonoCliente;
        this.detalle = detalle;
    }

    // Getters y Setters
    public int getIdQueja() {
        return idQueja;
    }

    public void setIdQueja(int idQueja) {
        this.idQueja = idQueja;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
