package com.ceneged.backend.DTO;

import com.ceneged.backend.models.Roles;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDTO(@NotBlank @Size(min=6,max=30) String username,
                      @NotBlank @Email String email,
                      @NotBlank @Size(min=6,max=254) String password,
                      Roles role) {
}