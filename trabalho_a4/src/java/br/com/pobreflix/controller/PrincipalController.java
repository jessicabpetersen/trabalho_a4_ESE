package br.com.pobreflix.controller;

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

    @RequestMapping("/inicial")
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
            model.addAttribute("lista", dao.getFilmes(0));
            System.out.println(model);
        } catch (Exception e) {

        }
        return "filmes";
    }

    @RequestMapping(value = {"/filmes/{nome}"}, method = RequestMethod.GET)
    public String getFilme(@PathVariable("nome") String nome, Model model) {
        System.out.println(nome);
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
<<<<<<< HEAD
//            model.addAttribute("lista", dao.getFilmesNome());
=======
//            model.addAttribute("lista", dao.getFilmesNome(nome));
>>>>>>> 2a99dadc6638c48d57778ec5363dc64097af47a9
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

    @RequestMapping("/assistir")
    public String assistir(Model model) {
        FilmesDao dao = new FilmesDao();
        try {
            model.addAttribute("lista", dao.getFilmes(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "assistir";
    }

    @RequestMapping("/classificar")
    public String classificar() {
        return "classificar";
    }

<<<<<<< HEAD
    @RequestMapping(value = {"/classificar/{nota}{usuario}{filme}"}, method = RequestMethod.POST)
=======
    @RequestMapping("/incluirClassificacao")
    public String incluirClassificacao(Model model) {
        FilmesDao dao = new FilmesDao();
        try {
            model.addAttribute("lista", dao.getFilmes(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "incluirClassificacao";
    }

    @RequestMapping(value = {"/incluirClassificacao/{nota}{usuario}{filme}"}, method = RequestMethod.POST)
>>>>>>> 2a99dadc6638c48d57778ec5363dc64097af47a9
    public String incluirClassificacao(@PathVariable("nota") int nota, @PathVariable("usuario") int usuario, @PathVariable("filme") int filme) {
        ClassificarController classi = new ClassificarController();
        classi.incluir(filme, usuario, nota);
        return "classificar";
    }

<<<<<<< HEAD
    @RequestMapping(value = {"/classificar/{classificacao}{nota}{usuario}"}, method = RequestMethod.POST)
=======
    @RequestMapping("/alterarClassificacao")
    public String alterarClassificacao(Model model) {
        ClassificarDao dao = new ClassificarDao();
        try {
            model.addAttribute("lista", dao.getClassificacoes(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "alterarClassificacao";
    }
    
    @RequestMapping(value = {"/alterarClassificacao/{classificacao}{nota}{usuario}"}, method = RequestMethod.POST)
>>>>>>> 2a99dadc6638c48d57778ec5363dc64097af47a9
    public String alterarClassificacao(@PathVariable("nota") int nota, @PathVariable("usuario") int usuario, @PathVariable("classificacao") int classificacao) {
        ClassificarController classi = new ClassificarController();
        classi.alterar(classificacao, nota, usuario);
        return "classificar";
    }

<<<<<<< HEAD
    @RequestMapping(value = {"/classificar/{classificacao}{usuario}"}, method = RequestMethod.POST)
=======
    @RequestMapping("/excluirClassificacao")
    public String excluirClassificacao(Model model) {
        ClassificarDao dao = new ClassificarDao();
        try {
            model.addAttribute("lista", dao.getClassificacoes(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "excluirClassificacao";
    }
    
    @RequestMapping(value = {"/excluirClassificacao/{classificacao}{usuario}"}, method = RequestMethod.POST)
>>>>>>> 2a99dadc6638c48d57778ec5363dc64097af47a9
    public String excluirClassificacao(@PathVariable("usuario") int usuario, @PathVariable("classificacao") int classificacao) {
        ClassificarController classi = new ClassificarController();
        classi.excluir(classificacao, usuario);
        return "classificar";
    }

}
