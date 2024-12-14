package com.webTrail.model;

import jakarta.persistence.*;

@Entity
@Table(name="continentes")
public class Continentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContinente;
    private String name;

    public Continentes(int idContinente, String name) {
        this.idContinente = idContinente;
        this.name = name;
    }

    public Continentes() {
    }

    public int getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(int idContinente) {
        this.idContinente = idContinente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
