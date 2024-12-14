package com.webTrail.model;


import jakarta.persistence.*;

@Entity
@Table(name="viajes")
public class Viajes {

    // Atributos de la clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_viajes;
    private String name;
    private Double price;
    private int idContinente;
    private int capacidad;

    // Constructor
    public Viajes(int id_viajes, String name, Double price, int idContinente, int capacidad) {
        this.id_viajes = id_viajes;
        this.name = name;
        this.price = price;
        this.idContinente = idContinente;
        this.capacidad = capacidad;

    }

    // Metodos Get y Set
    public Viajes() { }

    public int getId_viajes() {
        return id_viajes;
    }

    public void setId_viajes(int id_viajes) {
        this.id_viajes = id_viajes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(int idContinente) {
        this.idContinente = idContinente;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
