package com.projeto.corrida.model;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Data
@Entity
@Accessors(chain = true)
public class Kit {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String descricao;

    private String tipoChip;
    private String preco;

    @ManyToOne
    private Organizador organizador;

    @ManyToOne

    @JoinColumn(name = "prova_id")
    private Prova prova;

}
