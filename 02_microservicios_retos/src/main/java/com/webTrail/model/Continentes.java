package com.webTrail.model;

import jakarta.persistence.*;

@Entity
@Table(name="continentes")
public class Continentes {

    //Atributos de la clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // esto indica que el campo es autoincrementar especificamente numerico
    private int idContinente;
    private String name;

    //Constructor
    public Continentes(int idContinente, String name) {
        this.idContinente = idContinente;
        this.name = name;
    }

    // Metodos Get y set
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
