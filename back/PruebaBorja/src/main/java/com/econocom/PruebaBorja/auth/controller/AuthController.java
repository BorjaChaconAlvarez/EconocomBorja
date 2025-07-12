package com.econocom.PruebaBorja.auth.controller;


import com.econocom.PruebaBorja.auth.dto.AuthRequest;
import com.econocom.PruebaBorja.auth.dto.AuthResponse;
import com.econocom.PruebaBorja.auth.dto.Token;
import com.econocom.PruebaBorja.auth.service.AuthService;
import com.econocom.PruebaBorja.config.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {


    private final AuthService servicio;

    public AuthController(AuthService servicio) {
        this.servicio = servicio;
    }

    /** METODO DE LOGIN DEL USUARIO*/

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        String token = servicio.login(authRequest.getCorreo(), authRequest.getContrasenia());
        if (token == null) {
            return ResponseEntity.status(401).body("Las credenciales que has metido son invalidas");
        }
        long validez = System.currentTimeMillis() + JwtUtil.getTiempo();
        return ResponseEntity.ok(new AuthResponse(token,validez));

    }
    /** METODO DE VALIDACION DEL TOKEN*/

    @PostMapping("/validate")
    public ResponseEntity<?> validate(@RequestBody Token cuerpo){
        return servicio.valido(cuerpo.getToken())
                ? ResponseEntity.ok("El token es valido")
                : ResponseEntity.status(401).body("El token no es valido");
    }

/** METODO PARA ACTUALIZAR EL TOKEN SI ESTE CADUCA */

@PostMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody Token cuerpo){

        String nuevo = servicio.actualizar(cuerpo.getToken());
        if (nuevo == null) {
            return ResponseEntity.status(401).body("El token no es valido");
        }

        long validez = System.currentTimeMillis() + JwtUtil.getTiempo();
        return ResponseEntity.ok(new AuthResponse(nuevo,validez));
    }
}
