package com.letscode.moviesbattle.dto;

import com.letscode.moviesbattle.domain.Quiz;
import java.util.List;
import java.util.Objects;

public class JogadorDTO {

    private Long id;

    private String nome;
    private String telefone;
    private String email;
    private int pontuacao;

    private List<Quiz> quizzes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JogadorDTO)) return false;
        JogadorDTO jogador = (JogadorDTO) o;
        return Objects.equals(getId(), jogador.getId()) && Objects.equals(getNome(), jogador.getNome()) && Objects.equals(getTelefone(), jogador.getTelefone()) && Objects.equals(getEmail(), jogador.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getTelefone(), getEmail());
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
