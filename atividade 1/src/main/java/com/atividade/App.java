package com.atividade;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int classeA = 50;
        int classeB = 30;
        int classeC = 20;

        System.out.printf("Tabela de preço: \nClasse A - %d \nClasse B - %d \nClasse C - %d \n", classeA, classeB,
                classeC);

        System.out.print("Informe quantos bilhetes da classe A foram vendidos:");
        int bilhetesClasseA = sc.nextInt();

        System.out.print("Informe quantos bilhetes da classe B foram vendidos:");
        int bilhetesClasseB = sc.nextInt();

        System.out.print("Informe quantos bilhetes da classe C foram vendidos:");
        int bilhetesClasseC = sc.nextInt();

        System.out.println();
        System.out.printf("Renda gerada dos Bilhetes da Classe - A = %d \n", bilhetesClasseA * classeA);
        System.out.printf("Renda gerada dos Bilhetes da Classe - B = %d \n", bilhetesClasseB * classeB);
        System.out.printf("Renda gerada dos Bilhetes da Classe - C = %d \n", bilhetesClasseC * classeC);

        sc.close();
    }
}
