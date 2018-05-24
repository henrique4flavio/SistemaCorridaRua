package com.projeto.corrida.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco {
    @Id
    @GeneratedValue
    private Long id;

    private String cep;
    private String cidade;
    private String uf;
    private String numeroLogradouro;
    private String complementoLogradouro;
    private String bairro;

    public Endereco(Long id, String cep, String logradouro, String cidade, String uf, String numeroLogradouro, String complementoLogradouro, String bairro) {
        this.id = id;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.numeroLogradouro = numeroLogradouro;
        this.complementoLogradouro = complementoLogradouro;
        this.bairro = bairro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNumeroLogradouro() {
        return numeroLogradouro;
    }

    public void setNumeroLogradouro(String numeroLogradouro) {
        this.numeroLogradouro = numeroLogradouro;
    }

    public String getComplementoLogradouro() {
        return complementoLogradouro;
    }

    public void setComplementoLogradouro(String complementoLogradouro) {
        this.complementoLogradouro = complementoLogradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
