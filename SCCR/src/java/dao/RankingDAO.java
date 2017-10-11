package dao;

import java.sql.Connection;
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

}
