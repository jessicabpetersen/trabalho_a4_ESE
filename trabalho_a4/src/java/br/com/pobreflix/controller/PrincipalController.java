
package br.com.pobreflix.controller;

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
    
    @RequestMapping("/index")
    public String iniciando(){
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
    
    @RequestMapping("/elenco")
    public String elenco(Model model){
        
        return "elenco";
    }
    
    @RequestMapping("/login")
    public String login(Model model){
        
        return "login";
    }
    
    @RequestMapping("/assistir")
    public String assistir(Model model){
        
        return "assistir";
    }
    
    @RequestMapping("/classificar")
    public String classificar(Model model){
        
        return "classificar";
    }
    
    @RequestMapping("/oscar")
    public String oscar(Model model){
        
        return "oscar";
    }
    
    @RequestMapping("/registrar")
    public String registrar(Model model){
        
        return "registrar";
    }
    
}
