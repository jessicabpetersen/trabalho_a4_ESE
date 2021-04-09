/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pobreflix.dao;

import br.com.pobreflix.model.Ator;
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

    public List<Filme> getFilmes() throws SQLException {
        List<Filme> lista = new ArrayList<>();
        Conexao conn = new Conexao();
        String sql = "Select * from filmes";

        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Filme filme;
        while (rs.next()) {
            filme = new Filme();
            filme.setClassificacao(10);
            filme.setDuracao(rs.getInt("duracao"));
            filme.setGenero(rs.getInt("genero"));
            filme.setId(rs.getInt("id"));
            filme.setNome(rs.getString("nome"));
            filme.setOscares(this.getOscar(rs.getInt("id"), conn));
            lista.add(filme);

        }
        conn.desconectar();
        return lista;
    }

    public List<Filme> getFilmesNome(String nome) throws SQLException {
        List<Filme> listaTodosFIlmes = getFilmes();
        List<Filme> listaNomes = new ArrayList<>();
        for (Filme filme : listaTodosFIlmes) {
            if (filme.getNome().contains(nome)) {
                listaNomes.add(filme);
            }
        }
        return listaNomes;
    }

    public List<Filme> getFilmesOscares() throws SQLException {
        System.out.println("entrou getFilmesOscares");
        List<Filme> listaTodosFIlmes = getFilmes();
        List<Filme> listaOscares = new ArrayList<>();
        for (Filme filme : listaTodosFIlmes) {
            if (!filme.getOscares().isEmpty()) {
                listaOscares.add(filme);
            }
        }
        
        return listaOscares;
    }

    public String getOscar(int id, Conexao conn) throws SQLException {
        System.out.println("entrou getoscar");
        String sql = "Select * from oscar_melhor_filme where id_filme = " + id;

        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String anoOscares = "";
        int a = 0;
        while (rs.next()) {
            if (a != 0) {
                anoOscares += " / ";
            }
            anoOscares += rs.getInt("ano");
            System.out.println("oscar ano:" + rs.getInt("ano"));
            a++;
        }
        return anoOscares;
    }

    public int getClassificacao(int idFilme, Conexao conn) throws SQLException {
        System.out.println("entrou getclassificacao");
        String sql = "Select * from classificacoes where id_filme = " + idFilme;
        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int classificacao = 0;
        int qtdd = 0;
        while (rs.next()) {
            System.out.println("classificacao: " + rs.getInt("sn_gostou"));
            classificacao += rs.getInt("sn_gostou");
            qtdd++;
        }
        System.out.println("classificacao total: " + classificacao + "qntdd:" + qtdd);
        if (qtdd != 0) {
            classificacao = classificacao / qtdd;
        } else {
            classificacao = 0;
        }

        return classificacao;
    }

    public String getAtoresFromElenco(List<Elenco> elenco, Conexao conn) throws SQLException {
        System.out.println("entrou getatoresfromelenco");
        List<Ator> lista = new ArrayList<>();
        String elencoa = "";
        for (Elenco elenco1 : elenco) {
            String sql = "Select * from ator where id = " + elenco1.getAtores();
            PreparedStatement ps = conn.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                elencoa += rs.getString("nome");
            }

        }

        return elencoa;
    }

    public List<Elenco> getElenco(int id, Conexao conn) throws SQLException {
        System.out.println("entrou getelenco");
        String sql = "Select * from elenco where id_filme = " + id;
        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Elenco> lista = new ArrayList<>();
        while (rs.next()) {
            Elenco e = new Elenco();
            e.setId(rs.getInt("id"));
            e.setId_filme(id);
            e.setId_atores(rs.getInt("id_ator"));
            lista.add(e);
        }
        return lista;
    }

    public String getAtores(int id, Conexao conn) throws SQLException {
        System.out.println("entrou A");
        String sql = "Select * from ator where id = " + id;
        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String atores = "";
        while (rs.next()) {
            atores += rs.getString("nome");
        }
        return atores;
    }

//	public List<Ator> getElencoFilme(int id)throws SQLException {
//		System.out.println("entrou getElencoFIlme");
//		List<Elenco> elenco = getElenco(id);
//		return getAtoresFromElenco(elenco);
//	}
}
