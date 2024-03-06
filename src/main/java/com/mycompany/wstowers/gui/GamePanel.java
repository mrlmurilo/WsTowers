package com.mycompany.wstowers.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class GamePanel extends JPanel {

    JFrame frame;

    GamePanel(JFrame frame) {
        this.frame = frame;
        this.setBackground(Color.BLACK);
        
        
        JPanel centerPanel = new JPanel();
        centerPanel.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        centerPanel.setBounds(50, 50, 200, 100);
        centerPanel.setBackground(Color.red);
        this.add(centerPanel);
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    // Main method for testing
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new GamePanel(frame));
        frame.setVisible(true);
    }
}
