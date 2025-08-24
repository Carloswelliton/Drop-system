package com.ceneged.backend.DTO;

import com.ceneged.backend.models.Roles;

import jakarta.validation.constraints.Size;

public record UserUpdateDTO( 
  @Size(min=6)String username, 
  @Size(min=6,max=254)String password,
  String email, 
  Roles role
) {}
