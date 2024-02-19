package com.mycompany.wstowers.gui;

import com.mycompany.wstowers.util.LoginDAO;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.wstowers.gui.TelaPrincipal;
import java.awt.Cursor;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author muril
 */
public class LoginGui extends javax.swing.JFrame {

    Color bgColor = Color.decode("#60ff60");
    private LoginDAO loginDao = new LoginDAO();

    public LoginGui() {
        initComponents();
        bgPanel.setBackground(bgColor);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        loginPane = new javax.swing.JPanel();
        lbUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        lblRepetirSenha = new javax.swing.JLabel();
        txtRepetirSenha = new javax.swing.JPasswordField();
        btPane = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        btLogin = new javax.swing.JButton();
        btSair = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ws Towers");
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 600));
        setResizable(false);

        bgPanel.setForeground(new java.awt.Color(30, 30, 30));
        bgPanel.setMaximumSize(new java.awt.Dimension(600, 600));

        loginPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbUser.setText("Nome:");

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        lblSenha.setText("Senha:");

        lblRepetirSenha.setText("Repetir senha:");

        btPane.setBackground(bgColor);

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btPaneLayout = new javax.swing.GroupLayout(btPane);
        btPane.setLayout(btPaneLayout);
        btPaneLayout.setHorizontalGroup(
            btPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(btLogin)
                .addContainerGap())
        );
        btPaneLayout.setVerticalGroup(
            btPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btPaneLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(btPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btLogin))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        loginPane.setBackground(bgColor);

        javax.swing.GroupLayout loginPaneLayout = new javax.swing.GroupLayout(loginPane);
        loginPane.setLayout(loginPaneLayout);
        loginPaneLayout.setHorizontalGroup(
            loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPaneLayout.createSequentialGroup()
                .addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPaneLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRepetirSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRepetirSenha)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbUser)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSenha)))
                    .addGroup(loginPaneLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        loginPaneLayout.setVerticalGroup(
            loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPaneLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lbUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblRepetirSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRepetirSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        btSair.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btSair.setText("X");
        btSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSairEvent(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSairMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout bgPanelLayout = new javax.swing.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(loginPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSair)
                .addContainerGap())
        );
        bgPanelLayout.setVerticalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        try {
            doLogin(evt);
        } catch (SQLException ex) {
            Logger.getLogger(LoginGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btLoginActionPerformed

    private void doLogin(java.awt.event.ActionEvent evt) throws SQLException {
        String user = txtUser.getText();
        String senha = txtSenha.getText();

        int a = 1;
        int b = 1;

        if (a++ == b++) {
            if (loginDao.validateLogin(user, senha) == true) {
                new TelaPrincipal();
            } else {
                System.out.println("Login errado ");
            }
        }

    }

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        String nome = txtUser.getText();
        String senha = txtSenha.getText();
        String repetirSenha = txtRepetirSenha.getText();
        if (senha.equals(repetirSenha)) {
            try {
                loginDao.cadastrar(nome, senha);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            showMessageDialog(null, "As senhas não conferem");
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btSairEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSairEvent
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btSairEvent

    private void btSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSairMouseEntered
        // TODO add your handling code here:
        setCursor(HAND_CURSOR);
    }//GEN-LAST:event_btSairMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btLogin;
    private javax.swing.JPanel btPane;
    private javax.swing.JLabel btSair;
    private javax.swing.JLabel lbUser;
    private javax.swing.JLabel lblRepetirSenha;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPanel loginPane;
    private javax.swing.JPasswordField txtRepetirSenha;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
