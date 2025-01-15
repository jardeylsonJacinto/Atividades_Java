package com.atividade;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String play1 = "X";
    String play2 = "O";
    String[][] tabuleiro = {
        { " ", " ", " " },
        { " ", " ", " " },
        { " ", " ", " " }
    };
    boolean jogoAtivo = true;
    String jogadorAtual = play1;

    while (jogoAtivo) {
      // Impressão do tabuleiro
      System.out.print("\n\n 0   1    2\n\n");
      for (int posicao1 = 0; posicao1 < 3; posicao1++) {
        for (int posicao2 = 0; posicao2 < 3; posicao2++) {
          System.out.print(" " + tabuleiro[posicao1][posicao2]);
          if (posicao2 < 2) {
            System.out.print(" | ");
          }
          if (posicao2 == 2) {
            System.out.print("  " + posicao1);
          }
        }
        if (posicao1 < 2) {
          System.out.print("\n------------");
        }
        System.out.println("\n");
      }

      // Jogada do jogador atual
      System.out.println("Jogada do jogador " + (jogadorAtual.equals(play1) ? "1" : "2") + ":");
      int linha = solicitarValorValido(sc, "Informe a linha (0, 1, ou 2): ");
      int coluna = solicitarValorValido(sc, "Informe a coluna (0, 1, ou 2): ");

      // Verifica se a posição está livre
      if (tabuleiro[linha][coluna].equals(" ")) {
        tabuleiro[linha][coluna] = jogadorAtual;

        // Verifica se há um vencedor
        if (verificarVencedor(tabuleiro, jogadorAtual)) {
          System.out.println("Jogador " + (jogadorAtual.equals(play1) ? "1" : "2") + " venceu!");
          jogoAtivo = false;
        } else if (tabuleiroCheio(tabuleiro)) {
          System.out.println("O jogo empatou!");
          jogoAtivo = false;
        } else {
          jogadorAtual = jogadorAtual.equals(play1) ? play2 : play1; // Alterna jogadores
        }
      } else {
        System.out.println("Posição ocupada! Tente novamente.");
      }
    }

    sc.close();
  }

  public static int solicitarValorValido(Scanner scanner, String mensagem) {
    int valor;
    while (true) {
      System.out.print(mensagem);
      if (scanner.hasNextInt()) {
        valor = scanner.nextInt();
        if (valor >= 0 && valor <= 2) {
          break;
        } else {
          System.out.println("Erro: Digite um valor entre 0 e 2.");
        }
      } else {
        System.out.println("Erro: Digite um número válido.");
        scanner.next(); // Limpa a entrada inválida
      }
    }
    return valor;
  }

  public static boolean verificarVencedor(String[][] tabuleiro, String play) {
    // Verifica linhas e colunas
    for (int i = 0; i < 3; i++) {
      if ((tabuleiro[i][0].equals(play) && tabuleiro[i][1].equals(play) && tabuleiro[i][2].equals(play)) ||
          (tabuleiro[0][i].equals(play) && tabuleiro[1][i].equals(play) && tabuleiro[2][i].equals(play))) {
        return true;
      }
    }
    // Verifica diagonais
    if ((tabuleiro[0][0].equals(play) && tabuleiro[1][1].equals(play) && tabuleiro[2][2].equals(play)) ||
        (tabuleiro[0][2].equals(play) && tabuleiro[1][1].equals(play) && tabuleiro[2][0].equals(play))) {
      return true;
    }
    return false;
  }

  public static boolean tabuleiroCheio(String[][] tabuleiro) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (tabuleiro[i][j].equals(" ")) {
          return false;
        }
      }
    }
    return true;
  }
}
