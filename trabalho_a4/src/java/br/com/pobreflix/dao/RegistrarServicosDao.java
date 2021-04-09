
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
        String sql = "INSERT INTO public.servicos_usados (id_usuario, id_servico, dt_momento)"
                   + " VALUES ( " + id_usuario + ", " + id_servico + ", CURRENT_TIMESTAMP)";

        conn.executaSql(sql);
    }
    
}
