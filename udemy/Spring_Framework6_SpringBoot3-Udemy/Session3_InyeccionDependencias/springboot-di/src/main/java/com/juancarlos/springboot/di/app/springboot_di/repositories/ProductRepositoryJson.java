package com.juancarlos.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juancarlos.springboot.di.app.springboot_di.models.Product;

// Implementación de ProductRepository que lee desde un archivo JSON
public class ProductRepositoryJson implements ProductRepository {

    // Lista de productos
    private List<Product> list;

    // Constructor que carga los productos desde un archivo JSON en el classpath
    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("json/product.json");
        readValueJson(resource);
    }

    // Constructor que acepta un recurso externo
    public ProductRepositoryJson(Resource resource) {
        readValueJson(resource);
    }

    // Método privado para leer y mapear el archivo JSON a la lista de productos
    private void readValueJson(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    // Método para obtener todos los productos
    public List<Product> findAll() {
        return list;
    }

    @Override
    // Método para encontrar un producto por su ID
    public Product findById(Long id) {
        return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

}
