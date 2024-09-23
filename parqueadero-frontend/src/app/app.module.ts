import { HttpClientModule } from '@angular/common/http'; // Importar HttpClientModule
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // Importar FormsModule si usarás formularios
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClienteDetailComponent } from './components/cliente-detail/cliente-detail.component';
import { ClienteListComponent } from './components/cliente-list/cliente-list.component';
import { ClienteFormComponent } from './components/cliente-form/cliente-form.component';
import { ServicioListComponent } from './components/servicio-list/servicio-list.component';
import { ServicioFormComponent } from './components/servicio-form/servicio-form.component';

@NgModule({
  declarations: [
    AppComponent,
    ClienteListComponent,
    ClienteDetailComponent,
    ClienteFormComponent,
    ServicioListComponent,
    ServicioFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,  // Añadir HttpClientModule
    FormsModule,       // Añadir FormsModule si se va a usar en los formularios
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
