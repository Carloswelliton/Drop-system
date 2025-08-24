package com.ceneged.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ceneged.backend.DTO.UserDTO;
import com.ceneged.backend.models.User;
import com.ceneged.backend.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

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

  public Optional<User> getUserById(String userId){
    return userRepository.findById(Long.parseLong(userId));
  }

  public void deleteById(String userId){
    var id = Long.parseLong(userId);
    var userExist = userRepository.existsById(id);
    if(userExist){
      userRepository.deleteById(id);
    }
  }
}
