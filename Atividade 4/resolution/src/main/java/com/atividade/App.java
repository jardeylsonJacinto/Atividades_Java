package com.atividade;

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
    System.out.println("\nMover Cavalo");
    moverCavalo(board, 7, 6, 5, 5);
    imprimirBoard(board);

    // Movimento do Peão
    System.out.println("\nMover Peão");
    moverPeao(board, 6, 2, 4, 2);
    imprimirBoard(board);
  }

  // Movimento do Peão
  public static void moverPeao(String[][] board, int origemLinha, int origemColuna, int destinoLinha,
      int destinoColuna) {
    if (validaMovimentoPeao(board, origemLinha, origemColuna, destinoLinha, destinoColuna)) {
      board[destinoLinha][destinoColuna] = board[origemLinha][origemColuna];
      board[origemLinha][origemColuna] = " ";
    } else {
      System.out.println("Movimento inválido para o Peão.");
    }
  }

  // Validação do Movimento do Peão
  public static boolean validaMovimentoPeao(String[][] board, int origemLinha, int origemColuna, int destinoLinha,
      int destinoColuna) {
    String peca = board[origemLinha][origemColuna];
    int deltaLinha = destinoLinha - origemLinha;
    int deltaColuna = destinoColuna - origemColuna;

    // Movimento do Peão Branco
    if (peca.equals("P")) {
      // Avanço de uma casa
      if (deltaLinha == -1 && deltaColuna == 0 && board[destinoLinha][destinoColuna].equals(" "))
        return true;
      // Avanço inicial de duas casas
      if (origemLinha == 6 && deltaLinha == -2 && deltaColuna == 0 &&
          board[origemLinha - 1][origemColuna].equals(" ") && board[destinoLinha][destinoColuna].equals(" "))
        return true;
      // Captura diagonal
      if (deltaLinha == -1 && Math.abs(deltaColuna) == 1 &&
          !board[destinoLinha][destinoColuna].equals(" ") && board[destinoLinha][destinoColuna].matches("[a-z]"))
        return true;
    }

    // Movimento do Peão Preto
    if (peca.equals("p")) {
      // Avanço de uma casa
      if (deltaLinha == 1 && deltaColuna == 0 && board[destinoLinha][destinoColuna].equals(" "))
        return true;
      // Avanço inicial de duas casas
      if (origemLinha == 1 && deltaLinha == 2 && deltaColuna == 0 &&
          board[origemLinha + 1][origemColuna].equals(" ") && board[destinoLinha][destinoColuna].equals(" "))
        return true;
      // Captura diagonal
      if (deltaLinha == 1 && Math.abs(deltaColuna) == 1 &&
          !board[destinoLinha][destinoColuna].equals(" ") && board[destinoLinha][destinoColuna].matches("[A-Z]"))
        return true;
    }

    return false; // Movimento inválido
  }

  // Movimento do Cavalo
  public static void moverCavalo(String[][] board, int origemLinha, int origemColuna, int destinoLinha,
      int destinoColuna) {
    if (validaMovimentoCavalo(origemLinha, origemColuna, destinoLinha, destinoColuna)) {
      board[destinoLinha][destinoColuna] = board[origemLinha][origemColuna];
      board[origemLinha][origemColuna] = " ";
    } else {
      System.out.println("Movimento inválido para o Cavalo.");
    }
  }

  // Validação do Movimento do Cavalo
  public static boolean validaMovimentoCavalo(int origemLinha, int origemColuna, int destinoLinha, int destinoColuna) {
    int deltaLinha = Math.abs(destinoLinha - origemLinha);
    int deltaColuna = Math.abs(destinoColuna - origemColuna);
    return (deltaLinha == 2 && deltaColuna == 1) || (deltaLinha == 1 && deltaColuna == 2);
  }

  // Exibir o Tabuleiro
  public static void imprimirBoard(String[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
}
