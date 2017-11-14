package modelo;

import java.util.*;

public abstract class Usuario {

    private String nome;

    private String senha;

    private String login;

    private String email;

    public Usuario(String nome, String senha, String login, String email) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void login(String login, String senha) {

    }

    public void alterarDadosUsuario() {

    }

    public Usuario consultarUsuario() {
        return null;
    }

    public void excluirConta() {

    }

    public void recuperarSenha() {

    }

}
