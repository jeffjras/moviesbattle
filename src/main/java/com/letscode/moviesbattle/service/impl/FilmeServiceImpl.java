package com.letscode.moviesbattle.service.impl;

import com.letscode.moviesbattle.domain.Filme;
import com.letscode.moviesbattle.repository.FilmeRepository;
import com.letscode.moviesbattle.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeServiceImpl implements FilmeService {

    @Autowired
    FilmeRepository filmeRepository;

    @Override
    public void create(Filme filme) {
        filmeRepository.save(filme);
    }

    @Override
    public Optional<Filme> getById(Long id) {
        Filme filme = filmeRepository.getById(id);
        return Optional.of(filme);
    }

    @Override
    public void delete(Long id) {
        filmeRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Filme filme) {
        delete(id);
        create(filme);
    }

    @Override
    public List<Filme> searchByNome(String nome) {
        Filme filme = filmeRepository.findByNome(nome);
        List<Filme> dados = new ArrayList<Filme>();
        dados.add(filme);
        return dados;
    }
}
