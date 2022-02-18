package com.letscode.moviesbattle.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Objects;

@Entity
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = true)
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

    @Min(1)
    public Double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Double pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ranking)) return false;
        Ranking ranking = (Ranking) o;
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
