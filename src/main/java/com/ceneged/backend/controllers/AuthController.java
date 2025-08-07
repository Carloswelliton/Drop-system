package com.ceneged.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceneged.backend.DTO.DadosAuth;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/auth/login")
public class AuthController {

  @Autowired
  private AuthenticationManager manager;

  @PostMapping
  public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAuth dados){
    var token = new UsernamePasswordAuthenticationToken(dados.username(), dados.password());
    var authentication = manager.authenticate(token); 

    return ResponseEntity.ok().build();
  }
}
