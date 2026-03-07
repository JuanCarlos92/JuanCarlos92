package com.juancarlos.springboot.di.app.springboot_di.models;

// Modelo de Producto
public class Product implements Cloneable {

    // Atributos
    private Long id;
    private String name;
    private Long price;

    // Constructores
    public Product() {
    }

    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    // Override clone method
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Product(this.getId(), this.getName(), this.getPrice());
        }

    }

}
