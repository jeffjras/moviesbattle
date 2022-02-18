package com.letscode.moviesbattle.controller;

import com.letscode.moviesbattle.domain.Ranking;
import com.letscode.moviesbattle.repository.RankingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/api")
public class RankingController {

    private final RankingRepository rankingRepository;
    private final String RANKING_URI = "rankings/";

    public RankingController(RankingRepository rankingRepository) { this.rankingRepository = rankingRepository; }

    @GetMapping("/")
    public ModelAndView list() {
        Iterable<Ranking> rankings = this.rankingRepository.findAll();
        return new ModelAndView(RANKING_URI + "list","rankings",rankings);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Ranking ranking) {
        return new ModelAndView(RANKING_URI + "view","ranking",ranking);
    }

    @GetMapping("/novo")
    public String createForm(@ModelAttribute Ranking ranking) {
        return RANKING_URI + "form";
    }

    @PostMapping(params = "form")
    public ModelAndView create(@Valid Ranking ranking, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) { return new ModelAndView(RANKING_URI + "form","formErrors",result.getAllErrors()); }
        ranking = this.rankingRepository.save(ranking);
        redirect.addFlashAttribute("globalMessage","Ranking gravado com sucesso");
        return new ModelAndView("redirect:/" + RANKING_URI + "{ranking.id}","ranking.id",ranking.getId());
    }

    @GetMapping(value = "remover/{id}")
    public ModelAndView remover(@PathVariable("id") Long id,RedirectAttributes redirect) {
        this.rankingRepository.deleteById(id);
        Iterable<Ranking> rankings = this.rankingRepository.findAll();

        ModelAndView mv = new ModelAndView(RANKING_URI + "list","rankings",rankings);
        mv.addObject("globalMessage","Ranking removido com sucesso");

        return mv;
    }

    @GetMapping(value = "alterar/{id}")
    public ModelAndView alterarForm(@PathVariable("id") Ranking ranking) {
        return new ModelAndView(RANKING_URI + "form","ranking",ranking);
    }

}
