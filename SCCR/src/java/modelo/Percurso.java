package modelo;

import dao.PercursoDAO;
import java.sql.SQLException;
import java.util.*;

public class Percurso {

    private String nome;

    private String distancia;

    private String faixaEtaria;
    
    //Variaveis do banco de dados
    private int id;
    
    private String prova_id;

    public Percurso(int id, String nome, String distancia, String faixaEtaria, String prova_id) {
        this.nome = nome;
        this.distancia = distancia;
        this.faixaEtaria = faixaEtaria;
        this.prova_id = prova_id;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getNome() {
        return nome;
    }

    public String getProva_id() {
        return prova_id;
    }
    
    public void setProva_id(String prova_id) {
        this.prova_id = prova_id;
    }

    
    public void cadastrarPercurso() {

    }

    public void alterarPercurso() {

    }

    public Percurso consultarPercurso() {
        return null;
    }

    public void excluirPercurso() {

    }

    public void importarMapeamento() {

    }

    public void divulgarPercurso() {

    }
    public static List<Percurso> obterPercursos()
            throws ClassNotFoundException {
        return PercursoDAO.obterPercursos();

    }
    public void gravar() throws SQLException, ClassNotFoundException {

        PercursoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        PercursoDAO.alterar(this);

    }

    public void excluir() throws SQLException, ClassNotFoundException {
        PercursoDAO.excluir(this);
    }

    public static Percurso obterPercurso(int id) throws ClassNotFoundException, SQLException {
        return PercursoDAO.obterPercurso(id);
    }

}
