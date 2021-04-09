
package br.com.pobreflix.dao;

import conexao.Conexao;
import br.com.pobreflix.model.Classificar;
import br.com.pobreflix.model.Filme;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassificarDao {
    
    private RegistrarServicosDao registrar;
    
    public ClassificarDao() {
        registrar = new RegistrarServicosDao();
    }
    
    public int incluirClassificacao(int id_filme, int id_usuario, int nota) {
        Conexao conn = new Conexao();
        String sql = "INSERT INSTO public.classificacoes (id, id_filme, id_usuario, sn_gostou, dt_momento)"
                   + " VALUES ( (SELECT COALESCE(MAX(id), 0) + 1 FROM public.classificacoes), " + id_filme +
                ", " + id_usuario + ", " + nota + ", CURRENT_TIMESTAMP)";

        int res = conn.executaSql(sql);
        if(res > 0) {
            registrar.registrarServico(id_usuario, 1);
        }
        return res;
    }
    
    public int alterarClassificacao(int id_classificacao, int nota, int id_usuario) {
        Conexao conn = new Conexao();
        String sql = "UPDATE public.classificacoes"
                   + "   SET sn_gostou = " + nota
                   + " WHERE id = " + id_classificacao;
        
        int res = conn.executaSql(sql);
        if(res > 0) {
            registrar.registrarServico(id_usuario, 2);
        }
        return res;
    }
    
    public int excluirClassificacao(int id_classificacao, int id_usuario) {
        Conexao conn = new Conexao();
        String sql = "DELETE FROM public.classificacoes"
                  + " WHERE id = " + id_classificacao;
        
        int res = conn.executaSql(sql);
        if(res > 0) {
            registrar.registrarServico(id_usuario, 3);
        }
        return res;
    }
    
    public List<Classificar> getClassificacoes() throws SQLException {
        List<Classificar> lista = new ArrayList<>();
        Conexao conn = new Conexao();
        
        String sql = "Select classificacoes.id,"
                   + "classificacoes.sn_gostou,"
                   + "classificacao.dt_momento,"
                   + "filmes.nome"
                   + "from public.classificacoes"
                   + "join public.flmes on (filmes.id = classificacoes.id_filme)";
        
        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Classificar classi;
        while (rs.next()) {
            classi = new Classificar();
            classi.setData(rs.getString("dt_momento"));
            classi.setId(rs.getInt("id"));
            classi.setNota(rs.getInt("sn_gostou"));
            classi.setNomeFilme(rs.getString("nome"));
        }
        
        return lista;
    }
    
}
