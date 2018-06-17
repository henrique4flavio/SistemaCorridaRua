package com.projeto.corrida.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Accessors(chain = true)
@Data
public class Prova implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String localLargada;
    private String dataEvento;
    private String horalargada;
    private int maxParticipantes;

    @ManyToOne
    @JoinColumn(name = "organizador_id")
    private Organizador organizador;

    @OneToMany(mappedBy = "prova")
    private List<Kit> listaKits;

    @OneToMany(mappedBy = "prova")
    private List<Percurso> listaPercursos;
}
