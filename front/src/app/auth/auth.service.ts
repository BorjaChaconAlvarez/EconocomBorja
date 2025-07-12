import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly api ='http://localhost:8080/api/auth';

  constructor(private http: HttpClient) { }

  login(correo: string, contrasenia: string ): Observable<any>{
    return this.http.post(`${this.api}/login`, {correo, contrasenia});
  }

  validate(token:string): Observable<any>{
    return this.http.post(`${this.api}/valido`, {token});
  }

  actualizar(token:string): Observable<any> {
      return this.http.post(`${this.api}/actualizar`, {token});
  }
}
