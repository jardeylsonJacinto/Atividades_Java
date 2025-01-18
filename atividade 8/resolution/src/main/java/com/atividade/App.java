package com.atividade;

import java.sql.SQLException;
import java.util.List;

import com.atividade.dao.LivroDAO;
import com.atividade.model.Livro;

public class App {
    public static void main(String[] args) {
        LivroDAO livroDAO = new LivroDAO();

        try {
            // Adicionar um livro
            Livro livro1 = new Livro();
            livro1.setTitulo("O Hobbit");
            livro1.setAutor("J.R.R. Tolkien");
            livro1.setAnoPublicacao(1987);
            livroDAO.adicionarLivro(livro1);
            Livro livro2 = new Livro();
            livro2.setTitulo("Quem pensa enriquece");
            livro2.setAutor("Napoleon Hill");
            livro2.setAnoPublicacao(1957);
            livroDAO.adicionarLivro(livro2);
            System.out.println("Livro adicionado com sucesso!");

            // Listar livros
            List<Livro> livros = livroDAO.listarLivros();
            for (Livro l : livros) {
                System.out.println(l.getId() + ": " + l.getTitulo() + " - " + l.getAutor());
            }

            // Atualizar um livro
            livro1.setId(1); // Atualizando o livro com ID 1
            livro1.setTitulo("Smart Money");
            livro1.setAutor("João Kepler");
            livroDAO.atualizarLivro(livro1);
            System.out.println("Livro atualizado com sucesso!");

            // Deletar um livro
            livroDAO.deletarLivro(1); // Deletando o livro com ID 1
            System.out.println("Livro deletado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
