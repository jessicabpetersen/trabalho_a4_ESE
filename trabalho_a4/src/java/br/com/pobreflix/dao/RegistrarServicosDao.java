
package br.com.pobreflix.dao;

import conexao.Conexao;

public class RegistrarServicosDao {
    
    /**
     * 
     * @param id_usuario usuário logado
     * @param id_servico serviço executado 1, 'Incluir Classificação', 2, 'Alterar Classificação', 3, 'Excluir Classificação', 4, 'Assistir Filme'
     */
    public void registrarServico(int id_usuario, int id_servico) {
        Conexao conn = new Conexao();
        String sql = "INSERT INSTO public.servicos_usados (id, id_usuario, id_servico, dt_momento)"
                   + " VALUES ( (SELECT COALESCE(MAX(id), 0) + 1 FROM public.servicos_usados), " + id_usuario
                   + ", " + id_servico + ", CURRENT_TIMESTAMP)";

        conn.executaSql(sql);
    }
    
}
