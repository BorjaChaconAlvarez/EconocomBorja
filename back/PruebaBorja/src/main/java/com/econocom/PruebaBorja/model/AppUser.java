package com.econocom.PruebaBorja.model;

public class AppUser {
    private final String correo;
    private final String contrasenia;

    public AppUser(String correo, String contrasenia) {

        this.correo = correo;
        this.contrasenia = contrasenia;
    }
public String getCorreo() { return correo;}

public String getContrasenia() { return contrasenia;}

}


// CLASE SENCILLA DE UN USUARIO DE LA APP