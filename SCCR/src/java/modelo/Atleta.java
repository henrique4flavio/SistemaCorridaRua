package modelo;

import dao.AtletaDAO;
import java.sql.SQLException;
import java.util.*;

public class Atleta extends Usuario {

    public String nome;

    private String dataNascimento;

    private String sexo;

    private String rua;

    private String bairro;

    private String cidade;

    private String estado;

    private String pais;

    private String tamCamisa;

    private String telefoneCel;

    private String telefoneFixo;

    private String cpf;

    private String apelido;

    //Variaveis do banco de dados
    private int id;

    public Atleta(int id, String nome, String dataNascimento, String apelido, String cpf, String tamCamisa, String sexo, String telefoneFixo, String telefoneCel, String rua, String bairro, String cidade, String estado, String pais, String login, String senha, String email) {
        //To change body of generated methods, choose Tools | Templates.
        super(nome, senha, login, email);
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.tamCamisa = tamCamisa;
        this.telefoneCel = telefoneCel;
        this.telefoneFixo = telefoneFixo;
        this.cpf = cpf;
        this.apelido = apelido;
        this.id = id;
        this.nome = nome;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static List<Atleta> obterAtletas()
            throws ClassNotFoundException {
        return AtletaDAO.obterAtletas();
    }

    public void gravar() throws SQLException, ClassNotFoundException {

        AtletaDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        AtletaDAO.alterar(this);

    }

    public void excluir() throws SQLException, ClassNotFoundException {
        AtletaDAO.excluir(this);
    }

    public static Atleta obterAtleta(int id) throws ClassNotFoundException, SQLException {
        return AtletaDAO.obterAtleta(id);
    }

    public static Atleta logar(String email, String senha) throws ClassNotFoundException {
        return AtletaDAO.logar(email, senha);
    }
}
