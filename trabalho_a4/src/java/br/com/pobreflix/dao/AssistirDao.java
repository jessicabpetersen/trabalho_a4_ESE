
package br.com.pobreflix.dao;

import conexao.Conexao;

public class AssistirDao {
    
    private RegistrarServicosDao registrar;
    
    public AssistirDao() {
        registrar = new RegistrarServicosDao();
    }
    
    public void assistir(int id_usuario, int id_filme) {
        Conexao conn = new Conexao();
        String sql = "INSERT INTO public.filmes_assistidos (id_usuario, id_filme, dt_momento)"
                   + " VALUES ( " + id_usuario + ", " + id_filme + ", CURRENT_TIMESTAMP)";

        int res = conn.executaSql(sql);

        if(res > 0) {
            registrar.registrarServico(id_usuario, 4);
        }
    }

}
