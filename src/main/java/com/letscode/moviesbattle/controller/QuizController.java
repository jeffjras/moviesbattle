package com.letscode.moviesbattle.controller;

import com.letscode.moviesbattle.domain.Quiz;
import com.letscode.moviesbattle.repository.QuizRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/api")
public class QuizController {

    private final QuizRepository quizRepository;
    private final String QUIZ_URI = "quizes/";

    public QuizController(QuizRepository quizRepository) { this.quizRepository = quizRepository; }

    @GetMapping("/")
    public ModelAndView list() {
        Iterable<Quiz> quizes = this.quizRepository.findAll();
        return new ModelAndView(QUIZ_URI + "list","quizes",quizes);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Quiz quiz) {
        return new ModelAndView(QUIZ_URI + "view","quiz",quiz);
    }

    @GetMapping("/novo")
    public String createForm(@ModelAttribute Quiz quiz) {
        return QUIZ_URI + "form";
    }

    @PostMapping(params = "form")
    public ModelAndView create(@Valid Quiz quiz, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) { return new ModelAndView(QUIZ_URI + "form","formErrors",result.getAllErrors()); }
        quiz = this.quizRepository.save(quiz);
        redirect.addFlashAttribute("globalMessage","Quiz gravado com sucesso");
        return new ModelAndView("redirect:/" + QUIZ_URI + "{quiz.id}","quiz.id",quiz.getId());
    }

    @GetMapping(value = "remover/{id}")
    public ModelAndView remover(@PathVariable("id") Long id,RedirectAttributes redirect) {
        this.quizRepository.deleteById(id);
        Iterable<Quiz> quizes = this.quizRepository.findAll();

        ModelAndView mv = new ModelAndView(QUIZ_URI + "list","quizes",quizes);
        mv.addObject("globalMessage","Quiz removido com sucesso");

        return mv;
    }

    @GetMapping(value = "alterar/{id}")
    public ModelAndView alterarForm(@PathVariable("id") Quiz quiz) {
        return new ModelAndView(QUIZ_URI + "form","quiz",quiz);
    }

}
