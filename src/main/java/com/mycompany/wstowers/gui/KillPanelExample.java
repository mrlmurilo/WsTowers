/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wstowers.gui;

/**
 *
 * @author Administrador
 */
import java.awt.BorderLayout;
import javax.swing.*;

public class KillPanelExample extends JFrame {

    JPanel panel;

    public KillPanelExample() {
        setTitle("Exemplo de Matar JPanel");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.add(new JLabel("Este é um JPanel"));

        JButton killButton = new JButton("Matar JPanel");
        killButton.addActionListener(e -> killPanel());

        getContentPane().add(panel);
        getContentPane().add(killButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void killPanel() {
        getContentPane().remove(panel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KillPanelExample::new);
    }
}
