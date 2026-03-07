package com.juancarlos.curso.springboot.di.factura.springbootdifactura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@RequestScope
// @JsonIgnoreProperties({"advisors","targetSource"})
public class Client {

    // Attributes
    @Value("${client.name}") // Inyecta el valor de la propiedad "client.name" desde el archivo de configuración
    private String name;
    @Value("${client.lastname}") // Inyecta el valor de la propiedad "client.lastname" desde el archivo de configuración
    private String lastname;

    // Getters and Setters
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


}
