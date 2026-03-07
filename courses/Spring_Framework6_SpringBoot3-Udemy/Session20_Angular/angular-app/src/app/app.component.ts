import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductComponent } from './products/components/product.component';

// Decorador del componente
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, ProductComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

// Clase del componente
export class AppComponent {
  title: string = 'Hola mundo Angular 17';
  enabled: boolean = false;

  courses: string[] = ['Angular', 'React', 'Spring Boot'];

  setEnabled(): void {
    this.enabled = this.enabled? false: true;
    console.log('hemos hecho clic en setEnabled')
  }
}
