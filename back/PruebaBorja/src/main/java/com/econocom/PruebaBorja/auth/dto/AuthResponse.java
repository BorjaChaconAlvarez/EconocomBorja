package com.econocom.PruebaBorja.auth.dto;

public class AuthResponse {
    private String token;
    private long validacion; //caducidad del Token

    public AuthResponse(String token , long validacion) {

        this.token = token;
        this.validacion = validacion;
    }

    public String getToken() {return token;}
    public long getValidacion() {return validacion;}

}

/** LA RESPUESTA QUE SE VA A OBTENER DESPUÉS DEL INICIO DE SESIÓN*/

