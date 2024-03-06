/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wstowers.util;

import java.util.UUID;
import javax.swing.JPanel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 *
 * @author muril
 */
public class Mapa extends JPanel{

    private UUID id;
    private int[] dados;
    private int solucaoMinima;

    public Mapa(int[] dados, int solucaoMinima) {
        this.dados = dados;
        this.solucaoMinima = solucaoMinima;
    }

}
