import { Component } from '@angular/core';
import { Cliente } from '../../modelo/cliente.modelo';
import { ClienteService } from '../../servicios/cliente.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './clientes.component.html',
  styleUrl: './clientes.component.css'
})
export class ClientesComponent {
  clientes: Cliente[] | null = null;

  constructor(private clienteServicio: ClienteService){}
  
  ngOnInit(){
    this.clienteServicio.getClientes().subscribe(clientes => {
      this.clientes = clientes;
    });
  }

}
