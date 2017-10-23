package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Lote;

public class LoteDAO {

    public static List<Lote> obterLotes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Lote> lotes = new ArrayList<Lote>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from lote");
            while (rs.next()) {
                Lote lote = new Lote(rs.getInt("id"), rs.getString("dataInicio"),
                        rs.getString("dataFim"), rs.getString("valor"),
                        rs.getString("identificacao"), null);

                lote.setProva_id(rs.getString("prova_id"));

                lotes.add(lote);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return lotes;
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

    public static void gravar(Lote lote) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            // caso de herança tem qeu fazer para as duas classes .
            String sql = "insert into lote (id, identificacao, dataInicio , dataFim , valor, prova_id)" + "values(?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, lote.getId());
            comando.setString(2, lote.getIdentificacao());
            comando.setString(3, lote.getDataInicio());
            comando.setString(4, lote.getDataFim());
            comando.setString(5, lote.getValor());
            comando.setString(6, lote.getprova_id());

            // comando caso tenha um campo opcional,chave estrngeira seja vazia.
            /*
        if(curso.setNull(6,Types.null));
        else{
                comando.set(6,curso.getCoordenador().getMatricula());
        }
        comando.setInt(6,curso.getCodCurso());
             */
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {

            throw e;
        }

    }

    public static void alterar(Lote lote) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update lote set identificacao=?, dataInicio=?, dataFim=?, valor=?, prova_id=? where id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, lote.getIdentificacao());
            comando.setString(2, lote.getDataInicio());
            comando.setString(3, lote.getDataFim());
            comando.setString(4, lote.getValor());
            comando.setString(5, lote.getprova_id());
            comando.setInt(6, lote.getId());
            
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Lote lote) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from lote where id ="
                    + lote.getId();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static Lote obterLote(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Lote lote = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from id = " + id);
            rs.next();

            lote = new Lote(rs.getInt("id"),
                    rs.getString("dataInicio"),
                    rs.getString("dataFim"), rs.getString("valor"),
                    rs.getString("identificacao"), null);

            lote.setProva_id(rs.getString("prova_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }

        return lote;
    }

}
