package aobytes.banquetpro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    /*
     * Creamos un PasswordEncoder utilizando BCrypt
     * pring podrá inyectar este objeto donde lo necesitemos
     * Lo utilizaremos para
     * 1. Guardar una contraseña:
     * passwordEncoder.encode("123456")
     * 2. Comprobar una contraseña:
     * passwordEncoder.matches(passwordIngresada, passwordBD)
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     * Aquí configuramos las reglas de seguridad de nuestra API.
     * SecurityFilterChain es la cadena de filtros que Spring Security
     * utiliza para decidir qué peticiones pueden entrar a nuestra aplicación.
     */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/banquetpro/api/user/**").permitAll()
                        .requestMatchers("/banquetpro/api/event/**").permitAll()
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest().authenticated());

        return http.build();
    }
}