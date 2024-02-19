package com.mycompany.wstowers.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Administrador
 */
public class CriacaoMapasPanel extends JPanel implements ActionListener {

    JFrame frame;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int width = (int) screenSize.getWidth();
    public int height = (int) screenSize.getHeight();

    CriacaoMapasPanel(JFrame frame) {
        this.frame = frame;
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new CriacaoMapasPanel.MyKeyAdapter());
        startCriacao();
    }

    private void startCriacao() {
        this.setLayout(new GridBagLayout()); // Definindo o layout como GridBagLayout
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE:

                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
