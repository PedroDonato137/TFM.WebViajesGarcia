package com.webTrail.model;

import jakarta.persistence.*;

@Entity
@Table(name = "elementosreservas")
public class ElementosReserva {

    //Atributos de la clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_elementosReserva;
    private int id_reservas;
    @ManyToOne
    // FK entre la tabla viajes y elementos reserva
    @JoinColumn(name = "id_viajes", referencedColumnName = "id_viajes")
    private Viajes viajes;
    private int unidades;

    //Contructor
    public ElementosReserva(int id_elementosReserva, int id_reservas, Viajes viajes, int unidades) {
        this.id_elementosReserva = id_elementosReserva;
        this.id_reservas = id_reservas;
        this.viajes = viajes;
        this.unidades = unidades;
    }

    // Contructor vacio
    public ElementosReserva() { }

    // Metodos Get y Set
    public int getId_elementosReserva() {
        return id_elementosReserva;
    }

    public void setId_elementosReserva(int id_elementosReserva) {
        this.id_elementosReserva = id_elementosReserva;
    }

    public int getId_reservas() {
        return id_reservas;
    }

    public void setId_reservas(int id_reservas) {
        this.id_reservas = id_reservas;
    }

    public Viajes getViajes() {
        return viajes;
    }

    public void setViajes(Viajes viajes) {
        this.viajes = viajes;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}
