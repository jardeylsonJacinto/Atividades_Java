package com.entities;

public class Cliente {
  private String nome;
  private String sobrenome;
  private String cpf;

  // Construtor com todos os argumentos
  public Cliente(String nome, String sobrenome, String cpf) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.cpf = cpf;
  }

  // Construtor sem argumentos (valores padrão)
  public Cliente() {
  }

  // Métodos getters e setters
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobrenome() {
    return sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  @Override
  public String toString() {
    return nome + " " +
        sobrenome + " " +
        "cpf:" + cpf;
  }

}
