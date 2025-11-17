package fr.formation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // désactive CSRF pour éviter les erreurs avec Angular
                .cors(Customizer.withDefaults()) // active CORS dans la chaîne Security
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // autorise toutes les requêtes (à ajuster si besoin)
                );

        return http.build();
    }
}