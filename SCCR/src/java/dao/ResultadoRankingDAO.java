/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.ResultadoProva;
import modelo.ResultadoRanking;

/**
 *
 * @author LaisAlves
 */
public class ResultadoRankingDAO {
     private static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {

        }

    }

  public static List<ResultadoRanking> obterResultadoGeralMasculinoInfantilRanking(String nomeRanking) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ResultadoRanking> resultadosRanking = new ArrayList<ResultadoRanking>();
        PreparedStatement pm = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            /*
            pm=conexao.prepareStatement("select * from prova where prova=?");
            pm.setString(1,nomeProva);
            rs=pm.executeQuery();
             rs.next();

            ResultadoProva resultadoProva = new ResultadoProva(
                    rs.getInt("id"),
                    rs.getString("nomeAtleta"),
                    
                    rs.getInt("numeroPeito"),
                    rs.getString("tempo"),
                    rs.getString("categoria"),
                    rs.getInt("classificacao"),
                    rs.getString("sexo"),
            rs.getString("prova"));

            resultados.add(resultadoProva);
             */

            ResultSet rs = comando.executeQuery("SELECT * FROM resultadoranking where sexo='masculino' and categoria ='infantil' and ranking like '%" + nomeRanking + "%' order by classificacao asc");

            while (rs.next()) {

                ResultadoRanking resultadoRanking = new ResultadoRanking(
                        rs.getInt("id"),
                        rs.getString("categoria"),
                       rs.getString("nomeAtleta"),
                         rs.getString("ranking"),
                        rs.getString("sexo"),
                        rs.getInt("classificacao"),
                        rs.getInt("pontuacao"));
                        
                      

                resultadosRanking.add(resultadoRanking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }

        return resultadosRanking;
    }

    public static List<ResultadoRanking> obterResultadoGeralFemininoInfantilRanking(String nomeRanking) throws ClassNotFoundException, SQLException {
        

            Connection conexao = null;
            Statement comando = null;
            List<ResultadoRanking> resultadosRanking = new ArrayList<ResultadoRanking>();
            PreparedStatement pm = null;

            try {
                conexao = BD.getConexao();
                comando = conexao.createStatement();

                ResultSet rs = comando.executeQuery("SELECT * FROM resultadoranking where sexo='feminino' and categoria ='infantil' and ranking like '%" + nomeRanking+ "%' order by classificacao asc");

                while (rs.next()) {

                     ResultadoRanking resultadoRanking = new ResultadoRanking(
                        rs.getInt("id"),
                        rs.getString("categoria"),
                       rs.getString("nomeAtleta"),
                         rs.getString("ranking"),
                        rs.getString("sexo"),
                        rs.getInt("classificacao"),
                        rs.getInt("pontuacao"));
                        
                      

                resultadosRanking.add(resultadoRanking);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                fecharConexao(conexao, comando);

            }

            return resultadosRanking;

        }


    public static List<ResultadoRanking> obterResultadoGeralFemininoAdultoRanking(String nomeRanking) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        List<ResultadoRanking> resultadosRanking = new ArrayList<ResultadoRanking>();
        PreparedStatement pm = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("SELECT * FROM resultadoranking where sexo='feminino' and categoria ='adulto' and ranking like '%" + nomeRanking + "%' order by classificacao asc");

            while (rs.next()) {

                 ResultadoRanking resultadoRanking = new ResultadoRanking(
                        rs.getInt("id"),
                        rs.getString("categoria"),
                       rs.getString("nomeAtleta"),
                         rs.getString("ranking"),
                        rs.getString("sexo"),
                        rs.getInt("classificacao"),
                        rs.getInt("pontuacao"));
                        
                      

                resultadosRanking.add(resultadoRanking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }

        return resultadosRanking;

    }
public static List<ResultadoRanking> obterResultadoGeralMasculinoAdultoRanking(String nomeRanking) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        List<ResultadoRanking> resultadosRanking = new ArrayList<ResultadoRanking>();
        PreparedStatement pm = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("SELECT * FROM resultadoranking where sexo='masculino' and categoria ='adulto' and ranking like '%" + nomeRanking + "%' order by classificacao asc");

            while (rs.next()) {
 ResultadoRanking resultadoRanking = new ResultadoRanking(
                        rs.getInt("id"),
                        rs.getString("categoria"),
                       rs.getString("nomeAtleta"),
                         rs.getString("ranking"),
                        rs.getString("sexo"),
                        rs.getInt("classificacao"),
                        rs.getInt("pontuacao"));
                        
                      

                resultadosRanking.add(resultadoRanking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }

        return resultadosRanking;

    }

public static List<ResultadoRanking> obterResultadoGeralMasculinoIdosoRanking(String nomeRanking) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        List<ResultadoRanking> resultadosRanking = new ArrayList<ResultadoRanking>();
        PreparedStatement pm = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("SELECT * FROM resultadoranking where sexo='masculino' and categoria ='idoso' and ranking like '%" + nomeRanking + "%' order by classificacao asc");

            while (rs.next()) {

                 ResultadoRanking resultadoRanking = new ResultadoRanking(
                        rs.getInt("id"),
                        rs.getString("categoria"),
                       rs.getString("nomeAtleta"),
                         rs.getString("ranking"),
                        rs.getString("sexo"),
                        rs.getInt("classificacao"),
                        rs.getInt("pontuacao"));
                        
                      

                resultadosRanking.add(resultadoRanking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }

        return resultadosRanking;

    }



public static List<ResultadoRanking> obterResultadoGeralFemininoIdosoRanking(String nomeRanking) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        List<ResultadoRanking> resultadosRanking = new ArrayList<ResultadoRanking>();
        PreparedStatement pm = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("SELECT * FROM resultadoranking where sexo='feminino' and categoria ='idoso' and ranking like '%" + nomeRanking + "%' order by classificacao asc");

            while (rs.next()) {

                 ResultadoRanking resultadoRanking = new ResultadoRanking(
                        rs.getInt("id"),
                        rs.getString("categoria"),
                       rs.getString("nomeAtleta"),
                         rs.getString("ranking"),
                        rs.getString("sexo"),
                        rs.getInt("classificacao"),
                        rs.getInt("pontuacao"));
                        
                      

                resultadosRanking.add(resultadoRanking);
            }      
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }

        return resultadosRanking;

    }



