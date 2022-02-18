package com.letscode.moviesbattle.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = true)
    private Jogador jogador;

    @ManyToMany
    @Cascade(CascadeType.MERGE)
    private List<Filme> filmes;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date data;

    @Min(1)
    private int tentativas;

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

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quiz)) return false;
        Quiz quiz = (Quiz) o;
        return getTentativas() == quiz.getTentativas() && Objects.equals(getId(), quiz.getId()) && Objects.equals(getJogador(), quiz.getJogador()) && Objects.equals(getFilmes(), quiz.getFilmes()) && Objects.equals(getData(), quiz.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getJogador(), getFilmes(), getData(), getTentativas());
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", jogador=" + jogador +
                ", filmes=" + filmes +
                ", data=" + data +
                ", tentativas=" + tentativas +
                '}';
    }
}
