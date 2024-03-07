package com.mycompany.wstowers.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {

    JFrame frame;
    int larguraQuadrado = Toolkit.getDefaultToolkit().getScreenSize().width / 64;
    int alturaQuadrado = Toolkit.getDefaultToolkit().getScreenSize().height / 32;
    boolean running = false;
    boolean moving = false;
    static final int DELAY = 75;
    int tipoBloco;
    int playerPositionx = 0;
    int playerPositiony = 0;

    List<Integer> xTrail = new ArrayList<>();
    List<Integer> yTrail = new ArrayList<>();

    Timer timer;

    GamePanel(JFrame frame) {

        this.frame = frame;
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);

        startGame();
    }

    public void drawn(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(playerPositionx * alturaQuadrado, playerPositiony * larguraQuadrado, alturaQuadrado, larguraQuadrado);

        tipoBloco = 1;
        switch (tipoBloco) {
            case 0:
                g.setColor(Color.black);
                break;
            case 1:
                g.setColor(Color.white);
                break;
            case 2:
                g.setColor(Color.red);
                break;
            case 3:
                g.setColor(Color.green);
                break;
            case 4:
                g.setColor(Color.blue);
        }
        g.fillRect(3 * alturaQuadrado, 0 * larguraQuadrado, alturaQuadrado, larguraQuadrado);
        g.fillRect(2 * alturaQuadrado, 3 * larguraQuadrado, alturaQuadrado, larguraQuadrado);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawn(g);
    }

    private void startGame() {
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("Tecla pressionada: " + e.getKeyCode());
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_RIGHT:
                    if (playerPositionx < 63) { // Verifica se o jogador não está no limite direito
                        playerPositionx++; // Move o jogador para a direita
                        break;
                    } else {
                        System.out.println("Game Over");
                        break;
                    }
                case KeyEvent.VK_LEFT:
                    if (playerPositionx != 0) { // Verifica se o jogador não está no limite esquerda
                        System.out.println("Andando para esquerda");
                        playerPositionx--; // Move o jogador para a esquerda
                        break;
                    } else {
                        System.out.println("Game over");

                    }
                    break;

                case KeyEvent.VK_UP:
                    if (playerPositiony != 0) {
                        System.err.println("Andou para cima");
                        playerPositiony--;
                    } else {
                        System.out.println("Game over");
                    }
                    break;

                case KeyEvent.VK_DOWN:
                    if (playerPositiony < 31) {
                        playerPositiony++;
                    } else {
                        System.out.println("Game Over");
                    }
                    break;

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
