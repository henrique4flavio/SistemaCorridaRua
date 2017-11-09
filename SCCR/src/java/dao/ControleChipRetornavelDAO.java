package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.ControleChipRetornavel;

public class ControleChipRetornavelDAO {

    public static List<ControleChipRetornavel> obterControleChipRetornaveis() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<ControleChipRetornavel> controleChipRetornaveis = new ArrayList<ControleChipRetornavel>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from controlechipretornavel");
            
            while (rs.next()) {
                ControleChipRetornavel controleChipRetornavel = new ControleChipRetornavel(
                rs.getInt("id"), 
                rs.getString("identificadorAtleta"), 
                null);
                controleChipRetornavel.setProva_id(rs.getString("prova_id"));
                
                controleChipRetornaveis.add(controleChipRetornavel);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return controleChipRetornaveis;
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

    public static void gravar(ControleChipRetornavel controleChipRetornavel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
          
            String sql = "insert into controlechipretornavel(id,identificadorAtleta,prova_id) values(?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setInt(1, controleChipRetornavel.getId());
            comando.setString(2, controleChipRetornavel.getIdentificadorAtleta());
            comando.setString(3, controleChipRetornavel.getProva_id());

            
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {

            throw e;
        }

    }

    public static void alterar(ControleChipRetornavel controleChipRetornavel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();

            String sql = "update controlechipretornavel set identificadorAtleta=?,prova_id=? where id=?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, controleChipRetornavel.getIdentificadorAtleta());
            comando.setString(2, controleChipRetornavel.getProva_id());
            comando.setInt(3, controleChipRetornavel.getId());
            
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }

    }

    public static ControleChipRetornavel obterControleChipRetornavel(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        ControleChipRetornavel controleChipRetornavel = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from controlechipretornavel id = " + id);
            rs.first();
            controleChipRetornavel = new ControleChipRetornavel(
                    rs.getInt("id"), 
                    rs.getString("identificadorAtleta"),
                    null);
            controleChipRetornavel.setProva_id(rs.getString("prova_id"));

            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }

        return controleChipRetornavel;
    }

    public static void excluir(ControleChipRetornavel controleChipRetornavel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from controlechipretornavel where id = " + controleChipRetornavel.getId();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }
}
