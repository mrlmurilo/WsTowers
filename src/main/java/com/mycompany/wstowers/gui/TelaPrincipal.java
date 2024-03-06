package com.mycompany.wstowers.gui;

import javax.swing.JFrame;

/**
 *
 * @author Murilo Margona
 */
public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        this.setUndecorated(true);
        this.add(new MenuPanel(this));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
