package com.ceneged.backend.DTO;

import jakarta.validation.constraints.Pattern;

public record UserDTO(String username,
                      String email,
                      String password,
                      @Pattern(regexp = "TECNICO|GESTOR|CONTRATANTE", message = "ROLE must be TECNICO, GESTOR ou CONTRATANTE")
                      String role) {
}