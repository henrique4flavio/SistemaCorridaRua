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
                        
                        rs.getInt("id"),
                        rs.getInt("numeroPeito"),
                        rs.getBoolean("pago"),
                        rs.getBoolean("kitRetirado"),
                        rs.getString("formaPagamento"),
                        rs.getString("total"),
                        rs.getString("categoria"),
                        null, null, null, null);

                inscricao.setKit_id(rs.getString("kit_id"));
                inscricao.setProva_id(rs.getString("prova_id"));
                inscricao.setPercurso_id(rs.getString("percurso_id"));
                inscricao.setPercurso_id(rs.getString("atleta_id"));

                inscricoes.add(inscricao);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return inscricoes;
    }
    
    public static List<Inscricao> obterInscricoes(int prova_id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Inscricao> inscricoes = new ArrayList<Inscricao>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from inscricao WHERE kit_prova_id = " + prova_id);
            while (rs.next()) {

                Inscricao inscricao = new Inscricao(
                        
                        rs.getInt("id"),
                        rs.getInt("numeroPeito"),
                        rs.getBoolean("pago"),
                        rs.getBoolean("kitRetirado"),
                        rs.getString("formaPagamento"),
                        rs.getString("total"),
                        rs.getString("categoria"),
                        null, null, null, null);

                inscricao.setKit_id(rs.getString("kit_id"));
                inscricao.setProva_id(rs.getString("prova_id"));
                inscricao.setPercurso_id(rs.getString("percurso_id"));
                inscricao.setPercurso_id(rs.getString("atleta_id"));

                inscricoes.add(inscricao);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return inscricoes;
    }
    
    public static List<Inscricao> obterInscricoesAtleta(int id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Inscricao> inscricoes = new ArrayList<Inscricao>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from inscricao WHERE atleta_id = " + id);
            while (rs.next()) {

                Inscricao inscricao = new Inscricao(
                        
                        rs.getInt("id"),
                        rs.getInt("numeroPeito"),
                        rs.getBoolean("pago"),
                        rs.getBoolean("kitRetirado"),
                        rs.getString("formaPagamento"),
                        rs.getString("total"),
                        rs.getString("categoria"),
                        null, null, null, null);

                inscricao.setKit_id(rs.getString("kit_id"));
                inscricao.setProva_id(rs.getString("prova_id"));
                inscricao.setPercurso_id(rs.getString("percurso_id"));
                inscricao.setPercurso_id(rs.getString("atleta_id"));

                inscricoes.add(inscricao);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return inscricoes;
    }
     public static List<Inscricao> obterInscricoesPagas(int prova_id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Inscricao> inscricoes = new ArrayList<>();

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM inscricao WHERE kit_prova_id = " + prova_id
                    + " and pago =" + true + " and kit_retirado = " + false);
            while (rs.next()) {

                Inscricao inscricao = new Inscricao(
                        rs.getInt("id"),
                        rs.getInt("numeroPeito"),
                        rs.getBoolean("pago"),
                        rs.getBoolean("kitRetirado"),
                        rs.getString("formaPagamento"),
                        rs.getString("total"),
                        rs.getString("categoria"),
                        null, null, null, null);
                
                inscricao.setKit_id(rs.getString("kit_id"));
                inscricao.setProva_id(rs.getString("prova_id"));
                inscricao.setPercurso_id(rs.getString("percurso_id"));
                inscricao.setPercurso_id(rs.getString("atleta_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return inscricoes;
    }

    public static List<Inscricao> obterInscricoesNaoPagas(int prova_id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Inscricao> inscricoes = new ArrayList<>();

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM inscricao WHERE kit_prova_id = " + prova_id
                    + " and pago =" + false);
            while (rs.next()) {

                Inscricao inscricao = new Inscricao(
                        rs.getInt("id"),
                        rs.getInt("numeroPeito"),
                        rs.getBoolean("pago"),
                        rs.getBoolean("kitRetirado"),
                        rs.getString("formaPagamento"),
                        rs.getString("total"),
                        rs.getString("categoria"),
                        null,
                        null,
                        null,
                        null);
                inscricao.setKit_id(rs.getString("kit_id"));
                inscricao.setProva_id(rs.getString("prova_id"));
                inscricao.setPercurso_id(rs.getString("percurso_id"));
                inscricao.setPercurso_id(rs.getString("atleta_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return inscricoes;
    }
    
    


    public static void gravar(Inscricao inscricao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();

            String sql = "insert into inscricao (id, numeroPeito, pago, kitRetirado, formaPagamento, categoria, total, kit_id, prova_id, percurso_id, atleta_id) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setInt(1, inscricao.getId());
            comando.setInt(2, inscricao.getNumeroPeito());
            comando.setBoolean(3, inscricao.isPago());
            comando.setBoolean(4, inscricao.isKitRetirado());
            comando.setString(5, inscricao.getCategoria());
            comando.setString(6, inscricao.getTotal());
            comando.setString(7, inscricao.getFormaPagamento());
            comando.setString(8, inscricao.getKit_id());
            comando.setString(9, inscricao.getProva_id());
            comando.setString(10, inscricao.getPercurso_id());
            comando.setString(11, inscricao.getAtleta_id());
           
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

            String sql = "update inscricao set numeroPeito=?,pago=?,kitRetirado=?,total=?,formaPagamento=?,categoria=?,kit_id=?,prova_id=?,percurso_id=?,atleta_id=? where id  = ?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setInt(1, inscricao.getNumeroPeito());
            comando.setBoolean(2, inscricao.isPago());
            comando.setBoolean(3, inscricao.isKitRetirado());
            comando.setString(4, inscricao.getTotal());
            comando.setString(5, inscricao.getFormaPagamento());
            comando.setString(6, inscricao.getCategoria());
            comando.setString(7, inscricao.getKit_id());
            comando.setString(8, inscricao.getProva_id());
            comando.setString(9, inscricao.getPercurso_id());
            comando.setString(10, inscricao.getAtleta_id());
            comando.setInt(11, inscricao.getId());

           
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
            stringSQL = "DELETE FROM inscricao WHERE id = " + inscricao.getId() + " AND prova_id = " + inscricao.getProva_id();
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
            ResultSet rs = comando.executeQuery("select * from inscricao where numeroPeito = " + id);
            rs.first();

            inscricao = new Inscricao(
                        rs.getInt("id"),
                        rs.getInt("numeroPeito"),
                        rs.getBoolean("pago"),
                        rs.getBoolean("kitRetirado"),
                        rs.getString("formaPagamento"),
                        rs.getString("total"),
                        rs.getString("categoria"), null, null, null, null);


            inscricao.setKit_id(rs.getString("kit_id"));
            inscricao.setProva_id(rs.getString("prova_id"));
            inscricao.setPercurso_id(rs.getString("percurso_id"));
            inscricao.setPercurso_id(rs.getString("atleta_id"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }

        return inscricao;
    }

     public static Inscricao obterUltimaInscricaoAtleta(int atleta_id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Inscricao inscricao = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM inscricao WHERE atleta_id = " + atleta_id);
            rs.last();
            inscricao = new Inscricao(
                        rs.getInt("id"),
                        rs.getInt("numeroPeito"),
                        rs.getBoolean("pago"),
                        rs.getBoolean("kitRetirado"),
                        rs.getString("formaPagamento"),
                        rs.getString("total"),
                        rs.getString("categoria"), null, null, null, null);


            inscricao.setKit_id(rs.getString("kit_id"));
            inscricao.setProva_id(rs.getString("prova_id"));
            inscricao.setPercurso_id(rs.getString("percurso_id"));
            inscricao.setPercurso_id(rs.getString("atleta_id"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return inscricao;
    }
     public static void retirarKit(Inscricao inscricao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE inscricao SET kit_retirado = ? WHERE id = ?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setBoolean(1, inscricao.isKitRetirado());
            comando.setInt(2, inscricao.getId());

            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
     public static void pagarInscricao(Inscricao inscricao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE inscricao SET pago = ? WHERE id = ?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setBoolean(1, inscricao.isPago());
            comando.setInt(2, inscricao.getId());

            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Inscricao> pesquisaInscricao(String numero) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Inscricao> inscricoes = new ArrayList<Inscricao>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from inscricao where numeroPeito like '%" + numero + "%'");
            while (rs.next()) {
                Inscricao inscricao = new Inscricao(
                        rs.getInt("id"),
                        rs.getInt("numeroPeito"),
                        rs.getBoolean("pago"),
                        rs.getBoolean("kitRetirado"),
                        rs.getString("formaPagamento"),
                        rs.getString("total"),
                        rs.getString("categoria"),
                        null, null, null, null);

                inscricao.setKit_id(rs.getString("kit_id"));
                inscricao.setProva_id(rs.getString("prova_id"));
                inscricao.setPercurso_id(rs.getString("percurso_id"));
                inscricao.setPercurso_id(rs.getString("atleta_id"));
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
