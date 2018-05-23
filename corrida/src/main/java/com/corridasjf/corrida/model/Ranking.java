package com.corridasjf.corrida.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ranking {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "ranking")
    private List<Pontos> pontos;

    @ManyToOne
    private Corrida corrida;

    public Ranking(Long id, String nome, List<Pontos> pontos) {
        this.id = id;
        this.nome = nome;
        this.pontos = pontos;
    }

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

    public List<Pontos> getPontos() {
        return pontos;
    }

    public void setPontos(List<Pontos> pontos) {
        this.pontos = pontos;
    }
}
