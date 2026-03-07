package com.juancarlos.curso.springboot.app.interceptor.springbootinterceptor.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//con esta anotación se indica que es un controlador REST, es decir, que los métodos de este controlador van a devolver objetos que se van a convertir a JSON
@RestController
@RequestMapping("/app") // con esta anotación se indica que todas las rutas de este controlador van a
                        // empezar con /app.
public class FooController {

    // con esta anotación se indica que este método va a manejar las peticiones GET a la ruta /app/foo, es decir, a la ruta /app + /foo
    @GetMapping("/foo")
    public Map<String, String> foo() {

        return Collections.singletonMap("message", "handler foo del controlador");
    }

    // con esta anotación se indica que este método va a manejar las peticiones GET a la ruta /app/bar, es decir, a la ruta /app + /bar
    @GetMapping("/bar")
    public Map<String, String> bar() {

        return Collections.singletonMap("message", "handler bar del controlador");
    }

    // con esta anotación se indica que este método va a manejar las peticiones GET a la ruta /app/baz, es decir, a la ruta /app + /baz
    @GetMapping("/baz")
    public Map<String, String> baz() {

        return Collections.singletonMap("message", "handler baz del controlador");
    }
}
