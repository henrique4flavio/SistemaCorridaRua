package com.projeto.corrida.model;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Accessors(chain = true)
@Data
public class Inscricao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tamanhoCamisa;
    private String precoTotal;
    private String dataInscricao;
    private boolean pago;
    private boolean kitRetirado;


    @ManyToOne
    private Kit kit;

    @ManyToOne
    private Atleta atleta;

    @ManyToOne
    private Percurso percurso;





}


