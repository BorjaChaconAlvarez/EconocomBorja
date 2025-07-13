import { NgModule } from '@angular/core';
import { LoginComponent } from './auth/login/login.component';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './auth/registro/registro.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },

  // cuando la URL esté vacía (http://localhost:4200/), envia a /login
  { path: '', redirectTo: 'login', pathMatch: 'full' },

  
  {path: 'registro',component: RegisterComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
