package com.letscode.moviesbattle.repository;

import com.letscode.moviesbattle.domain.Filme;
import com.letscode.moviesbattle.domain.Jogador;
import com.letscode.moviesbattle.domain.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Quiz findByFilme(Filme filme);
    Quiz findByJogador(Jogador jogador);
    Page<Quiz> findByJogadorContainingAllIgnoringCase(@Param("jogador") Jogador jogador, Pageable pageable);
    Quiz findByNomeAllIgnoringCase(@Param("jogador") Jogador jogador);
}

