package aobytes.banquetpro.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    private final String SECRET_KEY = "BanquetPro-Secret-Key-Para-JWT-2026-MuySegura";

    /*
     * Creamos la llave criptográfica a partir del texto anterior.
     */
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    /*
     * Genera un JWT para el usuario indicado.
     */
    public String generarToken(String username) {

        return Jwts.builder()
                // Identifica al usuario dueño del token
                .subject(username)
                // Fecha en la que se creó el token
                .issuedAt(new Date())
                // El token será válido durante 1 hora
                .expiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                // Firmamos el token con nuestra llave secreta
                .signWith(getSigningKey())
                // Finalmente construimos el JWT
                .compact();
    }
}