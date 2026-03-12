import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Product } from '../models/product';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';

//Componente HIJO
@Component({
  selector: 'product-form',
  imports: [FormsModule, CommonModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {

  @Input() product: Product = {
    id: 0,
    name: '',
    description: '',
    price: 0
  };

  //Crea un EventEmitter() 
  @Output() newProductEvent = new EventEmitter();

  onSubmit(productForm: NgForm): void {
    if (productForm.valid) {
      this.newProductEvent.emit(this.product); // <-- emite el product 
      console.log(this.product);
    }
    productForm.reset();
    productForm.resetForm();
  }

  //Limpiar form
  clean(): void {
    this.product = {
      id: 0,
      name: '',
      description: '',
      price: 0
    };
  }
}