package com.ceneged.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceneged.backend.models.Drop;

public interface DropRepository extends JpaRepository<Drop, Long> {
  
}
