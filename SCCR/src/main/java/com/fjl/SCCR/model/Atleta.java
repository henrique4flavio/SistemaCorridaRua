package com.fjl.SCCR.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Atleta {
    @Id
    @GeneratedValue
    private Long id;

    private String nomemerg;
    private String telEmerg;
    private String apelido;
    private float pace;

    @OneToMany(mappedBy = "atleta")
    private List<Pontuacao> listaPontuacoes;

    public Atleta(Long id, String nomemerg, String telEmerg, String apelido, float pace, List<Pontuacao> listaPontuacoes) {
        this.id = id;
        this.nomemerg = nomemerg;
        this.telEmerg = telEmerg;
        this.apelido = apelido;
        this.pace = pace;
        this.listaPontuacoes = listaPontuacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomemerg() {
        return nomemerg;
    }

    public void setNomemerg(String nomemerg) {
        this.nomemerg = nomemerg;
    }

    public String getTelEmerg() {
        return telEmerg;
    }

    public void setTelEmerg(String telEmerg) {
        this.telEmerg = telEmerg;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public float getPace() {
        return pace;
    }

    public void setPace(float pace) {
        this.pace = pace;
    }

    public List<Pontuacao> getListaPontuacoes() {
        return listaPontuacoes;
    }

    public void setListaPontuacoes(List<Pontuacao> listaPontuacoes) {
        this.listaPontuacoes = listaPontuacoes;
    }
}
