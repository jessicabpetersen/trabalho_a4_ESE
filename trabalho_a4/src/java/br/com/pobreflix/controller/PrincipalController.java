
package br.com.pobreflix.controller;

import br.com.pobreflix.dao.AssistirDao;
import br.com.pobreflix.dao.FilmesDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jessica
 */
@Controller
public class PrincipalController {
    
    @RequestMapping("/inicial")
    public String iniciando(){
        return "login";
    }
    
     @RequestMapping("/index")
    public String logar(){
        return "index";
    }
    
    @RequestMapping("/filmes")
    public String filmes(Model model){
        FilmesDao dao = new FilmesDao();
        try{
            model.addAttribute("lista", dao.getFilmes());
        }catch(Exception e){
            
        }
        return "filmes";
    }
    
    @RequestMapping("/oscar")
    public String oscar(Model model){
        FilmesDao dao = new FilmesDao();
        try{
            model.addAttribute("lista", dao.getFilmesOscares());
        }catch(Exception e){
            
        }
        return "oscar";
    }

    @RequestMapping("/assitir")
    public void assitir() {
        AssistirDao dao = new AssistirDao();
        try{
           dao.assistir(0, 0);
        }
        catch(Exception e){
            
        }
    }
}
