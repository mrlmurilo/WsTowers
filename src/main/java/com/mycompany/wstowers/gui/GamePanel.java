package com.mycompany.wstowers.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Administrador
 */
public class GamePanel extends JPanel implements ActionListener {

    JFrame frame;
    boolean running = false;
    Timer timer;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();
    int unitSize = 20;
    int GAME_UNITS = (width * height);
    int xPos;
    int yPos;

    GamePanel(JFrame frame) {
        this.frame = frame;
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new GamePanel.MyKeyAdapter());
        startGame();
    }

    private void startGame() {
        this.setLayout(new GridBagLayout());
        running = true;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawn(g);
    }

    public void drawn(Graphics g) {
        if (running) {
            int matrixWidth = 64; // Largura da matriz em células
            int matrixHeight = 32; // Altura da matriz em células

            // Calcula a largura e a altura total do desenho da matriz de quadrados
            int totalWidth = matrixWidth * unitSize;
            int totalHeight = matrixHeight * unitSize;

            // Calcula as coordenadas do canto superior esquerdo para centralizar o desenho
            int startX = (width - totalWidth) / 2;
            int startY = (height - totalHeight) / 2;

            // Itera sobre as células da matriz
            for (int x = 0; x < matrixWidth; x++) {
                for (int y = 0; y < matrixHeight; y++) {
                    // Calcula as coordenadas da célula na tela
                    int xPos = startX + x * unitSize;
                    int yPos = startY + y * unitSize;

                    // Desenha o quadrado na posição calculada
                    if (x == 20 && y == 1) {
                        desenharQuadrados(xPos, yPos, unitSize, g, Color.green);
                    } else {
                        g.setColor(Color.WHITE);
                        g.drawRect(xPos, yPos, unitSize, unitSize);
                    }

                    // Desenha as coordenadas no centro do quadrado
//                    String coord = "(" + x + ", " + y + ")";
//                    g.drawString(coord, xPos + unitSize / 2 - 10, yPos + unitSize / 2);
                }
            }

            desenharQuadrados(startX + 5, startY + 9, unitSize, g, Color.white);
            desenharQuadrados(startX + 6, startY + 0, unitSize, g, Color.white);
            desenharQuadrados(startX + 6, startY + 0, unitSize, g, Color.white);
            desenharQuadrados(startX + 16, startY + 1, unitSize, g, Color.white);
            desenharQuadrados(startX + 15, startY + 7, unitSize, g, Color.white);
            desenharQuadrados(startX + 12, startY + 6, unitSize, g, Color.white);
            desenharQuadrados(startX + 13, startY + 14, unitSize, g, Color.white);
            desenharQuadrados(startX + 3, startY + 14, unitSize, g, Color.white);
            desenharQuadrados(startX + 4, startY + 17, unitSize, g, Color.white);
            desenharQuadrados(startX + 26, startY + 16, unitSize, g, Color.white);
            desenharQuadrados(startX + 25, startY + 7, unitSize, g, Color.white);
            desenharQuadrados(startX + 19, startY + 8, unitSize, g, Color.white);
            desenharQuadrados(startX + 29, startY + 9, unitSize, g, Color.red);
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

    public void desenharQuadrados(int posX, int posY, int unitSize, Graphics g, Color c) {
        g.setColor(c);
        g.fillRect(posX * unitSize, posY * unitSize, unitSize, unitSize);
    }
}
