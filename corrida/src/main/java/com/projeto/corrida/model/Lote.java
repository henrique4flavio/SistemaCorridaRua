package com.projeto.corrida.model;

import javax.persistence.*;

@Entity
public class Lote {
    @Id
    @GeneratedValue
    private Long id;

    private String dataInicial;
    private String dataFinal;
    private float valor;

    @ManyToOne
    private Corrida corrida;

    public Lote(Long id, String dataInicial, String dataFinal, float valor, Evento evento) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.valor = valor;
        this.evento = evento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
