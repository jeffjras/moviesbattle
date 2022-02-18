package com.letscode.moviesbattle.repository;

import com.letscode.moviesbattle.domain.Filme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    Filme findByNome(String nome);
    Page<Filme> findByNomeContainingAllIgnoringCase(@Param("nome") String nome, Pageable pageable);
    Filme findByNomeAllIgnoringCase(@Param("nome") String nome);
}