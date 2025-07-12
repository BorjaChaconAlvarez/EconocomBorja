import { NgModule } from '@angular/core';
import { LoginComponent } from './auth/login/login.component';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'login', component: LoginComponent },

  // cuando la URL esté vacía (http://localhost:4200/), envia a /login
  { path: '', redirectTo: 'login', pathMatch: 'full' },

  // comodín: cualquier otra ruta desconocida → /login
  { path: '**', redirectTo: 'login' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
