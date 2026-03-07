package com.juancarlos.curso.springboot.error.springbooterror.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juancarlos.curso.springboot.error.springbooterror.exceptions.UserNotFountException;
import com.juancarlos.curso.springboot.error.springbooterror.models.domain.User;
import com.juancarlos.curso.springboot.error.springbooterror.services.UserService;

//Controlador de ejemplo para manejar solicitudes relacionadas con la aplicación
@RestController
@RequestMapping("/app") // Ruta base para las solicitudes del controlador
public class AppController {

    // Inyección del servicio
    @Autowired
    private UserService service;
 
    // Maneja solicitudes GET a la ruta base "/app"
    @GetMapping
    public String index() {
        // int value = 100 / 0;
        int value = Integer.parseInt("20x");
        System.out.println(value);
        return "ok 200";
    }

    // Maneja solicitudes GET a la ruta "/app/show/{id}"
    @GetMapping("/show/{id}")
    public User show(@PathVariable(name = "id") Long id) {
        User user = service.findById(id).orElseThrow(() -> new UserNotFountException("Error el usuario no existe!"));
        // System.out.println(user.getLastName());
        return user;

    }
}
