package com.ceneged.backend.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ceneged.backend.DTO.UserDTO;
import com.ceneged.backend.models.User;
import com.ceneged.backend.repository.UserRepository;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public List<User> listarUsuarios(){
    return userRepository.findAll();
  }

  public void criarUsuario(UserDTO userDTO){
    if(userDTO.username().length()<6){
      throw new IllegalArgumentException("Username must have at least 6 characters");
    }
    String encodedPassword =passwordEncoder.encode(userDTO.password());
    User user = new User(userDTO, encodedPassword);
    userRepository.save(user);
  }
  
}
