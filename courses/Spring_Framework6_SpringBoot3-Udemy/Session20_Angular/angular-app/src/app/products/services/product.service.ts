import { Injectable } from '@angular/core';
import { Product } from '../models/product';
import { map, Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

// Decorador de servicio
@Injectable({
  providedIn: 'root'
})

// Clase del servicio
export class ProductService {

  // Simulación de datos de productos
  private products: Product[] = [
    {
      id: 1,
      name: 'Mesa comedor',
      description: 'Excelente mesa para el comedor',
      price: 700
    },
    {
      id: 2,
      name: 'Teclado mecanico',
      description: 'Excelente teclado para typing',
      price: 500
    }
  ];
  // URL base para la API de productos
  private url: string = 'http://localhost:8080/products';
  constructor(private http: HttpClient) { }

  // Método para obtener todos los productos
  findAll(): Observable<Product[]> {
    // return of(this.products);
    return this.http.get<Product[]>(this.url).pipe(map((response: any) => response._embedded.products as Product[]),
    );

  // Método para obtener un producto por su ID
  }
  create(product: Product): Observable<Product> {
    return this.http.post<Product>(this.url, product);
  }

  // Método para actualizar un producto existente
  update(product: Product): Observable<Product> {
    return this.http.put<Product>(`${this.url}/${product.id}`, product);
  }
  // Método para eliminar un producto por su ID
  remove(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`)
  }
}
