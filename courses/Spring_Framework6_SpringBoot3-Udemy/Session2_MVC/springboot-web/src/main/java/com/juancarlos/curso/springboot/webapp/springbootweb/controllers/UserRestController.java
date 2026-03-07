package com.juancarlos.curso.springboot.webapp.springbootweb.controllers;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juancarlos.curso.springboot.webapp.springbootweb.models.User;
import com.juancarlos.curso.springboot.webapp.springbootweb.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {
    
    @GetMapping(path="/details") // GET /api/details
    public UserDto details() {
        // Crear un usuario de ejemplo
        User user = new User("Andres", "Guzman");
        
        // Crear y retornar un UserDto con el usuario y el título
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring Boot");

        return userDto;
    }
    
    @GetMapping("/list") // GET /api/list
    public List<User> list() {
        // Crear una lista de usuarios de ejemplo
        User user = new User("Andres", "Guzman");
        User user2 = new User("Pepe", "Doe");
        User user3 = new User("Jhon", "Doe");

        // Crear y retornar la lista de usuarios
        List<User> users = Arrays.asList(user, user2, user3);
        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        return users;
    }
    
    @GetMapping(path = "/details-map") // GET /api/details-map
    public Map<String, Object> detailsMap() {
        // Crear un usuario de ejemplo
        User user = new User("Andres", "Guzman");
        // Crear y retornar un mapa con el usuario y el título
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Spring Boot");
        body.put("user", user);
        return body;
    }

}
