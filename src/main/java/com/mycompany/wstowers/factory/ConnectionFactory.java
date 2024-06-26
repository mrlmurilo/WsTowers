package com.mycompany.wstowers.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author muril
 */
public class ConnectionFactory {

    String jdbcUrl = "jdbc:mysql://localhost:3306/";
    String dbName = "wstowers";
    String dbUser = "root";
    String dbPassword = "root";
    Connection connection = null;

    public Connection getConnection() throws SQLException {
        try {
            return DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/wstowers?user=root&password=root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void primeiroAcesso() {
        try {
            connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            System.out.println("Conexão estabelecida com sucesso!");
            if (!databaseExists(connection, dbName)) {
                createDatabase(connection, dbName);
                System.out.println("Banco de dados criado com sucesso!");
                connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

                createTables(connection);
                System.out.println("Tabela criada com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean databaseExists(Connection connection, String dbName) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            String sql = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + dbName + "'";
            return stmt.executeQuery(sql).next();
        }
    }

    private static void createDatabase(Connection connection, String dbName) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            String createDatabaseSQL = "CREATE DATABASE " + dbName;
            stmt.executeUpdate(createDatabaseSQL);
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            String sql = "USE wstowers";
            stmt.execute(sql);
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Usuario (ID INT PRIMARY KEY AUTO_INCREMENT, Nome VARCHAR(255), Senha VARCHAR(60))";
            stmt.executeUpdate(createTableSQL);
            stmt.execute(sql);
            createTableSQL = "CREATE TABLE IF NOT EXISTS Mapa (ID INT PRIMARY KEY AUTO_INCREMENT, Dados VARCHAR(255), SolucaMinima int)";
            stmt.executeUpdate(createTableSQL);
            stmt.execute(sql);
            createTableSQL = "CREATE TABLE IF NOT EXISTS Partida (ID INT PRIMARY KEY AUTO_INCREMENT, IDUsuario int, IDMapa int, Movimentos int, Falhas int,"
                    + "CONSTRAINT fk_IdUsuario FOREIGN KEY (IDUsuario) REFERENCES Usuario (ID), "
                    + "CONSTRAINT fk_IdMapa FOREIGN KEY (IDMapa) REFERENCES Mapa(ID));";
            stmt.executeUpdate(createTableSQL);
        }
    }
}
