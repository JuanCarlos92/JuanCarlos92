package com.juancarlos.curso.springboot.app.aop.springbootaop.services;

// Creamos una interfaz para el servicio de saludo, con dos metodos, uno que retorna un saludo y otro que lanza una excepcion
public interface GreetingService {
    String sayHello(String person, String phrase);
    String sayHelloError(String person, String phrase);
}
