package com.atividade;

import javax.swing.JOptionPane;

public class App {
  public static void main(String[] args) {
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
      imprimirTabuleiro(tabuleiro);

      // Jogada do jogador atual
      JOptionPane.showMessageDialog(null, "Jogada do jogador " + (jogadorAtual.equals(play1) ? "1" : "2") + ":");
      int linha = solicitarValorValido("Informe a linha (0, 1, ou 2): ");
      int coluna = solicitarValorValido("Informe a coluna (0, 1, ou 2): ");

      // Verifica se a posição está livre
      if (tabuleiro[linha][coluna].equals(" ")) {
        tabuleiro[linha][coluna] = jogadorAtual;

        // Verifica se há um vencedor
        if (verificarVencedor(tabuleiro, jogadorAtual)) {
          JOptionPane.showMessageDialog(null, "Jogador " + (jogadorAtual.equals(play1) ? "1" : "2") + " venceu!");
          jogoAtivo = false;
        } else if (tabuleiroCheio(tabuleiro)) {
          JOptionPane.showMessageDialog(null, "O jogo empatou!");
          jogoAtivo = false;
        } else {
          jogadorAtual = jogadorAtual.equals(play1) ? play2 : play1; // Alterna jogadores
        }
      } else {
        JOptionPane.showMessageDialog(null, "Posição ocupada! Tente novamente.");
      }
    }
  }

  public static int solicitarValorValido(String mensagem) {
    int valor;
    while (true) {
      String entrada = JOptionPane.showInputDialog(mensagem);
      try {
        valor = Integer.parseInt(entrada);
        if (valor >= 0 && valor <= 2) {
          break;
        } else {
          JOptionPane.showMessageDialog(null, "Erro: Digite um valor entre 0 e 2.");
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Erro: Digite um número válido.");
      }
    }
    return valor;
  }

  public static void imprimirTabuleiro(String[][] tabuleiro) {
    StringBuilder sb = new StringBuilder();
    sb.append("\n\n 0   1    2\n\n");
    for (int posicao1 = 0; posicao1 < 3; posicao1++) {
      for (int posicao2 = 0; posicao2 < 3; posicao2++) {
        sb.append(" ").append(tabuleiro[posicao1][posicao2]);
        if (posicao2 < 2) {
          sb.append(" | ");
        }
        if (posicao2 == 2) {
          sb.append("  ").append(posicao1);
        }
      }
      if (posicao1 < 2) {
        sb.append("\n------------\n");
      } else {
        sb.append("\n\n");
      }
    }
    JOptionPane.showMessageDialog(null, sb.toString());
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
