package modelo;

import java.util.*;

public class Atleta extends Usuario {

    private String dataNascimento;

    private String sexo;

    private String endereco;

    private String tamCamisa;

    private String telefoneCel;

    private String telefoneFixo;

    private String cpf;

    private String apelido;

    private String nomeDaEquipe;

    public Atleta(String dataNascimento, String nome, String sexo, String endereco, String tamCamisa, String telefoneCel, String telefoneFixo, String cpf, String apelido, String nomeDaEquipe, String senha, String login, String email) {
        super(nome, senha, login, email);
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.endereco = endereco;
        this.tamCamisa = tamCamisa;
        this.telefoneCel = telefoneCel;
        this.telefoneFixo = telefoneFixo;
        this.cpf = cpf;
        this.apelido = apelido;
        this.nomeDaEquipe = nomeDaEquipe;

    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTamCamisa() {
        return tamCamisa;
    }

    public void setTamCamisa(String tamCamisa) {
        this.tamCamisa = tamCamisa;
    }

    public String getTelefoneCel() {
        return telefoneCel;
    }

    public void setTelefoneCel(String telefoneCel) {
        this.telefoneCel = telefoneCel;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNomeDaEquipe() {
        return nomeDaEquipe;
    }

    public void setNomeDaEquipe(String nomeDaEquipe) {
        this.nomeDaEquipe = nomeDaEquipe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String nome;

    public String visualizarClassificacao() {

        return "";
    }

    public String visualizarRanking() {
        return "";
    }

    public String cadastrarAtleta() {
        return "";
    }

}
