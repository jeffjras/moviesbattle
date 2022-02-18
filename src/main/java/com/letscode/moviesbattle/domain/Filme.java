package com.letscode.moviesbattle.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Length(min=30, max=250,message="O tamanho do nome deve ser entre {min} e {max} caracteres")
    private String nome;

    @Min(1)
    private Double pontuacao;

    @Min(1)
    private Double nota;

    private int voto;

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

    public Double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", pontuacao=" + pontuacao +
                ", nota=" + nota +
                ", voto=" + voto +
                '}';
    }
}
