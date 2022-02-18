package com.letscode.moviesbattle.service.impl;

import com.letscode.moviesbattle.domain.Filme;
import com.letscode.moviesbattle.domain.Jogador;
import com.letscode.moviesbattle.repository.JogadorRepository;
import com.letscode.moviesbattle.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class JogadorServiceImpl implements JogadorService {

    @Autowired
    JogadorRepository jogadorRepository;

    @Override
    public void create(Jogador jogador) {
        jogadorRepository.save(jogador);
    }

    @Override
    public Optional<Jogador> getById(Long id) {
        Jogador jogador = jogadorRepository.getById(id);
        return Optional.of(jogador);
    }

    @Override
    public void delete(Long id) {
        jogadorRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Jogador jogador) {
        delete(id);
        create(jogador);
    }

    @Override
    public List<Jogador> searchByNome(String nome) {
        Jogador jogador = jogadorRepository.findByNome(nome);
        List<Jogador> dados = new ArrayList<Jogador>();
        dados.add(jogador);
        return dados;
    }

    @Override
    public Jogador searchByEmail(String email) {
        return jogadorRepository.findByEmail(email);
    }
}
