package com.econocom.PruebaBorja.auth.dto;

public class AuthRequest {

    private String correo;        // ← usa “correo”
    private String contrasenia;   // ← y “contrasenia”

    public AuthRequest() { }

    public AuthRequest(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    /* getters y setters */
    public String getCorreo()         { return correo; }
    public String getContrasenia()    { return contrasenia; }

    public void setCorreo(String correo)               { this.correo = correo; }
    public void setContrasenia(String contrasenia)     { this.contrasenia = contrasenia; }
}
/** LOS DATOS QUE VA ENVIAR EL USUARIO */