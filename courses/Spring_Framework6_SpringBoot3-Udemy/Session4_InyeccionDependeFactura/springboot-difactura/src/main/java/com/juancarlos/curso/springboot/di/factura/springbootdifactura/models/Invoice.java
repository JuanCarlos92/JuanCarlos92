package com.juancarlos.curso.springboot.di.factura.springbootdifactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
// @JsonIgnoreProperties({"advisors","targetSource"})
public class Invoice {

    // Attributes
    @Autowired // Inyecta el bean de tipo Client en la propiedad client
    private Client client;
    // Inyecta el valor de la propiedad "invoice.description.office" desde el archivo de configuración
    @Value("${invoice.description.office}") 
    private String description;

    @Autowired // Inyecta el bean de tipo List<Item> con el qualifier "office" en la propiedad items
    // Inyecta el bean de tipo List<Item> con el qualifier "default" en la propiedad items
    @Qualifier("default")
    private List<Item> items;

    // Constructor
    public Invoice() {
        System.out.println("Creando el componente de la factura");
        System.out.println(client);
        System.out.println(description);
    }

    @PostConstruct // Método que se ejecuta después de que el bean o componente ha sido creado e inyectado
    public void init() {
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat(" Pepe"));
        description = description.concat(" del cliente: ").concat(client.getName()).concat(" ")
                .concat(client.getLastname());

    }

    @PreDestroy // Método que se ejecuta antes de destruir el bean o componente
    public void destroy() {
        System.out.println("Destruyendo el componente o bean de la factura");
    }

    // Getters and Setters
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    // Método para calcular el total de la factura sumando los importes de cada item
    public int getTotal() {
        // int total = 0;
        // for (Item item : items) {
        // total = total + item.getImporte();
        // }

        int total = items.stream()
                .map(item -> item.getImporte())
                .reduce(0, (sum, importe) -> sum + importe);
        return total;
    }

}
