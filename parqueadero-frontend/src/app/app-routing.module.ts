import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteDetailComponent } from './components/cliente-detail/cliente-detail.component';
import { ClienteFormComponent } from './components/cliente-form/cliente-form.component';
import { ClienteListComponent } from './components/cliente-list/cliente-list.component';
import { ServicioListComponent } from './components/servicio-list/servicio-list.component';
import {ParqueaderoDetailComponent} from "./components/parqueadero-detail/parqueadero-detail.component";

const routes: Routes = [
  { path: 'clientes', component: ClienteListComponent },
  { path: 'clientes/new', component: ClienteFormComponent },
  { path: 'clientes/edit/:id', component: ClienteFormComponent },
  { path: 'clientes/:id', component: ClienteDetailComponent },
  { path: 'servicios', component: ServicioListComponent },
  { path: 'parqueadero', component: ParqueaderoDetailComponent }, // Nueva ruta para la información del parqueadero
  { path: '', redirectTo: '/clientes', pathMatch: 'full' },
  { path: '**', redirectTo: '/clientes' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
