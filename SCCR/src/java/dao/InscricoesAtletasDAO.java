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
import modelo.InscricoesAtletas;

/**
 *
 * @author LaisAlves
 */
public class InscricoesAtletasDAO {
    
    
    public static List<InscricoesAtletas> obterInscricoes(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<InscricoesAtletas> inscricoes = new ArrayList<InscricoesAtletas>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select numeroPeito,prova_id from inscricao where atleta_id ="+id);
            while (rs.next()) {

                InscricoesAtletas inscricao = new InscricoesAtletas(
                        
                       
                       
                      rs.getInt("numeroPeito"),
                       rs.getInt("prova_id"));

              
                
                inscricoes.add(inscricao);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return inscricoes;
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
