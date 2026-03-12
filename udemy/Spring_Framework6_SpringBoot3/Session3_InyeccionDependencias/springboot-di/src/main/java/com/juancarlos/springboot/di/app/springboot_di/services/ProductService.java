package com.juancarlos.springboot.di.app.springboot_di.services;

import java.util.List;

import com.juancarlos.springboot.di.app.springboot_di.models.Product;

// Servicio de Producto
public interface ProductService {
    List<Product>  findAll();

    Product findById(Long id);

}
