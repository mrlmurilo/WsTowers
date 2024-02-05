/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wstowers.util;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
/**
 *
 * @author muril
 */
public class Usuario {

    private UUID id;
    private String nome;
    private String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

}
