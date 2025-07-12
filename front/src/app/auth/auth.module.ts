import { NgModule }               from '@angular/core';
import { CommonModule }           from '@angular/common';
import { FormsModule }            from '@angular/forms';
import { HttpClientModule }       from '@angular/common/http';

/* ---------- Angular Material que usa LoginComponent ---------- */
import { MatInputModule }         from '@angular/material/input';
import { MatFormFieldModule }     from '@angular/material/form-field';
import { MatButtonModule }        from '@angular/material/button';
import { MatIconModule }          from '@angular/material/icon';

/* ---------- Componentes del módulo ---------- */
import { LoginComponent }         from './login/login.component';

@NgModule({
  declarations: [ LoginComponent ],      // ¡Solo componentes NO-standalone!
  imports: [
    CommonModule,
    FormsModule,                         // ngForm, ngModel
    HttpClientModule,

    /* Material necesarios en la plantilla de LoginComponent */
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatIconModule,
  ],
  exports: [ LoginComponent ]            // lo exportamos para usarlo fuera
})
export class AuthModule { }
