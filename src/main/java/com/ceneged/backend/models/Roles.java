package com.ceneged.backend.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Roles {
  TECNICO, 
  GESTOR, 
  CONTRATANTE;

  @JsonCreator
    public static Roles fromString(String key) {
        return key == null ? null : Roles.valueOf(key.toUpperCase());
    }
}
