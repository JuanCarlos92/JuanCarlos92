package com.juancarlos.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.juancarlos.curso.springboot.webapp.springbootweb.models.User;

@Controller
public class UserController {

    @GetMapping("/details") // GET /details
    public String details(Model model) {

        // Crear un usuario de ejemplo
        User user = new User("Andres", "Guzman");
        user.setEmail("andres@correo.com");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list") // GET /list
    // Muestra la lista de usuarios
    public String list(ModelMap model) {
        model.addAttribute("title", "Listado de usuarios!");
        return "list";
    }
    
    @ModelAttribute("users") // Se ejecuta antes de cada método del controlador y añade 'users' al modelo

    public List<User> usersModel() {
        // Crear y retornar una lista de usuarios de ejemplo
        return Arrays.asList(
                new User("Pepa", "Gonzalez"),
                new User("Lalo", "Perez", "lalo@correo.com"),
                new User("Juanita", "Roe", "juana@correo.com"),
                new User("Andres", "Doe"));
    }

}
