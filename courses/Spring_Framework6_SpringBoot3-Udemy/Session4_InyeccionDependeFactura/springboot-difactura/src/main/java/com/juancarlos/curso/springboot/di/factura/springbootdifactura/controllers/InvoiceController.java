package com.juancarlos.curso.springboot.di.factura.springbootdifactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juancarlos.curso.springboot.di.factura.springbootdifactura.models.Client;
import com.juancarlos.curso.springboot.di.factura.springbootdifactura.models.Invoice;
import org.springframework.web.bind.annotation.GetMapping;

//Controlador REST para manejar solicitudes relacionadas con facturas
@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    //Inyección de dependencia del servicio de factura
    @Autowired
    private Invoice invoice;

    //Método para mostrar los detalles de la factura
    @GetMapping("/show")
    public Invoice show() {
        Invoice i = new Invoice();
        Client cliente = new Client();
        cliente.setLastname(invoice.getClient().getLastname());
        cliente.setName(invoice.getClient().getName());
    
        i.setClient(cliente);
        i.setDescription(invoice.getDescription());
        i.setItems(invoice.getItems());
        return i;
    }
}
