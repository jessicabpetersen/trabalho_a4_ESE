/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jessica
 */
public class Conexao {

    private Connection conn;

    private void conectar() throws SQLException {
        System.out.println("Conectando ao banco");
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://db:5432/postgres", "postgres", "85ESE_A2");
            System.out.println("Conectado");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void desconectar() throws SQLException{
        conn.close();
    }

    public Connection getConexao() throws SQLException {
        conectar();
        return conn;

    }
}
