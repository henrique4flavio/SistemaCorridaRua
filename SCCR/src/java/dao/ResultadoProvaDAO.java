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

import modelo.Prova;
import modelo.ResultadoProva;

/**
 *
 * @author LaisAlves
 */
public class ResultadoProvaDAO {

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

    public static List<ResultadoProva> obterResultadoGeralMasculinoInfantilProva(String nomeProva) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ResultadoProva> resultados = new ArrayList<ResultadoProva>();
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

            ResultSet rs = comando.executeQuery("SELECT * FROM resultadoprovas where sexo='masculino' and categoria ='infantil' and prova like '%" + nomeProva + "%' order by classificacao asc");

            while (rs.next()) {

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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }

        return resultados;
    }

    public static List<ResultadoProva> obterResultadoGeralFemininoInfantilProva(String nomeProva) throws ClassNotFoundException, SQLException {
        

            Connection conexao = null;
            Statement comando = null;
            List<ResultadoProva> resultados = new ArrayList<ResultadoProva>();
            PreparedStatement pm = null;

            try {
                conexao = BD.getConexao();
                comando = conexao.createStatement();

                ResultSet rs = comando.executeQuery("SELECT * FROM resultadoprovas where sexo='feminino' and categoria ='infantil' and prova like '%" + nomeProva + "%' order by classificacao asc");

                while (rs.next()) {

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
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                fecharConexao(conexao, comando);

            }

            return resultados;

        }


    public static List<ResultadoProva> obterResultadoGeralFemininoAdultoProva(String nomeProva) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        List<ResultadoProva> resultados = new ArrayList<ResultadoProva>();
        PreparedStatement pm = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("SELECT * FROM resultadoprovas where sexo='feminino' and categoria ='adulto' and prova like '%" + nomeProva + "%' order by classificacao asc");

            while (rs.next()) {

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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }

        return resultados;

    }
public static List<ResultadoProva> obterResultadoGeralMasculinoAdultoProva(String nomeProva) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        List<ResultadoProva> resultados = new ArrayList<ResultadoProva>();
        PreparedStatement pm = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("SELECT * FROM resultadoprovas where sexo='masculino' and categoria ='adulto' and prova like '%" + nomeProva + "%' order by classificacao asc");

            while (rs.next()) {

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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }

        return resultados;

    }

public static List<ResultadoProva> obterResultadoGeralMasculinoIdosoProva(String nomeProva) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        List<ResultadoProva> resultados = new ArrayList<ResultadoProva>();
        PreparedStatement pm = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("SELECT * FROM resultadoprovas where sexo='masculino' and categoria ='idoso' and prova like '%" + nomeProva + "%' order by classificacao asc");

            while (rs.next()) {

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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }

        return resultados;

    }



public static List<ResultadoProva> obterResultadoGeralFemininoIdosoProva(String nomeProva) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        List<ResultadoProva> resultados = new ArrayList<ResultadoProva>();
        PreparedStatement pm = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("SELECT * FROM resultadoprovas where sexo='feminino' and categoria ='idoso' and prova like '%" + nomeProva + "%' order by classificacao asc");

            while (rs.next()) {

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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }

        return resultados;

    }



public static List<ResultadoProva> obterResultadoGeralMasculinoProva(String nomeProva) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        List<ResultadoProva> resultados = new ArrayList<ResultadoProva>();
        PreparedStatement pm = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("SELECT * FROM resultadoprovas where sexo='masculino' and prova like '%" + nomeProva + "%' order by classificacao asc");

            while (rs.next()) {

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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }

        return resultados;

    }

public static List<ResultadoProva> obterResultadoGeralFemininoProva(String nomeProva) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        List<ResultadoProva> resultados = new ArrayList<ResultadoProva>();
        PreparedStatement pm = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("SELECT * FROM resultadoprovas where sexo='feminino' and prova like '%" + nomeProva + "%' order by classificacao asc");

            while (rs.next()) {

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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }

        return resultados;

    }




}
