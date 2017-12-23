package modelo;

import dao.ResultadoProvaDAO;
import java.sql.SQLException;
import java.util.*;

public class ResultadoProva {

    private int id;
    private int classificacao;
    private String id_atleta;
    private String tempo;
       private String nome;
 private String id_prova;

    public String getId_prova() {
        return id_prova;
    }

    public void setId_prova(String id_prova) {
        this.id_prova = id_prova;
    }
    
    private String numeroPeito;

    public ResultadoProva(int id, int classificacao,String tempo, String id_atleta,  String numeroPeito,String id_prova) {
        this.id = id;
        this.classificacao = classificacao;
        this.id_atleta = id_atleta;
        this.tempo = tempo;
        this.numeroPeito = numeroPeito;
        this.nome= nome;
        this.id_prova = id_prova;
    }
    
public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getId_atleta() {
        return id_atleta;
    }

    public void setId_atleta(String id_atleta) {
        this.id_atleta = id_atleta;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getNumeroPeito() {
        return numeroPeito;
    }

    public void setNumeroPeito(String numeroPeito) {
        this.numeroPeito = numeroPeito;
    }
    
    public void consultarResultadoIndividual() {

    }

    public void importarEquipeMasculino() {

    }

    public void importarEquipeFeminino() {

    }

    public void importarFaixaEtariaMasculino() {

    }

    public void importarFaixaEtariaFeminino() {

    }
    public void importarGeralMasculino(){

    }
    public void importarGeralFeminino(){

    }
    public void exportarEquipeMasculino(){

    }
    public void exportarEquipeFeminino(){

    }
    public void exportarFaixaEtariaMasculino(){

    }
    public void exportarFaixaEtariaFeminino(){

    }
    public void exportarGeralMasculino(){

    }
    public void exportarGeralFeminino(){

    }
     
    public static List<ResultadoProva> obterResultadoGeralFemininoProva(int id) throws ClassNotFoundException, SQLException {
        return ResultadoProvaDAO.obterResultadoGeralFemininoProva(id);
}
    public static List<ResultadoProva> obterResultadoGeralMasculinoProva(int id) throws ClassNotFoundException, SQLException {
        return ResultadoProvaDAO.obterResultadoGeralMasculinoProva(id);
}
     public static List<ResultadoProva> obterResultadoGeralProva(int id) throws ClassNotFoundException, SQLException {
        return ResultadoProvaDAO.obterResultadoGeralProva(id);
}
}

