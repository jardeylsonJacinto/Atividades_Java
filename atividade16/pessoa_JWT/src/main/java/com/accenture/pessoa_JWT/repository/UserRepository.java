package com.accenture.pessoa_JWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.accenture.pessoa_JWT.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  // consulta usuario pelo login
  UserDetails findByLogin(String login);

}
