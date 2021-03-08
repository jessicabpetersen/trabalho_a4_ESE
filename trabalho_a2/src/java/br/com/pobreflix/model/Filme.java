/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pobreflix.model;

import java.util.List;

/**
 *
 * @author Jessica
 */
public class Filme {
    
    private int id;
    private String nome;
    private int duracao;
    private int genero;
    private String oscares;
    private String atores;

    public String getOscares() {
        return oscares;
    }

    public void setOscares(String oscares) {
        this.oscares = oscares;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }
    
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }
    
}
