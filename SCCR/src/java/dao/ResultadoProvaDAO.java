package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getString;
import modelo.ResultadoProva;

public class ResultadoProvaDAO {

    public static List<ResultadoProva> obterResultadoProvas() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<ResultadoProva> resultadoProvas = new ArrayList<ResultadoProva>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from resultado_prova");
            while (rs.next()) {

                ResultadoProva resultadoProva = new ResultadoProva(rs.getString("resultadoClassificacao"));

                
                resultadoProvas.add(resultadoProva);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return resultadoProvas;
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
