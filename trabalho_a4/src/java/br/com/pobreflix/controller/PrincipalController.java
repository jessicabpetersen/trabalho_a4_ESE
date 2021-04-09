package br.com.pobreflix.controller;

import br.com.pobreflix.dao.AssistirDao;
import br.com.pobreflix.dao.ClassificarDao;
import br.com.pobreflix.dao.FilmesDao;
import br.com.pobreflix.dao.UsuarioDao;
import br.com.pobreflix.model.Usuario;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jessica
 */
@Controller
public class PrincipalController {

    @RequestMapping("/login")
    public String iniciando() {
        return "login";
    }
    
    @RequestMapping("/logando")
    public String logando(String username, String password, HttpSession session) throws SQLException{ 
        UsuarioDao daoUsu = new UsuarioDao();
        Usuario usuario = daoUsu.autenticar(username, password);
        if(usuario.getNome().equals("")){
            return "login";
        }
            session.setAttribute("usuario", usuario.getId());
            System.out.println("Antes de ir p index logado"+session.getAttribute("usuario"));
        return "index";
    }

    @RequestMapping("/registrar")
    public String registrar() {
        return "registar";
    }

    @RequestMapping("/index")
    public String logar(HttpSession session ) {
        System.out.println("logado"+session.getAttribute("usuario"));
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        return "index";
    }

    @RequestMapping("/filmes")
    public String filmes(Model model, HttpSession session ) {
        System.out.println("logado"+session.getAttribute("usuario"));
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        FilmesDao dao = new FilmesDao();
        try {
            model.addAttribute("lista", dao.getFilmes());
        } catch (Exception e) {

        }
        
        
        return "filmes";
    }

    @RequestMapping("/filmes/{nome}")
    public String getFilme(@PathVariable("nome") String nome, Model model,HttpSession session) {
        System.out.println("logado"+session.getAttribute("usuario"));
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        FilmesDao dao = new FilmesDao();
        try {
            model.addAttribute("lista", dao.getFilmesNome(nome));
        } catch (Exception e) {

        }
        return "filmes";
    }
    
    @RequestMapping("/filmes/string/{nome}")
    public String getFilmeNome(@PathVariable("nome") String nome, Model model,HttpSession session) {
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        FilmesDao dao = new FilmesDao();
        try {
            model.addAttribute("lista", dao.getFilmeString(nome));
        } catch (Exception e) {

        }
        return "filmes";
    }

    @RequestMapping(value = {"/elenco/{id}"}, method = RequestMethod.GET)
    public String getElenco(@PathVariable("id") int id, Model model, HttpSession session) {
        if(session.getAttribute("usuario") == null){
            return "login";
        }
         System.out.println("entrou elencoid");
        FilmesDao dao = new FilmesDao();
        try {
            System.out.println("model 1" + model.getClass());
          model.addAttribute("lista", dao.getFilmesNome(id));
          System.out.println("model 2" + model);
        } catch (Exception e) {

        }
        return "ator";
    }

    @RequestMapping("/oscar")
    public String oscar(Model model,HttpSession session) {
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        System.out.println("entrou oscar");
        FilmesDao dao = new FilmesDao();
        try {
            model.addAttribute("lista", dao.getFilmesOscares());
        } catch (Exception e) {

        }
        return "oscar";
    }

    @RequestMapping("/elenco")
    public String elenco(Model model,HttpSession session) {
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        FilmesDao dao = new FilmesDao();
        try {
            model.addAttribute("lista", dao.getElencoFilmea());
        } catch (Exception e) {

        }
        return "elenco";
    }

    @RequestMapping("/assistir/{id}")
    public String assistir(@PathVariable("id") int id, Model model, HttpSession session) {
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        AssistirDao dao = new AssistirDao();
        dao.assistir((int)session.getAttribute("usuario"), id);
        return "index";
    }

    @RequestMapping("/classificar")
    public String classificar(HttpSession session) {
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        return "classificar";
    }
    
    @RequestMapping("/classificar/excluir/{id}")
    public String classificar(@PathVariable("id") int id, HttpSession session, Model model) {
        System.out.println("entrou no excluir classificacao, usuario id: "+session.getAttribute("usuario")+" filme id "+id);
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        FilmesDao dao = new FilmesDao();
        try {
            dao.excluirClassificacao(id, (int)session.getAttribute("usuario"));
        } catch (Exception e) {

        }
        return "index";
    }
    
    @RequestMapping("/classificar/add/{id}")
    public String classificar(@PathVariable("id") int id, int nota, HttpSession session, Model model) {
        System.out.println("entrou no add ou alterar classificacao, id do filme "+ id+" com nota "+ nota+" do usuario: "+session.getAttribute("usuario"));
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        FilmesDao dao = new FilmesDao();
        try {
            dao.updateClassificacao(id, (int)session.getAttribute("usuario"), nota);
        } catch (Exception e) {
        }
        return "index";
    }

    @RequestMapping("/incluirClassificacao")
    public String incluirClassificacao(Model model,HttpSession session) {
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        FilmesDao dao = new FilmesDao();
        try {
            model.addAttribute("lista", dao.getFilmes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "incluirClassificacao";
    }

    @RequestMapping("/incluirClassificacao/{filme}{nota}")
    public String incluirClassificacao(@PathVariable("nota") int nota, @PathVariable("filme") int filme,HttpSession session) {
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        ClassificarController classi = new ClassificarController();
        classi.incluir(filme, 1, nota);
        return "classificar";
    }

    @RequestMapping("/alterarClassificacao")
    public String alterarClassificacao(Model model,HttpSession session) {
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        ClassificarDao dao = new ClassificarDao();
        try {
            model.addAttribute("lista", dao.getClassificacoes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "alterarClassificacao";
    }

    @RequestMapping("/alterarClassificacao/{classificacao}{nota}")
    public String alterarClassificacao(@PathVariable("nota") int nota, @PathVariable("classificacao") int classificacao,HttpSession session) {
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        ClassificarController classi = new ClassificarController();
        classi.alterar(classificacao, nota, 1);
        return "classificar";
    }

    @RequestMapping("/excluirClassificacao")
    public String excluirClassificacao(Model model,HttpSession session) {
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        ClassificarDao dao = new ClassificarDao();
        try {
            model.addAttribute("lista", dao.getClassificacoes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "excluirClassificacao";
    }

    @RequestMapping("/excluirClassificacao/{classificacao}")
    public String excluirClassificacao(@PathVariable("classificacao") int classificacao,HttpSession session) {
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        ClassificarController classi = new ClassificarController();
        classi.excluir(classificacao, 1);
        return "classificar";
    }


    @RequestMapping("/elenco/{id}")
    public String elenco(@PathVariable("id") int id, Model model,HttpSession session) {
        if(session.getAttribute("usuario") == null){
            return "login";
        }
        FilmesDao dao = new FilmesDao();
        try {
            model.addAttribute("lista", dao.getElencoFilme(id));
        } catch (Exception e) {

        }
        return "elenco";
    }

}
