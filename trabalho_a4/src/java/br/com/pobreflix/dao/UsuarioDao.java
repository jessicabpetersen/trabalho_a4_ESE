/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pobreflix.dao;

import br.com.pobreflix.model.Usuario;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel Petersen
 */
public class UsuarioDao {
    
    
    public Usuario autenticar(String username, String senha) throws SQLException{
        String sql = "Select * from usuario where nome = '"+username+"' and senha = '"+senha+"';";
        Conexao conn = new Conexao();
          PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Usuario usuario = new Usuario();
        usuario.setNome("");
        while (rs.next()) {
           usuario = new Usuario();
           usuario.setId(rs.getInt("id"));
           usuario.setNome(rs.getString("nome"));
           usuario.setSenha(rs.getString("senha"));
        }
        conn.desconectar();
        return usuario;
    }
}
