
package br.com.pobreflix.dao;

import conexao.Conexao;

public class ClassificarDao {
    
    public void incluirClassificacao(int id_filme, int id_usuario, int nota) {
        Conexao conn = new Conexao();
        String sql = "INSERT INSTO public.classificacoes (id, id_filme, id_usuario, sn_gostou, dt_momento)"
                   + " VALUES ( (SELECT COALESCE(MAX(id), 0) + 1 FROM public.classificacoes), " + id_filme +
                ", " + id_usuario + ", " + nota + ", CURRENT_TIMESTAMP)";

        int res = conn.executaSql(sql);
    }
    
    public void alterarClassificacao(int id_classificacao, int nota) {
        Conexao conn = new Conexao();
        String sql = "UPDATE public.classificacoes"
                   + "   SET sn_gostou = " + nota
                   + " WHERE id = " + id_classificacao;
        
        int res = conn.executaSql(sql);
    }
    
    public void excluirClassificacao(int id_classificacao) {
        Conexao conn = new Conexao();
        String sql = "DELETE FROM public.classificacoes"
                  + " WHERE id = " + id_classificacao;
        
        int res = conn.executaSql(sql);
    }
    
}
