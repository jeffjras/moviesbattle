package com.letscode.moviesbattle.service;

import com.letscode.moviesbattle.domain.Ranking;

import java.util.List;
import java.util.Optional;

public interface RankingService {
    void create(Ranking ranking);
    Optional<Ranking> getById(Long id);
    void delete(Long id);
    void update(Long id, Ranking ranking);
    List<Ranking> searchByNomeJogador(String nome);
}
