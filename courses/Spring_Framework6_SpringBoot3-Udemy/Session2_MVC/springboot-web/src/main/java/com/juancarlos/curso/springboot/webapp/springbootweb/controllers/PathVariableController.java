package com.juancarlos.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juancarlos.curso.springboot.webapp.springbootweb.models.User;
import com.juancarlos.curso.springboot.webapp.springbootweb.models.dto.ParamDto;

/**
 * Controlador REST que maneja variables de ruta (path variables) y propiedades de configuración.
 * Mapea las solicitudes a la ruta base /api/var y demuestra diferentes formas de inyectar valores.
 */
@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    // Inyección de propiedades desde el archivo de configuración
    @Value("${config.username}")
    private String username;

    // Inyección de una lista de valores desde la configuración
    @Value("${config.listOfValues}")
    private List<String> listOfValues;
    
    // Inyección de un código entero desde la configuración
    @Value("${config.code}")
    private Integer code;
    
    // Inyección de una lista transformada a mayúsculas y dividida por comas
    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valueList;

    // Inyección de una cadena de valores transformada a mayúsculas
    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String valueString;

    // Inyección de un mapa completo desde la configuración
    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    // Inyección del valor 'product' del mapa de configuración
    @Value("#{${config.valuesMap}.product}")
    private String product;
    
    // Inyección del valor 'price' del mapa de configuración
    @Value("#{${config.valuesMap}.price}")
    private Long price;

    // Inyección del objeto Environment para acceder dinámicamente a propiedades
    @Autowired
    private Environment environment;
    

    @GetMapping("/baz/{message}") // GET /api/var/baz/HOLAAA
    public ParamDto baz(@PathVariable String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }
    
    @GetMapping("/mix/{product}/{id}") // GET /api/var/mix/TECLADO RAZER/2000
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {

        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);

        return json;
    }
    
    @PostMapping("/create") // POST /api/var/create  (CREAS UN Json y lo envias)
    public User create(@RequestBody User user) {
        // hacer algo con el usuario save en la bbdd
        // Convertir el nombre del usuario a mayúsculas
        user.setName(user.getName().toUpperCase());
        return user;
    }

    @GetMapping("/values") // GET /api/var/values (TODO EL VALUES)
    public Map<String, Object> values(@Value("${config.message}") String message) {
        // Obtener la propiedad code como Long a través del Environment
        Long code2 = environment.getProperty("config.code", Long.class);
        
        // Crear un mapa para retornar todos los valores configurados
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("message2", environment.getProperty("config.message"));
        json.put("code2", code2);
        json.put("listOfValues", listOfValues);
        json.put("valueString", valueString);
        json.put("valueList", valueList);
        json.put("valueMap", valuesMap);
        json.put("product", product);
        json.put("price", price);
        return json;
    }
}
