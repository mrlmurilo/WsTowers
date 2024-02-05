package com.mycompany.wstowers.gui;

import com.mycompany.wstowers.util.LoginDAO;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author muril
 */
public class LoginGui1 extends javax.swing.JFrame {

    // Variables declaration - do not modify                     
    private javax.swing.JPanel bgPanel;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JPanel cadastroPane;
    private javax.swing.JPanel loginPane;
    private javax.swing.JTextField txtUser;
    private LoginDAO loginDao = new LoginDAO();

    Color bgColor = Color.decode("#60ff60");

    public LoginGui1() {
        initComponents();
        bgPanel.setBackground(bgColor);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        loginPane = new javax.swing.JPanel();
        cadastroPane = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btCadastrar = new javax.swing.JButton();
        btLogin = new javax.swing.JButton();

        setUndecorated(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setPreferredSize(new java.awt.Dimension(600, 600));
        setResizable(false);

        bgPanel.setForeground(new java.awt.Color(30, 30, 30));
        bgPanel.setMaximumSize(new java.awt.Dimension(600, 600));

        loginPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblUser.setText("Usuario:");

        lblSenha.setText("Senha:");

        btCadastrar.setText("Cadastrar");

        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    doLogin(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginGui1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doCadastrar(evt);
            }
        });

        loginPane.setBackground(bgColor);

        javax.swing.GroupLayout loginPaneLayout = new javax.swing.GroupLayout(loginPane);
        loginPane.setLayout(loginPaneLayout);
        loginPaneLayout.setHorizontalGroup(
                loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPaneLayout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(loginPaneLayout.createSequentialGroup()
                                                .addComponent(btCadastrar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btLogin))
                                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblUser)
                                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblSenha))
                                .addContainerGap(145, Short.MAX_VALUE))
        );
        loginPaneLayout.setVerticalGroup(
                loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPaneLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(lblUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(lblSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(134, 134, 134)
                                .addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btCadastrar)
                                        .addComponent(btLogin))
                                .addContainerGap(142, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bgPanelLayout = new javax.swing.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
                bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bgPanelLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(loginPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(51, Short.MAX_VALUE))
        );
        bgPanelLayout.setVerticalGroup(
                bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bgPanelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(loginPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(bgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
    }

    private void doCadastrar(java.awt.event.ActionEvent evt) {

    }

    private void doLogin(java.awt.event.ActionEvent evt) throws SQLException {
        // TODO add your handling code here:
        String user = txtUser.getText();
        String senha = txtSenha.getText();

        if (loginDao.validateLogin(user, senha) == true) {
            System.out.println("Foi");
        } else {
            System.out.println("Login errado ");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGui().setVisible(true);
            }
        });
    }

}
