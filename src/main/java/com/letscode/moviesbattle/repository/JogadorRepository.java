package com.letscode.moviesbattle.repository;

import com.letscode.moviesbattle.domain.Jogador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    Jogador findByNome(String nome);
    Jogador findByEmail(String email);
    Page<Jogador> findByNomeContainingAllIgnoringCase(@Param("nome") String nome, Pageable pageable);
    Jogador findByNomeAllIgnoringCase(@Param("nome") String nome);
}

