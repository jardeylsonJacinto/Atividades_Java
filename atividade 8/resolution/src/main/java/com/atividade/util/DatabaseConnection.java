package com.atividade.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Configurações da conexão
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Método para obter a conexão
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            throw e; // Repassa a exceção
        }
    }
}
