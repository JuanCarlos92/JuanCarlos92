package com.juancarlos.curso.springboot.di.factura.springbootdifactura.models;

public class Product {

    // Atributos
    private String name;
    private Integer price;

    // Constructores
    public Product() {
    }
    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }


    
}
