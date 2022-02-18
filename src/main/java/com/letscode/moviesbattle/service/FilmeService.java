package com.letscode.moviesbattle.service;

import com.letscode.moviesbattle.domain.Filme;
import java.util.List;
import java.util.Optional;

public interface FilmeService {
    void create(Filme filme);
    Optional<Filme> getById(Long id);
    void delete(Long id);
    void update(Long id, Filme filme);
    List<Filme> searchByNome(String nome);
}
