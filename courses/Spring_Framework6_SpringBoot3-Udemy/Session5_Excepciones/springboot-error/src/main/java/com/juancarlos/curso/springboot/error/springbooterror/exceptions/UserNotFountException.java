package com.juancarlos.curso.springboot.error.springbooterror.exceptions;

//Excepción personalizada para indicar que un usuario no fue encontrado
public class UserNotFountException extends RuntimeException {
    public UserNotFountException(String message) {
        super(message);
    }
}
