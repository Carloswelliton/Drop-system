package com.ceneged.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.ceneged.backend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

  UserDetails findByUsername(String username);
  
}
