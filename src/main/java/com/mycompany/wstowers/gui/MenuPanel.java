package com.mycompany.wstowers.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MenuPanel extends JPanel implements ActionListener {

    Color bgColor = Color.decode("#60ff60");

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int width = (int) screenSize.getWidth();
    public int height = (int) screenSize.getHeight();

    static final int UNIT_SIZE = 25;
    final int GAME_UNITS = (width * height);
    static final int DELAY = 75;

    JButton btJogar = new JButton("Jogar");
    JButton btSair = new JButton("Sair");
    JButton btCriar = new JButton("Criar");
    JButton btEstatisticas = new JButton("Estatisticas");
    JFrame frame;

    MenuPanel(JFrame frame) {
        this.frame = frame;
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(bgColor);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startMenu();
    }

    public void startMenu() {
        this.setLayout(new GridBagLayout()); // Definindo o layout como GridBagLayout

        // Configurando as propriedades do GridBagConstraints para centralizar os botões
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os botões
        gbc.fill = GridBagConstraints.BOTH; // Preenchimento horizontal e vertical

        // Adicionando os botões ao painel
        this.add(btJogar, gbc);
        this.add(btCriar, gbc);
        this.add(btEstatisticas, gbc);
        this.add(btSair, gbc);

        // Adicionando ActionListener aos botões
        btJogar.addActionListener(this);
        btCriar.addActionListener(this);
        btEstatisticas.addActionListener(this);
        btSair.addActionListener(this);

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

        if (e.getSource() == btJogar) {
            jogar();
        }
        if (e.getSource() == btCriar) {
            criarMapa();
        }
        if (e.getSource() == btEstatisticas) {
            estatisticas();
        }
        if (e.getSource() == btSair) {
            sair();
        }
        
    }

    public void jogar() {
        frame.getContentPane().remove(this);
        frame.add(new GamePanel(frame));
        frame.revalidate();
        frame.repaint();
    }

    public void criarMapa() {
        frame.getContentPane().remove(this);
        frame.add(new CriacaoMapasPanel(frame));
        frame.revalidate();
        frame.repaint();
    }

    public void estatisticas() {
        frame.getContentPane().remove(this);
        frame.add(new EstatisticasPanel(frame));
        frame.revalidate();
        frame.repaint();
    }

    public void sair() {
        new LoginGui().setVisible(true);
        frame.dispose();
    }
}
