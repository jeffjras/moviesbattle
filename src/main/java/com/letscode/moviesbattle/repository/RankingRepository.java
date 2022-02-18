package com.letscode.moviesbattle.repository;

import com.letscode.moviesbattle.domain.Jogador;
import com.letscode.moviesbattle.domain.Ranking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Long> {
    Ranking findByJogador(Jogador jogador);
    Page<Ranking> findByJogadorContainingAllIgnoringCase(@Param("jogador") Jogador jogador, Pageable pageable);
    Ranking findByNomeAllIgnoringCase(@Param("jogador") Jogador jogador);
}

