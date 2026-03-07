import { Routes } from '@angular/router';
import { ListadoUsuariosComponent } from './listado-usuarios/listado-usuarios.component';
import { MostrarMensajeComponent } from './mostrar-mensaje/mostrar-mensaje.component';
import { PadreComponent } from './padre/padre.component';
import { HijoComponent } from './padre/hijo/hijo.component';

export const routes: Routes = [
    {path:'', component: ListadoUsuariosComponent}, //localhost:4200/
    {path:'mostrar-mensaje', component: MostrarMensajeComponent},
    {
        path:'configuracion', children: [
            {path: 'padre', component: PadreComponent}, //localhost:4200/configuracion/padre
            {path: 'hijo', component: HijoComponent} //localhost:4200/configuracion/hijo
        ]
    }
];
