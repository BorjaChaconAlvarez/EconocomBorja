package com.econocom.PruebaBorja.auth.service;

import com.econocom.PruebaBorja.config.JwtUtil;
import com.econocom.PruebaBorja.model.AppUser;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;

@Service
public class AuthService {

    private static final Map<String, AppUser> Usuarios = new HashMap<>();
    static {

        /** USUARIOS DE PRUEBA PARA COMPROBAR LA PRIMERA PARTE DE LA PRUEBA */

        Usuarios.put("admin@gmail.com", new AppUser("admin@gmail.com", "admin"));
        Usuarios.put("user", new AppUser("user", "user"));

 }


 /** LOGIN PARA CORRECTO CON EL USUARIO Y CONTRASEÑA DE ARRIBA */
    public String login (String correo, String contrasenia) {
        AppUser user = Usuarios.get(correo);
        if (user != null) {
            if (user.getContrasenia().equals(contrasenia)) {
                return JwtUtil.generate(correo);
            }

        }
        return null;
    }

/** SABER SI EL TOKEN ESTA VALIDO */
    public boolean valido (String token){
        return JwtUtil.isValid(token);
    }


    /** ACTUALIZAR EL TOKEN */
    public String actualizar (String tokenCaducado){
        return JwtUtil.generate(tokenCaducado);
    }
}
