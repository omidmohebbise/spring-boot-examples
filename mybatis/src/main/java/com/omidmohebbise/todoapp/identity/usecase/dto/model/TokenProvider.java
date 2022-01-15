package com.omidmohebbise.todoapp.identity.usecase.dto.model;


import com.omidmohebbise.todoapp.identity.model.User;
import com.omidmohebbise.todoapp.identity.model.repository.UserRepository;
import io.jsonwebtoken.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service(value = "ClientTokenProvider")
public class TokenProvider {


    private final UserRepository userRepository;

    @Value(value = "${security.timeout}")
    private Integer sessionTimeOut;

    @Value(value = "${security.secretkey}")
    private String secretKey;

    public TokenProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createToken(Authentication authentication, Boolean rememberMe) {
        User userPrincipal = (User) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + sessionTimeOut);
        String token = Jwts.builder()
                .setSubject(Long.toString(userPrincipal.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();

        userPrincipal.setToken(token);
        userPrincipal.setExpireDate(now);
        userPrincipal.setRememberMe(rememberMe != null && rememberMe);
        userRepository.update(userPrincipal);

        return token;
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {

            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            throw new SecurityException("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            throw new SecurityException("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            throw new SecurityException("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            throw new SecurityException("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            throw new SecurityException("JWT claims string is empty.");
        } catch (Exception exception) {
            return false;
        }
    }

}
