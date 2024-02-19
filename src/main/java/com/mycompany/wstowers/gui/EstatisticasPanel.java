package com.mycompany.wstowers.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Murilo Margonar
 */
public class EstatisticasPanel extends JPanel implements ActionListener {

    JFrame frame;

    Character tecla = 'p';
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int width = (int) screenSize.getWidth();
    public int height = (int) screenSize.getHeight();

    EstatisticasPanel(JFrame frame) {
        this.frame = frame;
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new EstatisticasPanel.MyKeyAdapter());
        startEstatisticas();
    }

    private void startEstatisticas() {
        this.setLayout(new GridBagLayout()); // Definindo o layout como GridBagLayout
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_ESCAPE:
                    tecla = 's';
                    System.out.println(tecla);
                    break; // Adicione o break para sair do switch
                default:
                    throw new AssertionError();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tecla == 's') { // Comparando diretamente com o caractere 's'
            System.out.println(tecla);
            frame.getContentPane().remove(this);
            frame.add(new MenuPanel(frame));
            frame.revalidate();
            frame.repaint();
        }
    }
}
