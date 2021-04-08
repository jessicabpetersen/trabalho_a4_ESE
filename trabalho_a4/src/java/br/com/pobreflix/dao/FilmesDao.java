/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pobreflix.dao;

import br.com.pobreflix.model.Elenco;
import br.com.pobreflix.model.Filme;
import br.com.pobreflix.model.Oscar;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class FilmesDao {
    
    
    public List<Filme> getFilmes() throws SQLException{
        List<Filme> lista = new ArrayList<>();
        Conexao conn = new Conexao();
        String sql = "Select * from filmes";
                    System.out.println("entrou");

        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Filme filme;
        while(rs.next()){
            System.out.println(rs.getString("nome"));
            filme = new Filme();
            filme.setDuracao(rs.getInt("duracao"));
            filme.setGenero(rs.getInt("genero"));
            filme.setId(rs.getInt("id"));
            filme.setNome(rs.getString("nome"));
            filme.setOscares(getOscar(filme.getId()));
            List<Elenco> elenco = getElenco(filme.getId());
            filme.setAtores(getAtores(elenco));
            filme.setClassificacao(getClassificacao(filme.getId()));
            lista.add(filme);
        }
        conn.desconectar();
        return lista;
    }
    
    public List<Filme> getFilmesNome(String nome) throws SQLException{
         List<Filme> listaTodosFIlmes = getFilmes();
         List<Filme> listaNomes = new ArrayList<>();
         for(Filme filme: listaTodosFIlmes){
             if(filme.getNome().contains(nome)){
                 listaNomes.add(filme);
             }
         }
         return listaNomes;
    }
    
    public List<Filme> getFilmesOscares() throws SQLException{
        List<Filme> listaTodosFIlmes = getFilmes();
        List<Filme> listaOscares = new ArrayList<>();
        for(Filme filme: listaTodosFIlmes){
            if(!filme.getOscares().isEmpty()){
                listaOscares.add(filme);
            }
        }
        return listaOscares;
    }
    
    public String getOscar(int id) throws SQLException{
        Conexao conn = new Conexao();
        String sql = "Select * from oscar_melhor_filme where id_filme = "+ id;
        
        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String anoOscares = "";
        int a = 0;
        while(rs.next()){
            if(a != 0){
                anoOscares += " / ";
            }
            anoOscares += rs.getInt("ano");
            a++;
        }
        conn.desconectar();
        return anoOscares;
    }
    
    public int getClassificacao(int idFilme) throws SQLException{
        Conexao conn = new Conexao();
        String sql = "Select * from classificacoes where id_filme = "+ idFilme;
        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int classificacao = 0;
        int qtdd = 0;
        while(rs.next()){
             classificacao += rs.getInt("sn_gostou");
             qtdd++;
        }
        classificacao = classificacao/qtdd;
        conn.desconectar();
        return classificacao; 
    }
    
    public String getAtores(List<Elenco> elenco) throws SQLException{
        Conexao conn = new Conexao();
        String atores = "";
        int b = 0;
        for (Elenco elenco1 : elenco) {
            String sql = "Select * from ator where id = "+ elenco1.getAtores();
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(b != 0){
                    atores += " / ";
                }
                atores += rs.getString("nome");
                b++;
            }
            
        }
        
        return atores;
    }
    
    public List<Elenco> getElenco(int id) throws SQLException{
        Conexao conn = new Conexao();
        String sql = "Select * from elenco where id_filme = "+id;
        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Elenco> lista = new ArrayList<>();
         while(rs.next()){
             Elenco e = new Elenco();
             e.setId(rs.getInt("id"));
             e.setId_filme(id);
             e.setId_atores(rs.getInt("id_ator"));
             lista.add(e);
         }
         return lista;
    }
    
    public String getAtores(int id) throws SQLException {
        Conexao conn = new Conexao();
        String sql = "Select * from ator where id = "+id;
        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String atores = "";
        while(rs.next()){
            atores += rs.getString("nome");
        }
        return atores;
    }
}
