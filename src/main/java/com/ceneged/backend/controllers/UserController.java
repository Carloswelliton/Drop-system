package com.ceneged.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceneged.backend.DTO.UserDTO;
import com.ceneged.backend.DTO.UserUpdateDTO;
import com.ceneged.backend.models.User;
import com.ceneged.backend.repository.UserRepository;
import com.ceneged.backend.service.UserService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("users")
public class UserController {

  @Autowired
  private final UserService userService;

  @Autowired
  private final UserRepository userRepository;

  
  
  public UserController(UserService userService, UserRepository userRepository){
    this.userService = userService;
    this.userRepository = userRepository;
  }

  @PostMapping
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

  @GetMapping("/{userId}")
  public ResponseEntity<User> getuserById(@PathVariable("userId") String userId){

    var user = userService.getUserById(userId);
    if(user.isPresent()){
      return ResponseEntity.ok(user.get());
    }else{
      return ResponseEntity.notFound().build();
    }
  }


  @DeleteMapping("/{userId}")
  public ResponseEntity<Void> deletebyId(@PathVariable("userId") String userId){
    userService.deleteById(userId);
    return ResponseEntity.noContent().build();
  }
}
