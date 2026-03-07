package com.juancarlos.curso.springboot.webapp.springbootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

// Configuración para cargar propiedades desde un archivo externo values.properties
@Configuration
@PropertySources({
        @PropertySource(value="classpath:values.properties", encoding = "UTF-8"),
})
public class ValuesConfig {
    
}
