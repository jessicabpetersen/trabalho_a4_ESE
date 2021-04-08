
package br.com.pobreflix.controller;

import br.com.pobreflix.dao.ClassificarDao;

public class ClassificarController {
    
    private ClassificarDao classificar;
    
    public ClassificarController() {
        classificar = new ClassificarDao();
    }
    
    public String incluir(int id_filme, int id_usuario, int nota) {
        String retorno;
        int res = classificar.incluirClassificacao(id_filme, id_usuario, nota);
        if(res > 0) {
            retorno = "Classificação incluída com sucesso!";
        }
        else {
            retorno = "Erro ao incluir a classificação!";
        }
        return retorno;
    }
    
    public String alterar(int id_classificacao, int nota, int id_usuario){
        String retorno;
        int res = classificar.alterarClassificacao(id_classificacao, nota, id_usuario);
        if(res > 0) {
            retorno = "Classificação alterada com sucesso!";
        }
        else {
            retorno = "Erro ao alterar a classificação!";
        }
        return retorno;
    }

    public String excluir(int id_classificacao, int id_usuario){
        String retorno;
        int res = classificar.excluirClassificacao(id_classificacao, id_usuario);
        if(res > 0) {
            retorno = "Classificação excluída com sucesso!";
        }
        else {
            retorno = "Erro ao excluir a classificação!";
        }
        return retorno;
    }
    
}