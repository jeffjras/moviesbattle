package com.letscode.moviesbattle.service;

import com.letscode.moviesbattle.domain.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizService {
    void create(Quiz quiz);
    Optional<Quiz> getById(Long id);
    void delete(Long id);
    void update(Long id, Quiz quiz);
    List<Quiz> searchByNomeJogador(String nome);
}
