package com.letscode.moviesbattle.controller;

import com.letscode.moviesbattle.domain.Jogador;
import com.letscode.moviesbattle.repository.JogadorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/api")
public class JogadorController {

    private final JogadorRepository jogadorRepository;
    private final String JOGADOR_URI = "jogadores/";

    public JogadorController(JogadorRepository jogadorRepository) { this.jogadorRepository = jogadorRepository; }

    @GetMapping("/")
    public ModelAndView list() {
        Iterable<Jogador> jogadores = this.jogadorRepository.findAll();
        return new ModelAndView(JOGADOR_URI + "list","jogadores",jogadores);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Jogador jogador) {
        return new ModelAndView(JOGADOR_URI + "view","jogador",jogador);
    }

    @GetMapping("/novo")
    public String createForm(@ModelAttribute Jogador jogador) {
        return JOGADOR_URI + "form";
    }

    @PostMapping(params = "form")
    public ModelAndView create(@Valid Jogador jogador, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) { return new ModelAndView(JOGADOR_URI + "form","formErrors",result.getAllErrors()); }
        jogador = this.jogadorRepository.save(jogador);
        redirect.addFlashAttribute("globalMessage","Jogador gravado com sucesso");
        return new ModelAndView("redirect:/" + JOGADOR_URI + "{filme.id}","filme.id",jogador.getId());
    }

    @GetMapping(value = "remover/{id}")
    public ModelAndView remover(@PathVariable("id") Long id,RedirectAttributes redirect) {
        this.jogadorRepository.deleteById(id);
        Iterable<Jogador> jogadores = this.jogadorRepository.findAll();

        ModelAndView mv = new ModelAndView(JOGADOR_URI + "list","jogadores",jogadores);
        mv.addObject("globalMessage","Jogador removido com sucesso");

        return mv;
    }

    @GetMapping(value = "alterar/{id}")
    public ModelAndView alterarForm(@PathVariable("id") Jogador jogador) {
        return new ModelAndView(JOGADOR_URI + "form","jogador",jogador);
    }

}
