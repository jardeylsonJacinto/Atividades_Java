package com.accenture.consumo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.consumo.interfaces.CepService;
import com.accenture.consumo.model.Endereco;
import com.accenture.consumo.service.EnderecoService;

@RestController
@RequestMapping("/cep")
public class CepRestController {

  private final CepService cepService;
  private final EnderecoService enderecoService;

  public CepRestController(CepService cepService, EnderecoService enderecoService) {
    this.cepService = cepService;
    this.enderecoService = enderecoService;
  }

  @GetMapping("/{cep}")
  public ResponseEntity<Endereco> getCep(@PathVariable String cep) {
    Endereco endereco = cepService.buscaEnderecoPorCep(cep);
    if (endereco != null) {
      enderecoService.salvarEndereco(endereco);
      return ResponseEntity.ok(endereco);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
