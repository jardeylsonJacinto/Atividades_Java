package com.atividade;

import javax.swing.JOptionPane;

public class App {
  public static void main(String[] args) {
    String[][] board = {
        { "R", "N", "B", "Q", "K", "B", "N", "R" },
        { "P", "P", "P", "P", "P", "P", "P", "P" },
        { " ", " ", " ", " ", " ", " ", " ", " " },
        { " ", " ", " ", " ", " ", " ", " ", " " },
        { " ", " ", " ", " ", " ", " ", " ", " " },
        { " ", " ", " ", " ", " ", " ", " ", " " },
        { "p", "p", "p", "p", "p", "p", "p", "p" },
        { "r", "n", "b", "q", "k", "b", "n", "r" }
    };

    imprimirBoard(board);

    // Movimento do Cavalo
    JOptionPane.showMessageDialog(null, "Vamos mover o Cavalo");
    moverPeca(board, "Cavalo");

    // Movimento do Peão
    JOptionPane.showMessageDialog(null, "Vamos mover o Peão");
    moverPeca(board, "Peão");
  }

  public static void moverPeca(String[][] board, String peca) {
    String origem = JOptionPane.showInputDialog("Informe a posição de origem da " + peca + " (ex. 7,6):");
    String[] origemPos = origem.split(",");
    int origemLinha = Integer.parseInt(origemPos[0]);
    int origemColuna = Integer.parseInt(origemPos[1]);

    String destino = JOptionPane.showInputDialog("Informe a posição de destino da " + peca + " (ex. 5,5):");
    String[] destinoPos = destino.split(",");
    int destinoLinha = Integer.parseInt(destinoPos[0]);
    int destinoColuna = Integer.parseInt(destinoPos[1]);

    if (peca.equalsIgnoreCase("Cavalo")) {
      moverCavalo(board, origemLinha, origemColuna, destinoLinha, destinoColuna);
    } else if (peca.equalsIgnoreCase("Peão")) {
      moverPeao(board, origemLinha, origemColuna, destinoLinha, destinoColuna);
    }

    imprimirBoard(board);
  }

  public static void moverPeao(String[][] board, int origemLinha, int origemColuna, int destinoLinha,
      int destinoColuna) {
    if (validaMovimentoPeao(board, origemLinha, origemColuna, destinoLinha, destinoColuna)) {
      board[destinoLinha][destinoColuna] = board[origemLinha][origemColuna];
      board[origemLinha][origemColuna] = " ";
    } else {
      JOptionPane.showMessageDialog(null, "Movimento inválido para o Peão.");
    }
  }

  public static boolean validaMovimentoPeao(String[][] board, int origemLinha, int origemColuna, int destinoLinha,
      int destinoColuna) {
    String peca = board[origemLinha][origemColuna];
    int deltaLinha = destinoLinha - origemLinha;
    int deltaColuna = destinoColuna - origemColuna;

    if (peca.equals("P")) {
      if (deltaLinha == -1 && deltaColuna == 0 && board[destinoLinha][destinoColuna].equals(" ")) {
        return true;
      }
      if (origemLinha == 6 && deltaLinha == -2 && deltaColuna == 0 &&
          board[origemLinha - 1][origemColuna].equals(" ") && board[destinoLinha][destinoColuna].equals(" ")) {
        return true;
      }
      if (deltaLinha == -1 && Math.abs(deltaColuna) == 1 &&
          !board[destinoLinha][destinoColuna].equals(" ") && board[destinoLinha][destinoColuna].matches("[a-z]")) {
        return true;
      }
    }

    if (peca.equals("p")) {
      if (deltaLinha == 1 && deltaColuna == 0 && board[destinoLinha][destinoColuna].equals(" ")) {
        return true;
      }
      if (origemLinha == 1 && deltaLinha == 2 && deltaColuna == 0 &&
          board[origemLinha + 1][origemColuna].equals(" ") && board[destinoLinha][destinoColuna].equals(" ")) {
        return true;
      }
      if (deltaLinha == 1 && Math.abs(deltaColuna) == 1 &&
          !board[destinoLinha][destinoColuna].equals(" ") && board[destinoLinha][destinoColuna].matches("[A-Z]")) {
        return true;
      }
    }

    return false;
  }

  public static void moverCavalo(String[][] board, int origemLinha, int origemColuna, int destinoLinha,
      int destinoColuna) {
    if (validaMovimentoCavalo(origemLinha, origemColuna, destinoLinha, destinoColuna)) {
      board[destinoLinha][destinoColuna] = board[origemLinha][origemColuna];
      board[origemLinha][origemColuna] = " ";
    } else {
      JOptionPane.showMessageDialog(null, "Movimento inválido para o Cavalo.");
    }
  }

  public static boolean validaMovimentoCavalo(int origemLinha, int origemColuna, int destinoLinha, int destinoColuna) {
    int deltaLinha = Math.abs(destinoLinha - origemLinha);
    int deltaColuna = Math.abs(destinoColuna - origemColuna);
    return (deltaLinha == 2 && deltaColuna == 1) || (deltaLinha == 1 && deltaColuna == 2);
  }

  public static void imprimirBoard(String[][] board) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        sb.append(board[i][j]).append(" ");
      }
      sb.append("\n");
    }
    JOptionPane.showMessageDialog(null, sb.toString());
  }
}
