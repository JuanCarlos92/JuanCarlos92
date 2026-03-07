package com.juancarlos.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juancarlos.springboot.di.app.springboot_di.models.Product;
import com.juancarlos.springboot.di.app.springboot_di.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class SomeController { // singleton

    /*
     * private ProductService service = new ProductService();<-- Mal uso
     * inmutabilidad
     */

    @Autowired // <-- Autowired en atributo (Implementar desde la interfaz)
    private ProductService service;

    @GetMapping
    public List<Product> list() {
        return service.findAll(); //<-- Retorna una lista de productos
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return service.findById(id); //<-- Retorna un producto por id
    }
}
