package com.letscode.moviesbattle.service;

import com.letscode.moviesbattle.domain.Jogador;

import java.util.List;
import java.util.Optional;

public interface JogadorService {
    void create(Jogador jogador);
    Optional<Jogador> getById(Long id);
    void delete(Long id);
    void update(Long id, Jogador jogador);
    List<Jogador> searchByNome(String nome);
    Jogador searchByEmail(String email);
}
