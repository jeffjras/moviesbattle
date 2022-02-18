package com.letscode.moviesbattle.service.impl;

import com.letscode.moviesbattle.domain.Jogador;
import com.letscode.moviesbattle.domain.Quiz;
import com.letscode.moviesbattle.domain.Ranking;
import com.letscode.moviesbattle.repository.JogadorRepository;
import com.letscode.moviesbattle.repository.RankingRepository;
import com.letscode.moviesbattle.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RankingServiceImpl implements RankingService {

    @Autowired
    RankingRepository rankingRepository;

    @Autowired
    JogadorRepository jogadorRepository;

    @Override
    public void create(Ranking ranking) {
        rankingRepository.save(ranking);
    }

    @Override
    public Optional<Ranking> getById(Long id) {
        Ranking ranking = rankingRepository.getById(id);
        return Optional.of(ranking);
    }

    @Override
    public void delete(Long id) {
        rankingRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Ranking ranking) {
        delete(id);
        create(ranking);
    }

    @Override
    public List<Ranking> searchByNomeJogador(String nome) {
        Jogador jogador = jogadorRepository.findByNome(nome);
        Ranking ranking = rankingRepository.findByJogador(jogador);
        List<Ranking> dados = new ArrayList<>();
        dados.add(ranking);
        return dados;
    }
}
