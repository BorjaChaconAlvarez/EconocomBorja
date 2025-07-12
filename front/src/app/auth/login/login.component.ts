import { Component, ViewEncapsulation } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  encapsulation: ViewEncapsulation.None   
})
export class LoginComponent {
  hide = true;
  correoError = false;
  contraseniaError = false;

  //VARIABLES QUE INTENTE HACER PARA MANEJAR ERRORES

  constructor(private auth: AuthService) {}

  onSubmit(form: any) {
 

    const { correo, contrasenia } = form.value;
    this.auth.login(correo, contrasenia).subscribe({
      next: resp => {
        localStorage.setItem('token', resp.token);
        localStorage.setItem('exp', resp.validacion.toString());
        alert('Login correcto');
      },
      error: () => {
        
        alert('Credenciales incorrectas');
      }
    });
  }

  ssoSoon() {
    alert('SSO se implementará más adelante');
  }
}
