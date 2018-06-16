package com.projeto.corrida.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Entity

@Accessors(chain = true)
public class Organizador extends Usuario implements Serializable {

    @ManyToOne
    private Administrador administrador;

}