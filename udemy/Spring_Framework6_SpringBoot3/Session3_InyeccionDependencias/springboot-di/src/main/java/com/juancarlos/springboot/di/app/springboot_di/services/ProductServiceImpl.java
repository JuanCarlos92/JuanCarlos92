package com.juancarlos.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.springboot.di.app.springboot_di.models.Product;
import com.juancarlos.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
// Implementacion del servicio de productos
public class ProductServiceImpl implements ProductService {
    
    // Inyectar valor desde application.properties
    @Value("${config.price.tax}")
    private Double tax;
    
    private ProductRepository repository; // <-- Implementar desde la interfaz

    // <-- Autowire en constructor
    public ProductServiceImpl(@Qualifier("productJson") ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    // Metodo para encontrar todos los productos
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * tax;

            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;


        }).collect(Collectors.toList());
    }

    @Override
    // Metodo para encontrar un producto por id
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
