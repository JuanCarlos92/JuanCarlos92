package com.juancarlos.curso.springboot.error.springbooterror.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.juancarlos.curso.springboot.error.springbooterror.models.Error;

//Controlador de manejo de excepciones global para la aplicación
@RestControllerAdvice
public class HandlerExceptionController {

    // Maneja excepciones de tipo ArithmeticException (división por cero)
    @ExceptionHandler({ ArithmeticException.class })
    public ResponseEntity<Error> divisionByZero(Exception ex) {
        Error error = new Error();

        error.setDate(new Date());
        error.setError("Error division por cero!");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        // return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    // Maneja excepciones de tipo NumberFormatException (formato numérico inválido)
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception ex) {

        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "numero invalido o incorrecto, no tiene formato de digito!");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

    // // // @ExceptionHandler({ NumberFormatException.class,
    // // //         HttpMessageNotWritableException.class,
    // // //         UserNotFountException.class })
    // // // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    // // // public Map<String, Object> userNotFountException(Exception ex) {

    // // //     Map<String, Object> error = new HashMap<>();
    // // //     error.put("date", new Date());
    // // //     error.put("error", "El usuario o role no existe!");
    // // //     error.put("message", ex.getMessage());
    // // //     error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

    // // //     return error;
    // // // }

    // Maneja excepciones de tipo NoHandlerFoundException (ruta no encontrada)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundEx(NoHandlerFoundException e) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Api rest no encontrado");
        error.setMessage(e.getMessage());

        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }
}
