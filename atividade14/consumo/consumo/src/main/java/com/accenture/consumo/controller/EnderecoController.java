package com.accenture.consumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.consumo.model.Endereco;
import com.accenture.consumo.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

  @Autowired
  private EnderecoService enderecoService;

  @PostMapping
  public Endereco addEndereco(@RequestBody Endereco endereco) {
    return enderecoService.salvarEndereco(endereco);
  }
}
