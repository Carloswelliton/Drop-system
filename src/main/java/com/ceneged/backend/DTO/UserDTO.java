package com.ceneged.backend.DTO;

import com.ceneged.backend.models.Roles;

public record UserDTO(String username,
                      String email,
                      String password,
                      Roles role) {
}