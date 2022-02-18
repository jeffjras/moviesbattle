package com.letscode.moviesbattle.dto;

import com.letscode.moviesbattle.domain.Jogador;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Objects;

public class RankingDTO {

    private Long id;

    private Jogador jogador;

    private Double pontuacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Double pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RankingDTO)) return false;
        RankingDTO ranking = (RankingDTO) o;
        return Objects.equals(getId(), ranking.getId()) && Objects.equals(getJogador(), ranking.getJogador()) && Objects.equals(getPontuacao(), ranking.getPontuacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getJogador(), getPontuacao());
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "id=" + id +
                ", jogador=" + jogador +
                ", pontuacao=" + pontuacao +
                '}';
    }
}
