package com.juancarlos.curso.springboot.app.aop.springbootaop.services;

import org.springframework.stereotype.Service;

@Service // Indicamos que esta clase es un servicio de Spring, para que pueda ser detectada por el escaneo de componentes
public class GreetingServiceImpl implements GreetingService {

    // Implementamos el metodo sayHello() para retornar un saludo con el nombre de la persona y la frase recibida
    @Override
    public String sayHello(String person, String phrase) {
        String greeting = phrase + " " + person;
        System.out.println(greeting);
        return greeting;
    }

    // Implementamos el metodo sayHelloError() para lanzar una excepcion, para probar el aspecto de excepciones
    @Override
    public String sayHelloError(String person, String phrase) {
        throw new RuntimeException("algun error");
    }
    
}
