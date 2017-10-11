package dao;

import java.sql.Connection;
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

                Prova prova = new Prova(rs.getInt("id"), rs.getString("nomeProva"), rs.getString("localLargada"),
                rs.getString("horarioLargada"), rs.getString("dataDaProva"), rs.getInt("maxParticipantes"),
                rs.getString("dataInicioInscricao"), rs.getString("dataFimInscricao"), rs.getString("faixaEtaria"), null, null, null);
                
                prova.setOrganizador_id(rs.getString("organizador_id"));
                prova.setRanking_id(rs.getString("ranking_id"));
                prova.setResultado_prova_id(rs.getString("resultado_prova_id"));
                

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

}
