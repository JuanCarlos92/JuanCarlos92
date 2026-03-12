package com.juancarlos.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador principal de la aplicación.
 * Maneja las solicitudes a la página de inicio y redirige a la lista de usuarios.
 */
@Controller
public class HomeController {
    

    @GetMapping({"", "/", "/home"}) // se puede especificar varios paths
    public String home() {

        // Redirige a la ruta /list (redirect hace que el navegador haga una nueva solicitud)
        return "redirect:/list";
        // Alternativa: return "forward:/list"; (forward es un redireccionamiento interno sin cambiar la URL)
        
    }
}