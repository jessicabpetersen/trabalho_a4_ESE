/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pobreflix.model;

/**
 *
 * @author Gabriel Petersen
 */
public class Usuario {
    private int id;
    private String nome;
    private String senha;
    
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

    public String getSenha() {
        return nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
