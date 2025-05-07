package cl.ufro.dci.registro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    @Profile("development")
    public SecurityFilterChain developmentSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Permitir acceso a la consola H2
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                        // Permitir endpoints de health
                        .requestMatchers("/api/*/health").permitAll()
                        // Permitir endpoints base de cada módulo
                        .requestMatchers("/api/reserva/**").permitAll()
                        .requestMatchers("/api/pago/**").permitAll()
                        .requestMatchers("/api/busqueda/**").permitAll()
                        .requestMatchers("/api/hospedaje/**").permitAll()
                        .requestMatchers("/api/evaluacion/**").permitAll()
                        .requestMatchers("/api/mensaje/**").permitAll()
                        .requestMatchers("/api/recompensas/**").permitAll()
                        .requestMatchers("/api/recompensas/**").permitAll()
                        .requestMatchers("/api/notificacion/**").permitAll()
                        // El módulo de usuarios requiere autenticación
                        .requestMatchers("/api/usuario/**").authenticated()
                        // El resto requiere autenticación
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/api/usuario/health")
                        .permitAll()
                )
                // Configuración para H2 Console
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.sameOrigin())
                )
                // Desactivar CSRF solo para los endpoints permitidos sin autenticación
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**"))
                        .ignoringRequestMatchers("/api/*/health")
                        .ignoringRequestMatchers("/api/reserva/**")
                        .ignoringRequestMatchers("/api/pago/**")
                        .ignoringRequestMatchers("/api/busqueda/**")
                        .ignoringRequestMatchers("/api/hospedaje/**")
                        .ignoringRequestMatchers("/api/evaluacion/**")
                        .ignoringRequestMatchers("/api/mensaje/**")
                        .ignoringRequestMatchers("/api/recompensas/**")
                        .ignoringRequestMatchers("/api/notificacion/**")
                );

        return http.build();
    }

    @Bean
    @Profile("!development")
    public SecurityFilterChain productionSecurityFilterChain(HttpSecurity http) throws Exception {
        // En producción, se usará la configuración normal de seguridad
        // que será implementada por los estudiantes en el módulo de autenticación
        return http.build();
    }
}