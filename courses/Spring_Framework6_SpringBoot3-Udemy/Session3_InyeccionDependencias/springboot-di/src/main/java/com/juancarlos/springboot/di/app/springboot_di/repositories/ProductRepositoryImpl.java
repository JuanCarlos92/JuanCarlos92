package com.juancarlos.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
// import org.springframework.web.context.annotation.RequestScope;
// import org.springframework.web.context.annotation.SessionScope;

import com.juancarlos.springboot.di.app.springboot_di.models.Product;

//@RequestScope //<-- deja de ser singleton
//@SessionScope //<-- en cada sesion se reinicia (por session)
@Primary
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {

    // Simulando una base de datos con una lista de productos
    private List<Product> data;

    public ProductRepositoryImpl(){
        // Inicializando la lista de productos
        this.data =  Arrays.asList(
            new Product(1L,"Memoria Ram Corsair 23gb", 230L),
            new Product(2L, "Disco duro ssd sandik 1T",110L),
            new Product(3L, "Tarjeta Grafica Nvidia 5080", 1200L),
            new Product(4L, "Procesador Intel Core i7", 450L));
    }

    @Override
    // Implementación de findAll
    public List<Product> findAll(){
            return data;
    }

    @Override
    // Implementación de findById
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
