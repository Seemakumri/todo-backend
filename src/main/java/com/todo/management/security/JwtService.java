//package com.todo.management.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class JwtService {
//
//    private static final String SECRET_KEY =
//            "mySecretKeymySecretKeymySecretKeymySecretKey";
//
//    private static final long EXPIRATION =
//            1000 * 60 * 60 * 24;
//
//    public String generateToken(String email) {
//
//        return Jwts.builder()
//                .setSubject(email)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//
//    }
//
//    public String extractUsername(String token) {
//
//        return extractClaims(token).getSubject();
//
//    }
//
//    public boolean validateToken(String token, String email) {
//
//        return extractUsername(token).equals(email)
//                && !extractClaims(token).getExpiration().before(new Date());
//
//    }
//
//    private Claims extractClaims(String token) {
//
//        return Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody();
//
//    }
//
//}