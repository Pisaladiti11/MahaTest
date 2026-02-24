package com.MahaTest.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "mySuperSecureKeyThatIsAtLeast32CharactersLong!"; // ✅ same key

    // Convert SECRET_KEY to Key object for HS256
    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    private final long JWT_EXPIRATION = 1000 * 60 * 60 * 10; // 10 hours

    // Generate token
    public String generateToken(String mobNo) {
        return Jwts.builder()
                .setSubject(mobNo)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(key)
                .compact();
    }

    // Validate token
    public boolean validateToken(String token, String mobNo) {
        return getMobNo(token).equals(mobNo) && !isTokenExpired(token);
    }

    // Extract mobile number
    public String getMobNo(String token) {
        return getClaims(token).getSubject();
    }

    // Check expiration
    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    // Extract claims
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}