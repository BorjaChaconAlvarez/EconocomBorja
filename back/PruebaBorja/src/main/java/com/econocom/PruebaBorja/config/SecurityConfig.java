package com.econocom.PruebaBorja.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()                 // ← habilita CORS usando CorsConfig
                .and()
                .csrf().disable()       // desactiva CSRF para API stateless
                .authorizeRequests()
                .anyRequest().permitAll();  // no protegemos rutas en esta prueba
    }
}



//FUNCIÓN PARA QUE PERMITA TODOS LOS MENSAJES DEL ANGULAR