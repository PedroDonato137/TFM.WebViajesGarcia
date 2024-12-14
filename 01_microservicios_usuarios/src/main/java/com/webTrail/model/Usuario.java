package com.webTrail.model;

import jakarta.persistence.*;


@Entity // Esta clase es una entidad de datos
@Table(name="usuarios") // Tabla asociada de la Base de datos
public class Usuario {

    // Atributos de la clase
    @Id // id de clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    private String name;
    private String correo;

    //@JsonIgnore // Evitar enviar la contraseña en la respuesta
    private String password;
    //@Enumerated(EnumType.STRING) // Almacena los valores como cadenas en la base de datos
    private String rol;

    //Constructor
    public Usuario(int id_usuario, String name, String correo, String password, String rol) {
        this.id_usuario = id_usuario;
        this.name = name;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
    }

    //Constructor vacio
    public Usuario() {
    }

    // Metodos Setters and Getters
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
