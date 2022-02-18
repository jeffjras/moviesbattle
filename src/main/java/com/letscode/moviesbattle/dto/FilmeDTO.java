package com.letscode.moviesbattle.dto;

public class FilmeDTO {

    private Long id;

    private String nome;

    private Double pontuacao;

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
