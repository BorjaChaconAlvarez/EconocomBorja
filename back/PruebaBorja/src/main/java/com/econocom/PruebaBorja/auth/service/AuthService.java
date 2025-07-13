package com.econocom.PruebaBorja.auth.service;

import com.econocom.PruebaBorja.auth.dto.AuthRequest;
import com.econocom.PruebaBorja.config.JwtUtil;
import com.econocom.PruebaBorja.model.AppUser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class AuthService {

    private static final Path Usuarios_File = Paths.get("usuarios.json");
    private static final Map<String, AppUser> Usuarios = new HashMap<>();

    /** Leer el fichero con los usuarios registrados */
    public AuthService(){
        if(Files.exists(Usuarios_File)){
            try{
                ObjectMapper m = new ObjectMapper();
                List<AppUser> listaUsuarios = m.readValue(Usuarios_File.toFile(), new TypeReference<List<AppUser>>() {
                });
                listaUsuarios.forEach(u -> Usuarios.put(u.getCorreo(),u));
            }catch (IOException e){
               /** throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo guardar el usuario"); Salta error al descomentar esta linea */

            }
        }
     /** USUARIO DE PRUEBA PARA COMPROBAR LA PRIMERA PARTE DE LA PRUEBA */

     Usuarios.put("admin@gmail.com", new AppUser("admin@gmail.com", "admin"));

 }


 /** METODO PARA REGISTRARSE EN LA APLICACIÓN GUARDANDO LOS DATOS EN EL FICHERO */

 public void registro (AuthRequest regis) throws IllegalAccessException {
     String correo = regis.getCorreo();
     String contrasenia = regis.getContrasenia();

     if (Usuarios.containsKey(correo)){
         throw new IllegalAccessException("Ya existe un usuario con este correo electrónico");
     }
     AppUser nuevoUsuario = new AppUser(correo, contrasenia);
     Usuarios.put(correo, nuevoUsuario);

     try{
         ObjectMapper m = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
         m.writeValue(Usuarios_File.toFile(), Usuarios.values());
     }catch (IOException e){
         throw new IllegalAccessException("No se ha podido generar el registro del usuario" );
     }

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
