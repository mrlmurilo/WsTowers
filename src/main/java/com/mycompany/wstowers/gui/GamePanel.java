package com.mycompany.wstowers.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {

    JFrame frame;
    boolean running = false;
    int unitSize = 23;
    int matrixWidth = 64; // Largura da matriz em células
    int matrixHeight = 32; // Altura da matriz em células
    int playerPositionX;
    int playerPositionY;
    List<Integer> xTrail = new ArrayList<>();
    List<Integer> yTrail = new ArrayList<>();

    char direction;
    static final int DELAY = 75;
    Timer timer;
    List<Integer> xHasQuadradoBranco = new ArrayList<>();
    List<Integer> yHasQuadradoBranco = new ArrayList<>();

    GamePanel(JFrame frame) {
        this.frame = frame;
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    private void startGame() {
        running = true;
        this.requestFocus();
        timer = new Timer(DELAY, this);
        timer.start();
        playerPositionX = 0; // Posição inicial X do jogador no centro da matriz
        playerPositionY = 0; // Posição inicial Y do jogador no centro da matriz
        xHasQuadradoBranco.add(10);
        yHasQuadradoBranco.add(10);
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

            //deixa rastro azul
            g.setColor(Color.BLUE);
            for (int i = 0; i < xTrail.size(); i++) {
                int xPos = startX + xTrail.get(i) * unitSize;
                int yPos = startY + yTrail.get(i) * unitSize;
                g.fillRect(xPos, yPos, unitSize, unitSize);
            }

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
            desenharQuadrados(playerPositionX, playerPositionY, g, Color.red);
            desenharQuadrados(xHasQuadradoBranco.get(0), yHasQuadradoBranco.get(0), g, Color.white);
        }
    }

    public void move() {
        if (direction == 'R') {
            // Verifica se o próximo movimento levaria o jogador para dentro do quadrado branco
            if (!isCollision(playerPositionX + 1, playerPositionY)) {
                playerPositionX++; // Move o jogador para a direita
            }
        }
        if (direction == 'L') {
            // Verifica se o próximo movimento levaria o jogador para dentro do quadrado branco
            if (!isCollision(playerPositionX - 1, playerPositionY)) {
                playerPositionX--; // Move o jogador para a esquerda
            }
        }
        if (direction == 'U') {
            // Verifica se o próximo movimento levaria o jogador para dentro do quadrado branco
            if (!isCollision(playerPositionX, playerPositionY - 1)) {
                playerPositionY--; // Move o jogador para cima
            }
        }
        if (direction == 'D') {
            // Verifica se o próximo movimento levaria o jogador para dentro do quadrado branco
            if (!isCollision(playerPositionX, playerPositionY + 1)) {
                playerPositionY++; // Move o jogador para baixo
            }
        }
        xTrail.add(playerPositionX);
        yTrail.add(playerPositionY);
    }

    private boolean isCollision(int x, int y) {
        // Verifica se a posição (x, y) coincide com a posição do quadrado branco
        return x == xHasQuadradoBranco.get(0) && y == yHasQuadradoBranco.get(0);
    }

    private void checkColissions() {
        if (playerPositionX < 0 || playerPositionX >= matrixWidth) {
            running = false;
        }

        if (playerPositionY < 0 || playerPositionY >= matrixHeight) {
            running = false;
        }

        if (playerPositionX == xHasQuadradoBranco.get(0) && playerPositionY == yHasQuadradoBranco.get(0)) {
            timer.stop();
        }
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    direction = 'L';
                    break;
                case KeyEvent.VK_RIGHT:
                    direction = 'R';
                    break;
                case KeyEvent.VK_UP:
                    direction = 'U';
                    break;
                case KeyEvent.VK_DOWN:
                    direction = 'D';
                    break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkColissions();
        }
        repaint();
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
