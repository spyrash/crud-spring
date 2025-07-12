package CRUD.demo.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtUtil {

    public static String generateToken(User user) {
        return Jwts
                .builder()
                .subject(user.getUsername())
                .expiration(new Date(System.currentTimeMillis() + 300_000))
                .signWith(getSigningKey())
                .compact();
                //video 1:59
    }

    public static Claims getClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public static boolean isTokenValid(String token) {
        // can add more validation logic here
        return !isExpired(token);
    }

    private static boolean isExpired(String token) {
        return getClaims(token)
                .getExpiration()
                .before(new Date());
    }

    private static SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode("yourScretKeyMustBeLongEnoughForSecuritySoIaddMoreCharactersHere123");
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
