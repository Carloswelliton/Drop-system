package com.ceneged.backend.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ordem_de_servico")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class OrdemServico {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Integer nr;

  @Column(nullable = false)
  private String fazenda;

  @Column(nullable = false)
  private String nomeProprietario;

  @Column(nullable = false)
  private String telefone;

  @Column(nullable = false)
  private String sog;

  @Column(nullable = false)
  private String uc;
  
  @Column(nullable = false)
  private LocalDateTime horaDoChamado;  
}