package com.atividade;

public class App {
    public static void main(String[] args) {
        // Corrigir este algoritmo.
        int vetor[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int numero = 8;
        boolean achou = false;

        for (int i = 0; i < 10; i++) {
            if (vetor[i] == numero) {
                achou = true;
                if (achou) {
                    System.out.println("Achei");
                    System.out.printf("Na Posição %d está localizado do numero %d.", i, vetor[i]);
                }
            }
        }
    }
}
