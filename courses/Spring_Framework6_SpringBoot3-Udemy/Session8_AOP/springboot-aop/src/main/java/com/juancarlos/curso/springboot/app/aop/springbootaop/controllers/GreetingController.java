package com.juancarlos.curso.springboot.app.aop.springbootaop.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juancarlos.curso.springboot.app.aop.springbootaop.services.GreetingService;

// Creamos un controlador para probar los aspectos creados
@RestController
public class GreetingController {
    
    // Inyectamos el servicio para poder llamar a los metodos greet() y greetFoo()
    @Autowired
    private GreetingService greetingService;

    // Creamos un endpoint para probar el metodo greet() y ver los aspectos en accion
    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {
        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHello("Pepe", "Hola que tal!")));
    }
    // Creamos un endpoint para probar el metodo greetFoo() y ver los aspectos en accion
    @GetMapping("/greeting-error")
    public ResponseEntity<?> greetingError() {
        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHelloError("Pepe", "Hola que tal!")));
    }

}
