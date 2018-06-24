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

    @OneToOne(optional = true)
    @JoinColumn(name = "pagamento_codPagamento")
    private Pagamento pagamento;

    @OneToOne
    @JoinColumn(name = "kit_id")
    private Kit kit;

    @ManyToOne
    @JoinColumn(name = "atleta_id")
    private Atleta atleta;

    @ManyToOne
    @JoinColumn(name = "percurso_id")
    private Percurso percurso;





}


