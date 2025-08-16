package com.ceneged.backend.config.security;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ceneged.backend.repository.UserRepository;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{

  @Autowired
  private TokenService tokenService;

  @Autowired
  private UserRepository repository;

  /*Filtro chamado logo após a requisição e antes do Spring MVC solicitar ao controller
  * ótimo para bloquear as requisições passando um filtro/condição especifica
  * como a necessidade da requisição recuperar um token e enviar sempre que houver uma chamanda na API
  */
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
  throws ServletException, IOException {

    var tokenjWT = recuperarToken(request);

    if(tokenjWT != null){
      //recuperando o token no cabeçalho
      var subject = tokenService.getSubject(tokenjWT);
      //recuperando o usuario
      var usuario = repository.findByUsername(subject);
      //carrega o usuario do bando de dados e força uma autenticação
      var authentication = new UsernamePasswordAuthenticationToken(usuario, usuario.getAuthorities(), null);
      //Aqui o Spring te considera logado
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    
    filterChain.doFilter(request, response);
    
  }

  // Bloqueando as requisições para que seeja necessário passar o Token
  private String recuperarToken(HttpServletRequest request) {
    var authorizationHeader = request.getHeader("Authorization");
    if (authorizationHeader != null) {
      return authorizationHeader.replace("Bearer ","");
    }
    return null;
    
  }
}
