
package br.com.pobreflix.controller;

import br.com.pobreflix.dao.ClassificarDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/classificar")
public class ClassificarController {
    
    private ClassificarDao classificar;
    
    public ClassificarController() {
        classificar = new ClassificarDao();
    }
    
    @RequestMapping("/incluir")
    public String incluir(@RequestParam int id_filme, @RequestParam int id_usuario, @RequestParam int nota) {
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
    
    @RequestMapping("/alterar")
    public String alterar(@RequestParam int id_classificacao, @RequestParam int nota, @RequestParam int id_usuario){
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
    
    @RequestMapping("/excluir")
    public String excluir(@RequestParam int id_classificacao, @RequestParam int id_usuario){
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