package modelo;

import dao.ResultadoProvaDAO;
import java.sql.SQLException;
import java.util.*;

public class ResultadoProva {

   
private int id;
private String nomeAtleta;
private int numeroPeito;
private String tempo;
private String categoria;
private int classificacao;
private String sexo;
private String prova;

    public String getProva() {
        return prova;
    }

    public void setProva(String prova) {
        this.prova = prova;
    }
    public ResultadoProva(int id, String nomeAtleta, int numeroPeito, String tempo, String categoria, int classificacao, String sexo,String prova) {
        this.id = id;
        this.nomeAtleta = nomeAtleta;
        this.numeroPeito = numeroPeito;
        this.tempo = tempo;
        this.categoria = categoria;
        this.classificacao = classificacao;
        this.sexo = sexo;
        this.prova=prova;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAtleta() {
        return nomeAtleta;
    }

    public void setNomeAtleta(String nomeAtleta) {
        this.nomeAtleta = nomeAtleta;
    }

    public int getNumeroPeito() {
        return numeroPeito;
    }

    public void setNumeroPeito(int numeroPeito) {
        this.numeroPeito = numeroPeito;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public static List<ResultadoProva> obterResultadoGeralMasculinoInfantilProva(String nome)throws ClassNotFoundException, SQLException{
        return ResultadoProvaDAO.obterResultadoGeralMasculinoInfantilProva(nome);
    }
    
    public static List<ResultadoProva> obterResultadoGeralFemininoInfantilProva(String nome) throws ClassNotFoundException,SQLException{
        return ResultadoProvaDAO.obterResultadoGeralFemininoInfantilProva(nome);
    }
     public static List<ResultadoProva> obterResultadoGeralFemininoAdultoProva(String nome)throws ClassNotFoundException,SQLException{
   
         return ResultadoProvaDAO.obterResultadoGeralFemininoAdultoProva(nome);
         
         
       }
 public static List<ResultadoProva> obterResultadoGeralMasculinoAdultoProva(String nome)throws ClassNotFoundException,SQLException{
   
         return ResultadoProvaDAO.obterResultadoGeralMasculinoAdultoProva(nome);
         
         
       }
 public static List<ResultadoProva> obterResultadoGeralMasculinoIdosoProva(String nome)throws ClassNotFoundException,SQLException{
   
         return ResultadoProvaDAO.obterResultadoGeralMasculinoIdosoProva(nome);
         
         
       }
 
 public static List<ResultadoProva> obterResultadoGeralFemininoIdosoProva(String nome)throws ClassNotFoundException,SQLException{
   
         return ResultadoProvaDAO.obterResultadoGeralFemininoIdosoProva(nome);
         
         
       }
 public static List<ResultadoProva> obterResultadoGeralFemininoProva(String nome)throws ClassNotFoundException,SQLException{
   
         return ResultadoProvaDAO.obterResultadoGeralFemininoProva(nome);
         
         
       }
 
  public static List<ResultadoProva> obterResultadoGeralMasculinoProva(String nome)throws ClassNotFoundException,SQLException{
   
         return ResultadoProvaDAO.obterResultadoGeralMasculinoProva(nome);
         
         
       }


}

