import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
   styleUrls: ['./registro.component.scss'],
encapsulation: ViewEncapsulation.None   
})
export class RegisterComponent{
  form!: FormGroup;
  loading = false;
  errorMsg = '';
  hide: any;

  constructor(
    private fb: FormBuilder,
    private auth: AuthService,
    private router: Router
  ) {}

  ngOnInit() {
    this.form = this.fb.group({
      correo: ['', [Validators.required, Validators.email]],
      contrasenia: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit() {
    if (this.form.invalid) return;
    this.loading = true;
    this.errorMsg = '';

    const { correo, contrasenia } = this.form.value;
    this.auth.registro(correo, contrasenia)
      .subscribe({
        next: _ => {
          alert('¡Registro correcto! Ahora puedes iniciar sesión.');
          this.router.navigate(['/login']);
        },
        error: err => {
          this.errorMsg = err.error || 'Error al registrar';
          this.loading = false;
        }
      });
  }
}
