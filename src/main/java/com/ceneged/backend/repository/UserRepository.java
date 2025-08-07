package com.ceneged.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.ceneged.backend.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

  UserDetails findByUsername(String username);
  
}
