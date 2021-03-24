/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pobreflix.model;

/**
 *
 * @author Jessica
 */
public class Elenco {
    private int id;
    private int id_filme;
    private int id_atores;
    private String atores;

    public int getId_atores() {
        return id_atores;
    }

    public void setId_atores(int id_atores) {
        this.id_atores = id_atores;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_filme() {
        return id_filme;
    }

    public void setId_filme(int id_filme) {
        this.id_filme = id_filme;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    
    
    
}
