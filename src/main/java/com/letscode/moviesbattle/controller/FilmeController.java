package com.letscode.moviesbattle.controller;

import com.letscode.moviesbattle.domain.Filme;
import com.letscode.moviesbattle.repository.FilmeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/api")
public class FilmeController {

    private final FilmeRepository filmeRepository;
    private final String FILME_URI = "filmes/";

    public FilmeController(FilmeRepository filmeRepository) { this.filmeRepository = filmeRepository; }

    @GetMapping("/")
    public ModelAndView list() {
        Iterable<Filme> filmes = this.filmeRepository.findAll();
        return new ModelAndView(FILME_URI + "list","filmes",filmes);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Filme filme) {
        return new ModelAndView(FILME_URI + "view","filme",filme);
    }

    @GetMapping("/novo")
    public String createForm(@ModelAttribute Filme filme) {
        return FILME_URI + "form";
    }

    @PostMapping(params = "form")
    public ModelAndView create(@Valid Filme filme, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) { return new ModelAndView(FILME_URI + "form","formErrors",result.getAllErrors()); }
        filme = this.filmeRepository.save(filme);
        redirect.addFlashAttribute("globalMessage","Filme gravado com sucesso");
        return new ModelAndView("redirect:/" + FILME_URI + "{filme.id}","filme.id",filme.getId());
    }

    @GetMapping(value = "remover/{id}")
    public ModelAndView remover(@PathVariable("id") Long id,RedirectAttributes redirect) {
        this.filmeRepository.deleteById(id);
        Iterable<Filme> filmes = this.filmeRepository.findAll();

        ModelAndView mv = new ModelAndView(FILME_URI + "list","filmes",filmes);
        mv.addObject("globalMessage","Filme removido com sucesso");

        return mv;
    }

    @GetMapping(value = "alterar/{id}")
    public ModelAndView alterarForm(@PathVariable("id") Filme filme) {
        return new ModelAndView(FILME_URI + "form","filme",filme);
    }

}
