package com.projeto.corrida.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Accessors(chain = true)
@Data
public class Percurso implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private float distancia;

    @ManyToOne
    @JoinColumn(name = "prova_id")
    private Prova prova;

    @OneToMany(mappedBy = "percurso")
    private List<Inscricao> listaIncricoes;
}
