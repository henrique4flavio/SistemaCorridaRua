package com.projeto.corrida.model;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


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
    private Double preco;
    @ManyToOne
    private Organizador organizador;


}
