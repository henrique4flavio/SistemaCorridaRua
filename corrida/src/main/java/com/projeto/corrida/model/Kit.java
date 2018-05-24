package com.projeto.corrida.model;

import javax.persistence.*;

@Entity
public class Kit {

    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
    private boolean camisa;
    private String produtos;
    private float valorKit;

    @ManyToOne
    private Corrida corrida;
    @ManyToOne
    private LocalRetirada localRetirada;

    public Kit(Long id, String descricao, boolean camisa, String produto, float valorKit, Corrida corrida, LocalRetirada localRetirada) {
        this.id = id;
        this.descricao = descricao;
        this.camisa = camisa;
        this.produto = produto;
        this.valorKit = valorKit;
        this.corrida = corrida;
        this.localRetirada = localRetirada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCamisa() {
        return camisa;
    }

    public void setCamisa(boolean camisa) {
        this.camisa = camisa;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public float getValorKit() {
        return valorKit;
    }

    public void setValorKit(float valorKit) {
        this.valorKit = valorKit;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public LocalRetirada getLocalRetirada() {
        return localRetirada;
    }

    public void setLocalRetirada(LocalRetirada localRetirada) {
        this.localRetirada = localRetirada;
    }
}
