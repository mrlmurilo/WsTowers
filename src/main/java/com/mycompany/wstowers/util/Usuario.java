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

    private int id;
    private String nome;
    private String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

}
