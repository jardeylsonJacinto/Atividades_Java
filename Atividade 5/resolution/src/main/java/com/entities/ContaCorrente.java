package com.entities;

import java.time.LocalDateTime;

public class ContaCorrente {
    private int numero;
    private String nome;
    private Cliente cliente;
    private double saldo;
    private LocalDateTime dataAbertura;

    // Construtor com todos os argumentos
    public ContaCorrente(int numero, String nome, Cliente cliente, double saldo, LocalDateTime dt) {
        this.numero = numero;
        this.nome = nome;
        this.cliente = cliente;
        this.saldo = saldo;
        this.dataAbertura = dt;
    }

    // Métodos getters e setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("\nDepósito de " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("\nSaque de " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
        }
    }

    public void exibirExtrato() {
        System.out.println("Extrato da Conta Corrente");
        System.out.println("Número da Conta: " + numero);
        System.out.println("Nome do Titular: " + nome);
        System.out.println("Saldo Atual: R$" + saldo);
        System.out.println("Data de Abertura: " + dataAbertura);
    }

    public void transferir(ContaCorrente contaDestino, double valor) {
        if (valor > 0 && valor <= saldo) {
            sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("\nTransferência de " + valor + " realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência.");
        }
    }
}