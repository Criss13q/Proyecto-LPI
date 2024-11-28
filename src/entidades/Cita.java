package entidades;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Cita {
    private int idCita;
    private int idUsuario;
    private Date fecha;
    private Time hora;
    private String descripcion;
    private Timestamp fechaCreacion;

    public Cita() {
    }

    public Cita(int idCita, int idUsuario, Date fecha, Time hora, String descripcion, Timestamp fechaCreacion) {
        this.idCita = idCita;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
    }

    public Cita(int idUsuario, Date fecha, Time hora, String descripcion) {
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
