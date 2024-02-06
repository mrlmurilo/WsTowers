package com.mycompany.wstowers.util;

import com.mycompany.wstowers.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class LoginDAO {

    private ConnectionFactory connection = new ConnectionFactory();

    public boolean validateLogin(String user, String senha) throws SQLException {

        boolean isLoginOk = false;

        // Verifica se os campos nome e senha estão vazios
        if (user.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Algum campo está vazio, por favor tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String sql = "SELECT * FROM usuario WHERE Nome = ? AND Senha = ?";

        Connection conn = connection.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, senha);
            ResultSet rs = preparedStatement.executeQuery();

            // Verifica se há correspondência no banco de dados
            if (rs.next()) {
                conn.close();
                isLoginOk = true;
            } else {
                conn.close();
                isLoginOk = false;
            }

        } catch (SQLException e) {
            System.out.println("Aqui o meu erro");
            e.printStackTrace();
        }
        return isLoginOk;
    }

    public void cadastrar(String nome, String senha) throws SQLException {
        String sql = "INSERT INTO Usuario (Nome, Senha) VALUES (?, ?)";

        Connection conn = connection.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, nome);
        preparedStatement.setInt(2, Integer.valueOf(senha));
        preparedStatement.executeUpdate();
        System.out.println("Cadastrado com sucesso");
        conn.close();
    }
}
