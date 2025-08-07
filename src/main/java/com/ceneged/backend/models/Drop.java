package com.ceneged.backend.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "drops")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Drop {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name="ordem_id", nullable = false)
  private OrdemServico ordemServico;

  @Column(nullable = false)
  private String ucChamado;

  @Column(nullable = false)
  private String ucAtendimento;

  @Column(nullable = false)
  private String fazenda;

  @Column(nullable = false)
  private LocalDateTime horaDeslocamento;

  @Column(nullable = false)
  private LocalDateTime horaChegada;

  @Column(nullable = false)
  private LocalDateTime horaConclusao;

  @Column(nullable = false)
  private String statusControlador;

  @Column(nullable = false)
  private String statusBaterias;

  @Column(nullable = false)
  private String statusInversor;

  @Column(nullable = false)
  private String statusDisjuntor;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String relatoCliente;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String causa;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String efeito;

  @Column(nullable = false)
  private String amperagemDisjuntor;

  @Column(nullable = false)
  private int potenciaUtilizada;

  @Column(nullable = false)
  private String lacreCaixaDisjuntor;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String tratativa;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String observacao;

  @Column(nullable = true)
  private String materialRetirado;

  @Column(nullable = true)
  private String materialAplicado;
  
}
