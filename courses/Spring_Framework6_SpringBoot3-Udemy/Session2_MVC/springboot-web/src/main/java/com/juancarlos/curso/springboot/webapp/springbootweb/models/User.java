package com.juancarlos.curso.springboot.webapp.springbootweb.models;

// Modelo de datos que representa un usuario con nombre, apellido y correo electrónico.
public class User {
    
    // Atributos del usuario
    private String name;
    private String lastname;
    private String email;
    
    // Constructores
    public User() {
    }

    public User(String name, String lastname, String email) {
        this(name, lastname);
        this.email = email;
    }
    
    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