public static List<ResultadoRanking> obterResultadoGeralMasculinoRanking(String nomeRanking) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        List<ResultadoRanking> resultadosRanking = new ArrayList<ResultadoRanking>();
        PreparedStatement pm = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("SELECT * FROM resultadoranking where sexo='masculino' and ranking like '%" + nomeRanking + "%' order by classificacao asc");

            while (rs.next()) {

                ResultadoRanking resultadoRanking = new ResultadoRanking(
                        rs.getInt("id"),
                        rs.getString("categoria"),
                       rs.getString("nomeAtleta"),
                         rs.getString("ranking"),
                        rs.getString("sexo"),
                        rs.getInt("classificacao"),
                        rs.getInt("pontuacao"));
                        
                      

                resultadosRanking.add(resultadoRanking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }

        return resultadosRanking;

    }

public static List<ResultadoRanking> obterResultadoGeralFemininoRanking(String nomeRanking) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        List<ResultadoRanking> resultadosRanking = new ArrayList<ResultadoRanking>();
        PreparedStatement pm = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("SELECT * FROM resultadoranking where sexo='feminino' and ranking like '%" + nomeRanking + "%' order by classificacao asc");

            while (rs.next()) {

                ResultadoRanking resultadoRanking = new ResultadoRanking(
                        rs.getInt("id"),
                        rs.getString("categoria"),
                       rs.getString("nomeAtleta"),
                         rs.getString("ranking"),
                        rs.getString("sexo"),
                        rs.getInt("classificacao"),
                        rs.getInt("pontuacao"));
                        
                      

                resultadosRanking.add(resultadoRanking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }

        return resultadosRanking;

    }


   
     
     
     
}
