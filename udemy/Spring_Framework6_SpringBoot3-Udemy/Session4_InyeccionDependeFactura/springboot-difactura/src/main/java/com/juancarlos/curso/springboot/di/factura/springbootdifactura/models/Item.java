package com.juancarlos.curso.springboot.di.factura.springbootdifactura.models;

public class Item {

    // Atributos
    private Product product;
    private Integer quantity;

    // Constructores
    public Item() {
    }

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters y Setters
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int getImporte() {
        return this.quantity * this.product.getPrice();
    }
}