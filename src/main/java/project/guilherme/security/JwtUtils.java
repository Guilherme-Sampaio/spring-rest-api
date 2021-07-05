package project.guilherme.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import project.guilherme.service.LoggerService;
import project.guilherme.service.UserDetailsProvider;

import java.util.Date;

@Component
public class JwtUtils {

    @Value("${guilherme.security.jwtSecret}")
    private String jwtSecret;

    @Value("${guilherme.security.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {
        UserDetailsProvider user = (UserDetailsProvider) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            LoggerService.logger("Invalid JWT signature:", e);
        } catch (MalformedJwtException e) {
            LoggerService.logger("Invalid JWT token:", e);
        } catch (ExpiredJwtException e) {
            LoggerService.logger("JWT token is expired:", e);
        } catch (UnsupportedJwtException e) {
            LoggerService.logger("JWT token is unsupported:", e);
        } catch (IllegalArgumentException e) {
            LoggerService.logger("JWT claims string is empty:", e);
        }

        return false;
    }
}
