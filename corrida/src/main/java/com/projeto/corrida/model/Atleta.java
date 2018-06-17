package com.projeto.corrida.model;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data

@Accessors(chain = true)
public class Atleta extends Usuario implements Serializable {

    @OneToMany(mappedBy = "atleta")
    private List<Inscricao> listaInscricoes;


}
