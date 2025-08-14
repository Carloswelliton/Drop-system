package com.ceneged.backend.config.security;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{

  @Autowired
  private TokenService tokenService;



  /*Filtro chamado logo após a requisição e antes do Spring MVC solicitar ao controller
  * ótimo para bloquear as requisições passando um filtro/condição especifica
  * como a necessidade da requisição recuperar um token e enviar sempre que houver uma chamanda na API
  */
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
  throws ServletException, IOException {

    var tokenjWT = recuperarToken(request);
    var subject = tokenService.getSubject(tokenjWT);


     

    filterChain.doFilter(request, response);

  }

  // Bloqueando as requisições para que seeja necessário passar o Token
  private String recuperarToken(HttpServletRequest request) {
    var authorizationHeader = request.getHeader("Authorization");
    if (authorizationHeader == null) {
      throw new RuntimeException("Token JWT não enviado no cabeçalho authorization");
    }
    return authorizationHeader.replace("Bearer ","");
  }
}
