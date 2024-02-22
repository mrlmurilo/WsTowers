package com.mycompany.wstowers.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {

    JFrame frame;
    boolean running = false;
    int unitSize = 23;
    int matrixWidth = 64; // Largura da matriz em células
    int matrixHeight = 32; // Altura da matriz em células

    GamePanel(JFrame frame) {
        this.frame = frame;
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    private void startGame() {
        running = true;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawn(g);
    }

    public void drawn(Graphics g) {
        if (running) {
            // Calcula as coordenadas do canto superior esquerdo da matriz para centralizá-la
            int startX = (getWidth() - matrixWidth * unitSize) / 2;
            int startY = (getHeight() - matrixHeight * unitSize) / 2;

            // Itera sobre as células da matriz
            for (int x = 0; x < matrixWidth; x++) {
                for (int y = 0; y < matrixHeight; y++) {
                    // Calcula as coordenadas da célula na tela
                    int xPos = startX + x * unitSize;
                    int yPos = startY + y * unitSize;
                    // Desenha o quadrado vazio na posição calculada
                    g.setColor(Color.WHITE);
                    g.drawRect(xPos, yPos, unitSize, unitSize);
                }
            }
            g.setColor(Color.GRAY);
            desenharQuadrados(0, 0, g, Color.red);

        }
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void pausar() {
        frame.getContentPane().remove(this);
        frame.add(new GamePanel(frame));
        frame.revalidate();
        frame.repaint();
    }

    public void desenharQuadrados(int posX, int posY, Graphics g, Color c) {
        int startX = (getWidth() - matrixWidth * unitSize) / 2;
        int startY = (getHeight() - matrixHeight * unitSize) / 2;

        int x = startX + posX * unitSize;
        int y = startY + posY * unitSize;

        g.setColor(c);
        g.fillRect(x, y, unitSize, unitSize);
    }
}
