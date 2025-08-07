package com.ceneged.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceneged.backend.models.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>{
  
}
