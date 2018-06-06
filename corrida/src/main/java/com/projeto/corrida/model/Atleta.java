package com.projeto.corrida.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Atleta {
    @Id
    @GeneratedValue
    private Long id;

    private String login;
    private String senha;
    private String tamanhoCamisa;


    @Autowired
    public Atleta(Long id, String login, String senha, String tamanhoCamisa) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.tamanhoCamisa = tamanhoCamisa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTamanhoCamisa() {
        return tamanhoCamisa;
    }

    public void setTamanhoCamisa(String tamanhoCamisa) {
        this.tamanhoCamisa = tamanhoCamisa;
    }






}
