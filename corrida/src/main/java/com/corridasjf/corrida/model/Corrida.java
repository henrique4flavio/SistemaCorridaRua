package com.corridasjf.corrida.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Evento {

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;
    private String linkMapa;
    private String localLargada;
    private String duracao;
    private String dataEvento;
    private String horalargada;
    private int maxParticipantes;

    @ManyToOne
    @JoinColumn(name = "organizador_id")
    private Organizador organizador;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "evento")
    private List<Kit> listaKits;
    @OneToMany(mappedBy = "evento")
    private List<Percurso> listaPercursos;
    @OneToMany(mappedBy = "evento")
    private List<Ranking> listaRankings;
    @OneToMany(mappedBy = "evento")
    private List<Lote> listaLotes;

    public Evento(Long id, String titulo, String linkMapa, String localLargada, String duracao, String dataEvento, String horalargada, int maxParticipantes, Organizador organizador, Endereco endereco, List<Kit> listaKits, List<Percurso> listaPercursos, List<Ranking> listaRankings, List<Lote> listaLotes) {
        this.id = id;
        this.titulo = titulo;
        this.linkMapa = linkMapa;
        this.localLargada = localLargada;
        this.duracao = duracao;
        this.dataEvento = dataEvento;
        this.horalargada = horalargada;
        this.maxParticipantes = maxParticipantes;
        this.organizador = organizador;
        this.endereco = endereco;
        this.listaKits = listaKits;
        this.listaPercursos = listaPercursos;
        this.listaRankings = listaRankings;
        this.listaLotes = listaLotes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLinkMapa() {
        return linkMapa;
    }

    public void setLinkMapa(String linkMapa) {
        this.linkMapa = linkMapa;
    }

    public String getLocalLargada() {
        return localLargada;
    }

    public void setLocalLargada(String localLargada) {
        this.localLargada = localLargada;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getHoralargada() {
        return horalargada;
    }

    public void setHoralargada(String horalargada) {
        this.horalargada = horalargada;
    }

    public int getMaxParticipantes() {
        return maxParticipantes;
    }

    public void setMaxParticipantes(int maxParticipantes) {
        this.maxParticipantes = maxParticipantes;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Kit> getListaKits() {
        return listaKits;
    }

    public void setListaKits(List<Kit> listaKits) {
        this.listaKits = listaKits;
    }

    public List<Percurso> getListaPercursos() {
        return listaPercursos;
    }

    public void setListaPercursos(List<Percurso> listaPercursos) {
        this.listaPercursos = listaPercursos;
    }

    public List<Ranking> getListaRankings() {
        return listaRankings;
    }

    public void setListaRankings(List<Ranking> listaRankings) {
        this.listaRankings = listaRankings;
    }

    public List<Lote> getListaLotes() {
        return listaLotes;
    }

    public void setListaLotes(List<Lote> listaLotes) {
        this.listaLotes = listaLotes;
    }
}
