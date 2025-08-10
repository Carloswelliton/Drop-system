package com.ceneged.backend.config.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.ceneged.backend.models.User;

@Service
public class TokenService {

  @Value("${api.security.token.secret}")
  private String secret;

  //configurando o Auth0 para retornar um token
  public String gerarToken(User user){
    System.out.println(secret);
    try {
    var algoritmo = Algorithm.HMAC256(secret);
    return JWT.create()
        .withIssuer("drop-system")
        .withSubject(user.getUsername())
        .withExpiresAt(dataExpiracao())
        .sign(algoritmo);
    } catch (JWTCreationException exception){
        throw new RuntimeException("erro ao gerar token jwt", exception);
    }
  }

  // data de expiração do token
  private Instant dataExpiracao() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-04:00"));
  }
  
}
