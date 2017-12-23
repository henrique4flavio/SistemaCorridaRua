/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
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
    public static List<ResultadoProva> obterResultadoGeralProva(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ResultadoProva> resultados = new ArrayList<ResultadoProva>();
 
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("select r.id,r.classificacao,r.id_atleta,r.tempo,r.numeroPeito,r.id_prova from resultadoprovas r join prova p on p.id = r.id_prova  join atleta a on a.id = r.id_atleta  and p.id ="+id+" order by classificacao ASC");
            rs.next();

            ResultadoProva resultadoProva = new ResultadoProva(
                    rs.getInt("id"),
                    rs.getInt("classificacao"),
                    rs.getString("tempo"),
                    null, null, null);

            resultadoProva.setId_atleta(rs.getString("id_atleta"));
            resultadoProva.setNumeroPeito(rs.getString("numeroPeito"));
            resultadoProva.setId_prova(rs.getString("id_prova"));

            resultados.add(resultadoProva);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return resultados;
    }

    public static List<ResultadoProva> obterResultadoGeralMasculinoProva(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ResultadoProva> resultados = new ArrayList<ResultadoProva>();
 
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("select r.id,r.classificacao,r.id_atleta,r.tempo,r.numeroPeito,r.id_prova from resultadoprovas r join prova p on p.id = r.id_prova  join atleta a on a.id = r.id_atleta and a.sexo='Masculino' and p.id ="+id+" order by classificacao ASC");
            rs.next();

            ResultadoProva resultadoProva = new ResultadoProva(
                    rs.getInt("id"),
                    rs.getInt("classificacao"),
                    rs.getString("tempo"),
                    null, null, null);

            resultadoProva.setId_atleta(rs.getString("id_atleta"));
            resultadoProva.setNumeroPeito(rs.getString("numeroPeito"));
            resultadoProva.setId_prova(rs.getString("id_prova"));

            resultados.add(resultadoProva);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return resultados;
    }

    public static List<ResultadoProva> obterResultadoGeralFemininoProva(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ResultadoProva> resultados = new ArrayList<ResultadoProva>();
 
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("select r.id,r.classificacao,r.id_atleta,r.tempo,r.numeroPeito,r.id_prova from resultadoprovas r join prova p on p.id = r.id_prova  join atleta a on a.id = r.id_atleta and a.sexo='Feminino' and p.id ="+id+" order by classificacao ASC");
            rs.next();

            ResultadoProva resultadoProva = new ResultadoProva(
                    rs.getInt("id"),
                    rs.getInt("classificacao"),
                    rs.getString("tempo"),
                    null, null, null);

            resultadoProva.setId_atleta(rs.getString("id_atleta"));
            resultadoProva.setNumeroPeito(rs.getString("numeroPeito"));
            resultadoProva.setId_prova(rs.getString("id_prova"));

            resultados.add(resultadoProva);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return resultados;
    }
    
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

}
