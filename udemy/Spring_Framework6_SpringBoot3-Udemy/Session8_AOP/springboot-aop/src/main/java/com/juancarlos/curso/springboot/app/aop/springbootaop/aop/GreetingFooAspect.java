package com.juancarlos.curso.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(1) // Creamos un aspecto para el metodo greetFoo() de la clase GreetingService, para mostrar
@Component // Indicamos que esta clase es un aspecto
@Aspect // Indicamos que esta clase es un aspecto
public class GreetingFooAspect {
    // Creamos un logger para mostrar los mensajes en la consola
    private Logger logger = LoggerFactory.getLogger(getClass());

    // Creamos un metodo que se ejecutara antes de la ejecucion del metodo greetFoo()
    @Before("GreetingServicePointcuts.greetingFooLoggerPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes Primero: " + method + " invocado con los parametros " + args);
    }
    
    // Creamos un metodo que se ejecutara despues de la ejecucion del metodo greetFoo()
    @After("GreetingServicePointcuts.greetingFooLoggerPointCut()")
    public void loggerAfter(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues Primero: " + method + " invocado con los parametros " + args);
    }
}
