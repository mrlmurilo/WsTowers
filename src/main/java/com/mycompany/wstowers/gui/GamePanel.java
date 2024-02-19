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
    int unitSize = 50;
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
            for (int x = 0; x < width / unitSize; x++) {
                for (int y = 0; y < height / unitSize; y++) {
                    
                    xPos = x * unitSize;
                    yPos = y * unitSize;

                    if (x == 20 && y == 1) {
                        desenharQuadrados(x, y, unitSize, g, Color.green);
                    } else {
                        g.setColor(Color.WHITE);
                        g.drawRect(xPos, yPos, unitSize, unitSize);
                    }

                    String coord = "(" + x + ", " + y + ")";
                    g.drawString(coord, xPos + unitSize / 2 - 10, yPos + unitSize / 2);
                }
            }
            desenharQuadrados(5, 9, unitSize, g, Color.white);
            desenharQuadrados(6, 0, unitSize, g, Color.white);
            desenharQuadrados(16, 1, unitSize, g, Color.white);
            desenharQuadrados(15, 7, unitSize, g, Color.white);
            desenharQuadrados(15, 7, unitSize, g, Color.white);
            desenharQuadrados(12, 6, unitSize, g, Color.white);
            desenharQuadrados(13, 14, unitSize, g, Color.white);
            desenharQuadrados(3, 14, unitSize, g, Color.white);
            desenharQuadrados(4, 17, unitSize, g, Color.white);
            desenharQuadrados(26, 16, unitSize, g, Color.white);
            desenharQuadrados(26, 16, unitSize, g, Color.white);
            desenharQuadrados(25, 7, unitSize, g, Color.white);
            desenharQuadrados(19, 8, unitSize, g, Color.white);
            desenharQuadrados(29, 9, unitSize, g, Color.red);
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
