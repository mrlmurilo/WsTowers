/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.wstowers;

import com.mycompany.wstowers.factory.ConnectionFactory;
import com.mycompany.wstowers.gui.LoginGui;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author muril
 */
public class WsTowers {

    public static void main(String[] args) throws SQLException {
        LoginGui loginGui = new LoginGui();

        ConnectionFactory conn = new ConnectionFactory();
        Connection connection = null;
        connection = conn.getConnection();
        loginGui.setVisible(true);
    }

}
