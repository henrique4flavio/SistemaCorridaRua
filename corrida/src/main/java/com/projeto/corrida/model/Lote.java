package com.projeto.corrida.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;


import javax.persistence.*;
@Data
@Entity

@Accessors(chain = true)
public class Lote implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    Locale localeBR = new Locale("pt","BR");

    private String nome;
    private Float preco;

    private String dataInicio;
    private String dataFinal;

    @ManyToOne
    private Prova prova;

    @ManyToOne
    private Organizador organizador;
}