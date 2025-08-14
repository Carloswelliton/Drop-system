package com.ceneged.backend.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceneged.backend.DTO.UserDTO;
import com.ceneged.backend.models.User;
import com.ceneged.backend.service.UserService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("users")
public class UserController {

  private final UserService userService;
  
  public UserController(UserService userService){
    this.userService = userService;
  }

  @PostMapping("/create")
  @Transactional
  public ResponseEntity<String> createUsers(@RequestBody @Valid UserDTO userDTO){
    try {
      userService.criarUsuario(userDTO);
      return ResponseEntity.status(HttpStatus.CREATED).body("User created");
    }catch(IllegalArgumentException e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid role: " + e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erro creating a new user: "+ e.getMessage());
    }
  }

  @GetMapping
  @Transactional
  public ResponseEntity<List<User>> listarUsuarios(){
    List<User> listar = userService.listarUsuarios();
    return ResponseEntity.ok().body(listar);
  }
}
