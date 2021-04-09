package br.com.pobreflix.controller;

import br.com.pobreflix.dao.AssistirDao;
import br.com.pobreflix.dao.ClassificarDao;
import br.com.pobreflix.dao.FilmesDao;
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

    @RequestMapping("/registrar")
    public String registrar() {
        return "registar";
    }

    @RequestMapping("/index")
    public String logar() {
        return "index";
    }

    @RequestMapping("/filmes")
    public String filmes(Model model) {

        FilmesDao dao = new FilmesDao();

        try {
            model.addAttribute("lista", dao.getFilmes());
        } catch (Exception e) {

        }
        return "filmes";
    }

    @RequestMapping("/filmes/{nome}")
    public String getFilme(@PathVariable("nome") String nome, Model model) {
        FilmesDao dao = new FilmesDao();
        try {
            model.addAttribute("lista", dao.getFilmesNome(nome));
        } catch (Exception e) {

        }
        return "filmes";
    }

    @RequestMapping(value = {"/elenco/{id}"}, method = RequestMethod.GET)
    public String getElenco(@PathVariable("nome") int id, Model model) {
        FilmesDao dao = new FilmesDao();
        try {
//            model.addAttribute("lista", dao.getFilmesNome());
        } catch (Exception e) {

        }
        return "filmes";
    }

    @RequestMapping("/oscar")
    public String oscar(Model model) {
        FilmesDao dao = new FilmesDao();
        try {
            model.addAttribute("lista", dao.getFilmesOscares());
        } catch (Exception e) {

        }
        return "oscar";
    }

    @RequestMapping("/elenco")
    public String elenco(Model model) {
        FilmesDao dao = new FilmesDao();
        try {
            model.addAttribute("lista", dao.getFilmesOscares());
        } catch (Exception e) {

        }
        return "elenco";
    }

    @RequestMapping("/assistir/{id}")
    public String assistir(@PathVariable("id") int id, Model model) {
        AssistirDao dao = new AssistirDao();
        dao.assistir(1, id);
        return "index";
    }

    @RequestMapping("/classificar")
    public String classificar() {
        return "classificar";
    }

    @RequestMapping("/incluirClassificacao")
    public String incluirClassificacao(Model model) {
        FilmesDao dao = new FilmesDao();
        try {
            model.addAttribute("lista", dao.getFilmes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "incluirClassificacao";
    }

    @RequestMapping("/incluirClassificacao/{filme}{nota}")
    public String incluirClassificacao(@PathVariable("nota") int nota, @PathVariable("filme") int filme) {
        ClassificarController classi = new ClassificarController();
        classi.incluir(filme, 1, nota);
        return "classificar";
    }

    @RequestMapping("/alterarClassificacao")
    public String alterarClassificacao(Model model) {
        ClassificarDao dao = new ClassificarDao();
        try {
            model.addAttribute("lista", dao.getClassificacoes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "alterarClassificacao";
    }

    @RequestMapping("/alterarClassificacao/{classificacao}{nota}")
    public String alterarClassificacao(@PathVariable("nota") int nota, @PathVariable("classificacao") int classificacao) {
        ClassificarController classi = new ClassificarController();
        classi.alterar(classificacao, nota, 1);
        return "classificar";
    }

    @RequestMapping("/excluirClassificacao")
    public String excluirClassificacao(Model model) {
        ClassificarDao dao = new ClassificarDao();
        try {
            model.addAttribute("lista", dao.getClassificacoes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "excluirClassificacao";
    }

    @RequestMapping("/excluirClassificacao/{classificacao}")
    public String excluirClassificacao(@PathVariable("classificacao") int classificacao) {
        ClassificarController classi = new ClassificarController();
        classi.excluir(classificacao, 1);
        return "classificar";
    }

}
