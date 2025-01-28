package com.accenture.pessoa_JWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.pessoa_JWT.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
