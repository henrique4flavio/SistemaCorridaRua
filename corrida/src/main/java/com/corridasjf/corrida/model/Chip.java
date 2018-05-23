package com.corridasjf.corrida.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Chip {
    @Id
    @GeneratedValue
    private Long id;

    private String tipoChip;
    private float distancia;

    public Chip(Long id, String tipoChip, float distancia) {
        this.id = id;
        this.tipoChip = tipoChip;
        this.distancia = distancia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoChip() {
        return tipoChip;
    }

    public void setTipoChip(String tipoChip) {
        this.tipoChip = tipoChip;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }
}
