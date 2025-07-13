package com.econocom.PruebaBorja.config;


import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import static java.security.KeyRep.Type.SECRET;


public class JwtUtil {

    /**  Clave de 32+ bytes    */

    private static final String SECRET =
            "xT4vJ7sQ1nZaR9eB5uM3wK8hD6pC2fLg";

    /**  Genera el objeto Key compatible con HS-256 */
    private static final Key SIGNING_KEY =
            Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    private static final long tiempo = 2 * 60 * 1000;   // 15 minutos

    /** Generar el token */
    public static String generate(String correo) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(correo)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + tiempo))
                .signWith(SIGNING_KEY, SignatureAlgorithm.HS256)   
                .compact();
    }

    /** Validar  el token */
    public static boolean isValid(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SIGNING_KEY)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException ex) {
            return false;
        }
    }
    public static long getTiempo(){
        return tiempo;
    } /** Tiempo en milisegundos para que el calculo sea automático*/
}

// CLASE PARA GENERAR EL TOKEN