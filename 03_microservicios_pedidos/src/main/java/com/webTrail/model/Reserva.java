package com.webTrail.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reservas;
    private int idUsuario;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha;
    private String status;
    @OneToMany
    @JoinColumn(name = "id_reservas", referencedColumnName = "id_reservas")
    private List<ElementosReserva> elementosReserva;

    public Reserva(int id_reservas, int idUsuario, Date fecha, String status, List<ElementosReserva> elementosReserva) {
        this.id_reservas = id_reservas;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.status = status;
        this.elementosReserva = elementosReserva;
    }

    public Reserva() { }

    public int getId_reservas() {
        return id_reservas;
    }

    public void setId_reservas(int id_reservas) {
        this.id_reservas = id_reservas;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ElementosReserva> getElementosReserva() {
        return elementosReserva;
    }

    public void setElementosReserva(List<ElementosReserva> elementosReserva) {
        this.elementosReserva = elementosReserva;
    }
}
