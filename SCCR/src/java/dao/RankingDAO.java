package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getString;
import modelo.Ranking;

public class RankingDAO {

    public static List<Ranking> obterRankings() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Ranking> rankings = new ArrayList<Ranking>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from ranking");
            while (rs.next()) {

                Ranking ranking = new Ranking(rs.getInt("id"), rs.getString("nome"));

                rankings.add(ranking);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return rankings;
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

    public static void gravar(Ranking ranking) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            // caso de herança tem qeu fazer para as duas classes .
            String sql = "insert into ranking (nome,id)" + "values(?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, ranking.getNome());
            comando.setInt(2, ranking.getId());
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

    public static void alterar(Ranking ranking) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update ranking set nome= ? where id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, ranking.getNome());
            comando.setInt(2, ranking.getId());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Ranking ranking) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from ranking where id ="
                    + ranking.getId();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static Ranking obterRanking(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Ranking ranking = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * ranking id = " + id);
            rs.first();

            ranking = new Ranking(rs.getInt("id"),
                    rs.getString("nome"));
            // para chave estrangeira.
            //curso.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador"))
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }

        return ranking;
    }

}
