package com.corridasjf.corrida.model;

import javax.persistence.*;

@Entity
public class Inscricao {
    @Id
    @GeneratedValue
    private Long id;

    private Boolean statusRetirada;
    private String tamCamisa;
    private int numeroPeito;
    private float precoTotal;

    @OneToOne
    private Chip chip;

    @ManyToOne
    private Atleta atleta;
    @ManyToOne
    private Percurso percurso;
    @ManyToOne
    private Pagamento pagamento;
    @ManyToOne
    private Kit kit;

    private String dataInscricao;

    public Inscricao(Long id, Boolean statusRetirada, String tamCamisa, int numeroPeito, float precoTotal, Chip chip, Atleta atleta, Percurso percurso, Pagamento pagamento, Kit kit, String dataInscricao) {
        this.id = id;
        this.statusRetirada = statusRetirada;
        this.tamCamisa = tamCamisa;
        this.numeroPeito = numeroPeito;
        this.precoTotal = precoTotal;
        this.chip = chip;
        this.atleta = atleta;
        this.percurso = percurso;
        this.pagamento = pagamento;
        this.kit = kit;
        this.dataInscricao = dataInscricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatusRetirada() {
        return statusRetirada;
    }

    public void setStatusRetirada(Boolean statusRetirada) {
        this.statusRetirada = statusRetirada;
    }

    public String getTamCamisa() {
        return tamCamisa;
    }

    public void setTamCamisa(String tamCamisa) {
        this.tamCamisa = tamCamisa;
    }

    public int getNumeroPeito() {
        return numeroPeito;
    }

    public void setNumeroPeito(int numeroPeito) {
        this.numeroPeito = numeroPeito;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Chip getChip() {
        return chip;
    }

    public void setChip(Chip chip) {
        this.chip = chip;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public Percurso getPercurso() {
        return percurso;
    }

    public void setPercurso(Percurso percurso) {
        this.percurso = percurso;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Kit getKit() {
        return kit;
    }

    public void setKit(Kit kit) {
        this.kit = kit;
    }

    public String getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(String dataInscricao) {
        this.dataInscricao = dataInscricao;
    }
}
