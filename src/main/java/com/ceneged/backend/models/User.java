package com.ceneged.backend.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ceneged.backend.DTO.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="usuarios")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class User implements UserDetails{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  @Size(min = 6, max = 30)
  private String username;
  
  @Column(nullable = false, unique = true)
  @Email
  private String email;

  @Column(nullable = false)
  @JsonProperty(access = Access.WRITE_ONLY)
  @Size(min =6, max=254)
  private String password;

  @ElementCollection(fetch = FetchType.EAGER)
  @Enumerated(EnumType.STRING)
  private Set<Roles> roles = new HashSet<>();


  public User(UserDTO user, String passwordEncoder){
    this.username = user.username();
    this.email = user.email();
    this.password = passwordEncoder;
    this.roles.add(user.role());
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles.stream()
    .map(role -> new SimpleGrantedAuthority("ROLE_"+role.name()))
    .collect(Collectors.toList());
  }

  @Override
  public String getPassword(){
    return password;
  }

  @Override
  public String getUsername(){
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return true;
  }

  

  
}
