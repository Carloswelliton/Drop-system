package com.ceneged.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceneged.backend.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
  
}
