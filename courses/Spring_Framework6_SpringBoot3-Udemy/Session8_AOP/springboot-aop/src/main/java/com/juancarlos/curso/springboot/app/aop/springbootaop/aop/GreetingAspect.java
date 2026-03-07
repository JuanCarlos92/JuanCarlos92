package com.juancarlos.curso.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(2) // Creamos un aspecto para el metodo greet() de la clase GreetingService, para mostrar
@Aspect // Indicamos que esta clase es un aspecto
@Component
public class GreetingAspect {

    // Creamos un logger para mostrar los mensajes en la consola
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // Creamos un metodo que se ejecutara antes de la ejecucion del metodo greet()
    // de la clase GreetingService
    @Before("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " con los argumentos " + args);
    }

    // Creamos un metodo que se ejecutara despues de la ejecucion del metodo greet()
    // de la clase GreetingService
    @After("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfter(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues: " + method + " con los argumentos " + args);
    }

    // Creamos un metodo que se ejecutara despues de la ejecucion del metodo greet()
    // de la clase GreetingService, pero solo si el metodo retorna un valor
    @AfterReturning("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfterReturningr(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de retornar: " + method + " con los argumentos " + args);
    }

    // Creamos un metodo que se ejecutara despues de la ejecucion del metodo greet()
    // de la clase GreetingService, pero solo si el metodo lanza una excepcion
    @AfterThrowing("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfterThrowing(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues lanzar la excepcion: " + method + " con los argumentos " + args);
    }

    // Creamos un metodo que se ejecutara alrededor de la ejecucion del metodo
    // greet() de la clase GreetingService, es decir, antes y despues de la
    // ejecucion del metodo
    @Around("GreetingServicePointcuts.greetingLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;
        try {
            logger.info("El metodo " + method + "() con los parametros " + args);
            result = joinPoint.proceed();
            logger.info("El metodo " + method + "() retorna el resultado: " + result);
            return result;
        } catch (Throwable e) {
            logger.error("Error en la llamada del metodo " + method + "()");
            throw e;
        }

    }
}
