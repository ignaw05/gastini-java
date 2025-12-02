package com.gastini.gastini.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Permitir credenciales (cookies, headers de autorización)
        config.setAllowCredentials(true);

        // Permitir solicitudes desde localhost:3000 y Vercel
        // Usar setAllowedOriginPatterns en lugar de setAllowedOrigins cuando
        // allowCredentials es true
        config.setAllowedOriginPatterns(Arrays.asList("http://localhost:3000", "https://gastini.vercel.app"));

        // Permitir todos los headers
        config.addAllowedHeader("*");

        // Permitir todos los métodos HTTP (GET, POST, PUT, DELETE, etc.)
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));

        // Aplicar esta configuración a todos los endpoints
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
