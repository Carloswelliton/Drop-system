package com.ceneged.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceneged.backend.DTO.UserDTO;
import com.ceneged.backend.models.User;
import com.ceneged.backend.repository.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("users")
public class UserController {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @PostMapping("/create")
  @Transactional
  public ResponseEntity<String> createUsers(@RequestBody @Valid UserDTO userDTO){
    try {
      if(userDTO.username().length()<6){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username must have at least 6 characters");
      }
      String encodedPassword = passwordEncoder.encode(userDTO.password());
      userRepository.save(new User(userDTO, encodedPassword));
      return ResponseEntity.status(HttpStatus.CREATED).body("User created");
    }catch(IllegalArgumentException e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid role: " + e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erro creating a new user: "+ e.getMessage());
    }
  }

  @GetMapping("listar")
  @Transactional
  public ResponseEntity<List<User>> listarUsuarios(){
    List<User> listar = userRepository.findAll();
    return ResponseEntity.ok().body(listar);
  }
}
