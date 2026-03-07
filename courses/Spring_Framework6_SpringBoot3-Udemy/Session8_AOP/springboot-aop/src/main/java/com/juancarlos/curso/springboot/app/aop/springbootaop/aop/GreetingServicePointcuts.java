package com.juancarlos.curso.springboot.app.aop.springbootaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // Creamos una clase para definir los pointcuts, para evitar repetir el mismo pointcut en cada aspecto
@Component // Indicamos que esta clase es un componente de Spring, para que pueda ser detectada por el escaneo de componentes
public class GreetingServicePointcuts {
    
    // Creamos un pointcut para el metodo greet() de la clase GreetingService, para mostrar
    @Pointcut("execution(* com.andres.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void greetingLoggerPointCut() {
    }
    
    // Creamos un pointcut para el metodo greetFoo() de la clase GreetingService, para mostrar
    @Pointcut("execution(* com.andres.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void greetingFooLoggerPointCut() {
    }
}
