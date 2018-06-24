package com.projeto.corrida.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Accessors(chain = true)
@Data
public class Pagamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float total;
    private boolean status;
    private String tipoPagamento;
    private String codigo;

    @OneToOne(mappedBy = "pagamento")
    private Inscricao inscricao;



}
