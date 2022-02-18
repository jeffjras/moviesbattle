package com.letscode.moviesbattle.service;

import com.letscode.moviesbattle.domain.Filme;
import com.letscode.moviesbattle.repository.FilmeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class FilmeServiceTest {

    @Autowired
    FilmeService filmeService;

    @MockBean
    private FilmeRepository filmeRepository;

    @BeforeEach
    void setUp() {
        String nome = "Teste de Filme";
        BDDMockito.given(filmeRepository.findByNome(nome)).willReturn(new Filme());
        BDDMockito.given(filmeRepository.save(new Filme())).willReturn(new Filme());
    }

    @Test
    void create() {
    }

    @Test
    void getById() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void searchByNome() {
    }
}