package com.econocom.PruebaBorja.auth.dto;

public class Token {

    public String token;

    public String getToken() {
        return token;
    }
    public void setToken(String token) {this.token = token;}
}

/** CLASE PARA MANEJAR EL TOKEN Y HACERLE LA LOGICA DEL MANEJO DE CADUCIDAD COMO PIDE LA PRUEBA*/