package com.letscode.moviesbattle.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.letscode.moviesbattle.domain.Filme;
import com.letscode.moviesbattle.domain.Jogador;
import com.letscode.moviesbattle.dto.FilmeDTO;
import com.letscode.moviesbattle.service.FilmeService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class FilmeControllerTest {

    @Autowired
    private MockMvc mvc = null;

    @MockBean
    private FilmeService filmeService = null;

    @Test
    @WithMockUser
    void testCadastrarJogo() throws Exception {
        Filme filme = mock(Filme.class);

        mvc.perform(MockMvcRequestBuilders.post("api/filmes")
                .content(obterJsonRequisicaoPost())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.data.tipo").value("nome"))
                .andExpect((ResultMatcher) jsonPath("$.erros").isEmpty());
    }
    private String obterJsonRequisicaoPost() throws JsonProcessingException {
        FilmeDTO filmeDTO = new FilmeDTO();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(filmeDTO);
    }

}