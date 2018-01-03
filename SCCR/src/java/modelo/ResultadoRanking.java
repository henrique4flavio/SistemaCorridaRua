/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.ResultadoProvaDAO;
import dao.ResultadoRankingDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LaisAlves
 */
public class ResultadoRanking {


    private int id;
    private String categoria;
    private int classificacao;
    private int pontuacao;
    private String nomeAtleta;
     private String ranking;
private String sexo;
    public ResultadoRanking(int id, String categoria,String nomeAtleta,String ranking,String sexo,int classificacao, int pontuacao) {
        this.id = id;
        this.categoria = categoria;
        this.classificacao = classificacao;
        this.pontuacao = pontuacao;
        this.ranking=ranking;
        this.nomeAtleta = nomeAtleta;
        this.sexo = sexo;
    }
        public String getNomeAtleta() {
        return nomeAtleta;
    }

    public void setNomeAtleta(String nomeAtleta) {
        this.nomeAtleta = nomeAtleta;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    
     public static List<ResultadoRanking> obterResultadoGeralMasculinoInfantilRanking(String ranking)throws ClassNotFoundException, SQLException{
        return ResultadoRankingDAO.obterResultadoGeralMasculinoInfantilRanking(ranking);
    }
    
    public static List<ResultadoRanking> obterResultadoGeralFemininoInfantilRanking(String ranking) throws ClassNotFoundException,SQLException{
        return ResultadoRankingDAO.obterResultadoGeralFemininoInfantilRanking(ranking);
    }
     public static List<ResultadoRanking> obterResultadoGeralFemininoAdultoRanking(String ranking)throws ClassNotFoundException,SQLException{
   
         return ResultadoRankingDAO.obterResultadoGeralFemininoAdultoRanking(ranking);
         
         
       }
 public static List<ResultadoRanking> obterResultadoGeralMasculinoAdultoRanking(String ranking)throws ClassNotFoundException,SQLException{
   
         return ResultadoRankingDAO.obterResultadoGeralMasculinoAdultoRanking(ranking);
         
         
       }
 public static List<ResultadoRanking> obterResultadoGeralMasculinoIdosoRanking(String ranking)throws ClassNotFoundException,SQLException{
   
         return ResultadoRankingDAO.obterResultadoGeralMasculinoIdosoRanking(ranking);
         
         
       }
 
 public static List<ResultadoRanking> obterResultadoGeralFemininoIdosoRanking(String ranking)throws ClassNotFoundException,SQLException{
   
         return ResultadoRankingDAO.obterResultadoGeralFemininoIdosoRanking(ranking);
         
         
       }
 public static List<ResultadoRanking> obterResultadoGeralFemininoRanking(String ranking)throws ClassNotFoundException,SQLException{
   
         return ResultadoRankingDAO.obterResultadoGeralFemininoRanking(ranking);
         
         
       }
 
  public static List<ResultadoRanking> obterResultadoGeralMasculinoRanking(String ranking)throws ClassNotFoundException,SQLException{
   
         return ResultadoRankingDAO.obterResultadoGeralMasculinoRanking(ranking);
         
         
       }


}
