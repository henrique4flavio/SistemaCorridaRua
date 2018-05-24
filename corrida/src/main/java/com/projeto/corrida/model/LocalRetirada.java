package com.projeto.corrida.model;

import javax.persistence.*;

@Entity
public class LocalRetirada {

    @Id
    @GeneratedValue
    private Long id;

    private String horaInicial;
    private String horaFinal;
    private String dataInicial;
    private String dataFinal;

    @ManyToOne
    private Endereco endereco;


    public LocalRetirada(Long id, String horaInicial, String horaFinal, String dataInicial, String dataFinal, Endereco endereco) {
        this.id = id;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
