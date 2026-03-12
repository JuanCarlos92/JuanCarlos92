package com.juancarlos.curso.springboot.di.factura.springbootdifactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.juancarlos.curso.springboot.di.factura.springbootdifactura.models.Item;
import com.juancarlos.curso.springboot.di.factura.springbootdifactura.models.Product;

//Clase de configuración de la aplicación Spring Boot
@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8") //Carga un archivo de propiedades externo
public class AppConfig {
    
    //Definición de un bean para los ítems de la factura
    //@Primary
    @Bean
    List<Item> itemsInvoice(){
        Product p1 = new Product("Camara Sony", 800);
        Product p2 = new Product("Bicicleta  orbea", 1400);
        return Arrays.asList(new Item(p1,2),new Item(p2,4));

    }

    //Definición de otro bean para los ítems de la factura
    @Bean("default")
    List<Item> itemsInvoiceOffice(){
        Product p1 = new Product("Monitor asus", 700);
        Product p2 = new Product("Notebook Razer", 2400);
        Product p3 = new Product("Impresora HP", 600);
        Product p4 = new Product("Escritorio Oficina", 900);
        return Arrays.asList(new Item(p1,4),new Item(p2,6),new Item(p3,1),new Item(p4,4));

    }

}
