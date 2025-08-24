package com.ceneged.backend.DTO;

import jakarta.validation.constraints.NotNull;

public record UserUpdateDTO(
  @NotNull Long id, 
  String username, 
  String email, 
  String role
) {}
