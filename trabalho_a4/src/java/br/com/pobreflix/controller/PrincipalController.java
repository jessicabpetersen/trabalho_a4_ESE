package br.com.pobreflix.controller;

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

    @RequestMapping(value = {"/filmes/{nome}"}, method = RequestMethod.GET)
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
//            model.addAttribute("lista", dao.getFilmesNome(nome));
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

}
