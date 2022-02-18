package com.letscode.moviesbattle.service.impl;

import com.letscode.moviesbattle.domain.Jogador;
import com.letscode.moviesbattle.domain.Quiz;
import com.letscode.moviesbattle.repository.JogadorRepository;
import com.letscode.moviesbattle.repository.QuizRepository;
import com.letscode.moviesbattle.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    JogadorRepository jogadorRepository;

    @Override
    public void create(Quiz quiz) {
        quizRepository.save(quiz);
    }

    @Override
    public Optional<Quiz> getById(Long id) {
        Quiz quiz = quizRepository.getById(id);
        return Optional.of(quiz);
    }

    @Override
    public void delete(Long id) {
        quizRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Quiz quiz) {
        delete(id);
        create(quiz);
    }

    @Override
    public List<Quiz> searchByNomeJogador(String nome) {
        Jogador jogador = jogadorRepository.findByNome(nome);
        Quiz quiz = quizRepository.findByJogador(jogador);
        List<Quiz> dados = new ArrayList<>();
        dados.add(quiz);
        return dados;
    }
}
