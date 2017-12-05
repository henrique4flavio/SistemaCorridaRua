package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Administrador;
import modelo.Inscricao;

public class InscricaoDAO {

    public static List<Inscricao> obterInscricoes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Inscricao> inscricoes = new ArrayList<Inscricao>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from inscricao");
            while (rs.next()) {

                Inscricao inscricao = new Inscricao(
                rs.getInt("numeroPeito"), 
                rs.getString("total"),
                rs.getString("formaPagamento"), 
                null, null, null);
                
                inscricao.setKit_id(rs.getString("kit_id"));
                inscricao.setProva_id(rs.getString("prova_id"));
                inscricao.setPercurso_id(rs.getString("percurso_id"));
                

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

    public static void gravar(Inscricao inscricao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into inscricao (numeroPeito,total,formaPagamento,kit_id,prova_id,percurso_id,atleta_id) values(?,??????)";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setInt(1, inscricao.getNumeroPeito());
            comando.setString(2, inscricao.getTotal());
            comando.setString(3, inscricao.getFormaPagamento());
            comando.setString(4, inscricao.getKit_id());
            comando.setString(5, inscricao.getProva_id());
            comando.setString(6, inscricao.getPercurso_id());
            comando.setString(7, inscricao.getAtleta_id());
           
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {

            throw e;
        }

    }

    public static void alterar(Inscricao inscricao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update inscricao set total=?,formaPagamento=?,kit_id=?,prova_id=?,percurso_id=?,atleta_id=? where numeroPeito = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, inscricao.getTotal());
            comando.setString(2, inscricao.getFormaPagamento());
            comando.setString(3, inscricao.getKit_id());
            comando.setString(4, inscricao.getProva_id());
            comando.setString(5, inscricao.getPercurso_id());
            
            comando.setInt(6, inscricao.getNumeroPeito());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Inscricao inscricao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from inscricao where id ="
                    + inscricao.getNumeroPeito();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static Inscricao obterInscricao(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Inscricao inscricao = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from inscricao where id = " + id);
            rs.first();

            inscricao = new Inscricao(rs.getInt("numeroPeito"),
                    rs.getString("formaPagamento"),
                    rs.getString("total"), null, null, null);
            inscricao.setKit_id(rs.getString("kit_id"));
            inscricao.setProva_id(rs.getString("prova_id"));
            inscricao.setPercurso_id(rs.getString("percurso_id"));
           
        
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }

        return inscricao;
    }

}
