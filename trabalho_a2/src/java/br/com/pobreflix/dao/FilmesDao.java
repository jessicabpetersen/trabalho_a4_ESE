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
        
        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Filme filme;
        while(rs.next()){
            filme = new Filme();
            filme.setDuracao(rs.getInt("duracao"));
            filme.setGenero(rs.getInt("genero"));
            filme.setId(rs.getInt("id"));
            filme.setNome(rs.getString("nome"));
            filme.setOscares(getOscar(filme.getId()));
            List<Elenco> elenco = getElenco(filme.getId());
            filme.setAtores(getAtores(elenco));
            lista.add(filme);
        }
        conn.desconectar();
        return lista;
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
    
    public String getAtores(List<Elenco> elenco) throws SQLException{
        Conexao conn = new Conexao();
        String atores = "";
        int b = 0;
        for (Elenco elenco1 : elenco) {
            String sql = "Select * from ator where id = "+ elenco1.getId_ator();
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
             e.setId_ator(rs.getInt("id_ator"));
             lista.add(e);
         }
         return lista;
    }
}
