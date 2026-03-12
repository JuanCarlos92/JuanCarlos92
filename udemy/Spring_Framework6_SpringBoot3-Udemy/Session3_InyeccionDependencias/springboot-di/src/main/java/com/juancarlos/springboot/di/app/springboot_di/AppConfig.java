package com.juancarlos.springboot.di.app.springboot_di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.juancarlos.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.juancarlos.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

// Configuracion de la aplicacion
@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    // Inyectar recurso desde config.properties
    @Value("classpath:config.properties")
    private Resource resource;

    // Definir bean para ProductRepositoryJson
    @Bean("productJson")
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }
}
