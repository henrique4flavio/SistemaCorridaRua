package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getString;
import modelo.Prova;

public class ProvaDAO {
    
    public static List<Prova> obterProvas() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Prova> provas = new ArrayList<Prova>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from prova");
            while (rs.next()) {

                    Prova prova = new Prova(
                    rs.getInt("id"), 
                    rs.getString("nomeProva"), 
                    rs.getString("localLargada"),
                    rs.getString("horarioLargada"), 
                    rs.getString("dataProva"),
                    rs.getString("maxParticipantes"),
                    rs.getString("inicioInscricao"),
                    rs.getString("fimInscricao"),
                    rs.getString("faixaEtaria"), 
                    null, null);
            
                prova.setOrganizador_id(rs.getString("organizador_id"));
                prova.setRanking_id(rs.getString("ranking_id"));
                

                provas.add(prova);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return provas;
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

    public static void gravar(Prova prova) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into prova (id,nomeProva,localLargada,horarioLargada,dataProva,maxParticipantes,inicioInscricao,fimInscricao,faixaEtaria,organizador_id,ranking_id) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setInt(1, prova.getId());
            comando.setString(2, prova.getNomeProva());
            comando.setString(3, prova.getLocalLargada());
            comando.setString(4, prova.getHorarioLargada());
            comando.setString(5, prova.getDataProva());
            comando.setString(6, prova.getMaxParticipantes());
            comando.setString(7, prova.getInicioInscricao());
            comando.setString(8, prova.getFimInscricao());
            comando.setString(9, prova.getFaixaEtaria());
            comando.setString(10, prova.getOrganizador_id());
            comando.setString(11, prova.getRanking_id());
            
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {

            throw e;
        }

    }

    public static void alterar(Prova prova) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update prova set nomeProva=?,localLargada=?,horarioLargada=?,dataProva=?,maxParticipantes=?,inicioInscricao=?,fimInscricao=?,faixaEtaria=?,organizador_id=?,ranking_id=? where id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, prova.getNomeProva());
            comando.setString(2, prova.getLocalLargada());
            comando.setString(3, prova.getHorarioLargada());
            comando.setString(4, prova.getDataProva());
            comando.setString(5, prova.getMaxParticipantes());
            comando.setString(6, prova.getInicioInscricao());
            comando.setString(7, prova.getFimInscricao());
            comando.setString(8, prova.getFaixaEtaria());
            comando.setString(9, prova.getOrganizador_id());
            comando.setString(10, prova.getRanking_id());
            comando.setInt(11, prova.getId());
            
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Prova prova) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from prova where id ="
                    + prova.getId();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static Prova obterProva(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Prova prova = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select *from prova where id = " + id);
            rs.first();

            prova = new Prova(
                    rs.getInt("id"), 
                    rs.getString("nomeProva"), 
                    rs.getString("localLargada"),
                    rs.getString("horarioLargada"), 
                    rs.getString("dataProva"),
                    rs.getString("maxParticipantes"),
                    rs.getString("inicioInscricao"), 
                    rs.getString("fimInscricao"), 
                    rs.getString("faixaEtaria"), 
                    null, null);
            
                prova.setOrganizador_id(rs.getString("organizador_id"));
                prova.setRanking_id(rs.getString("ranking_id"));
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }

        return prova;
    }

}
