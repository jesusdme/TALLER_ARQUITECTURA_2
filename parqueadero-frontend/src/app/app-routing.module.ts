import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteDetailComponent } from './components/cliente-detail/cliente-detail.component';
import { ClienteFormComponent } from './components/cliente-form/cliente-form.component';
import { ClienteListComponent } from './components/cliente-list/cliente-list.component';

const routes: Routes = [
  { path: 'clientes', component: ClienteListComponent },       // Lista de clientes
  { path: 'clientes/new', component: ClienteFormComponent },    // Crear cliente
  { path: 'clientes/edit/:id', component: ClienteFormComponent }, // Editar cliente
  { path: 'clientes/:id', component: ClienteDetailComponent },  // Detalle del cliente
  { path: '', redirectTo: '/clientes', pathMatch: 'full' }      // Redirigir a /clientes por defecto
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
