package com.atividade;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.entities.Cliente;
import com.entities.ContaCorrente;

public class App {
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = now.format(fmt);
        LocalDateTime dt = LocalDateTime.parse(formattedDate, fmt);

        Cliente cliente1 = new Cliente("joão", "Leite", "123456789");
        Cliente cliente2 = new Cliente("Marta", "Batista", "987654321");

        System.out.println("Clientes cadastrados: " + "\n" + cliente1 + "\n" + cliente2);

        ContaCorrente conta1 = new ContaCorrente(1, cliente1.getNome(), cliente1, 1000.00, dt);
        ContaCorrente conta2 = new ContaCorrente(2, cliente2.getNome(), cliente2, 3000.00, dt);

        System.out.println("\nContas criadas com sucesso! " + "\n");
        conta1.exibirExtrato();
        System.out.println();
        conta2.exibirExtrato();

        System.out.printf("\n" + cliente1.getNome()
                + " Está fazendo movimentação na conta, deposito de 1500, saque de 500 e tranferencia de 1000");

        conta1.depositar(1500);
        conta1.sacar(500);
        System.out.println("Tranferencia: ");
        conta1.transferir(conta2, 1000);

        System.out.println("\n" + cliente1.getNome() + " Saldo Atual: " + conta1.getSaldo());
        System.out.println(cliente2.getNome() + " Saldo Atual: " + conta2.getSaldo());

    }
}
