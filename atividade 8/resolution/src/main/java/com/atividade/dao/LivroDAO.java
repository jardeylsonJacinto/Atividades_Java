package com.atividade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.atividade.model.Livro;
import com.atividade.util.DatabaseConnection;

public class LivroDAO {
  public void adicionarLivro(Livro livro) throws SQLException {
    String sql = "INSERT INTO livros (titulo, autor, ano_publicacao) VALUES (?, ?, ?)";
    try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, livro.getTitulo());
      stmt.setString(2, livro.getAutor());
      stmt.setInt(3, livro.getAnoPublicacao());
      stmt.executeUpdate();
    }
  }

  public List<Livro> listarLivros() throws SQLException {
    List<Livro> livros = new ArrayList<>();
    String sql = "SELECT * FROM livros";
    try (Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
        Livro livro = new Livro();
        livro.setId(rs.getInt("id"));
        livro.setTitulo(rs.getString("titulo"));
        livro.setAutor(rs.getString("autor"));
        livro.setAnoPublicacao(rs.getInt("ano_publicacao"));
        livros.add(livro);
      }
    }
    return livros;
  }

  public void atualizarLivro(Livro livro) throws SQLException {
    String sql = "UPDATE livros SET titulo = ?, autor = ?, ano_publicacao = ? WHERE id = ?";
    try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, livro.getTitulo());
      stmt.setString(2, livro.getAutor());
      stmt.setInt(3, livro.getAnoPublicacao());
      stmt.setInt(4, livro.getId());
      stmt.executeUpdate();
    }
  }

  public void deletarLivro(int id) throws SQLException {
    String sql = "DELETE FROM livros WHERE id = ?";
    try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, id);
      stmt.executeUpdate();
    }
  }
}
