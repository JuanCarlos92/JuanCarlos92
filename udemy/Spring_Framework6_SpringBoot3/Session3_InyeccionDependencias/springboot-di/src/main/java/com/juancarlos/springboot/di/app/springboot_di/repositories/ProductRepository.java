package com.juancarlos.springboot.di.app.springboot_di.repositories;

import java.util.List;

import com.juancarlos.springboot.di.app.springboot_di.models.Product;

// Interfaz del Repositorio de Productos
public interface ProductRepository {
    List<Product>  findAll();

    Product findById(Long id);
}
