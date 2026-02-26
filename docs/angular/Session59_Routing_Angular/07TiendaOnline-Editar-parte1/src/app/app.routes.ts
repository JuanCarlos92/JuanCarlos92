import { Routes } from '@angular/router';
import { ListadoProductosComponent } from './listado-productos/listado-productos.component';
import { FormularioComponent } from './formulario/formulario.component';

export const routes: Routes = [
    {path:'', component: ListadoProductosComponent}, //localhost:4200/
    {path:'listado', component: ListadoProductosComponent},
    {path:'agregar', component: FormularioComponent},
    {path:'editar/:id', component: FormularioComponent }
];
