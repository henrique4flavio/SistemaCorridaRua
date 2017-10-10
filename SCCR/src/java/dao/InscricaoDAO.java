package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Inscricao;

public class InscricaoDAO {

    public static List<Inscricao> obterInscricoes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Inscricao> inscricoes = new ArrayList<Inscricao>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from inscricao");
            while (rs.next()) {

                Inscricao inscricao = new Inscricao(rs.getString("dataInscricao"), rs.getInt("numeroInscricao"),
                        rs.getString("formaPagamento"), null, null, null, null, null);
                inscricao.setKit_ID(rs.getString("kit_ID"));
                inscricao.setControle_chip_retornavel_ID(rs.getString("controle_chip_retornavel_ID"));
                inscricao.setProva_ID(rs.getString("prova_ID"));
                inscricao.setPercurso_ID(rs.getString("percurso_ID"));
                inscricao.setAtleta_ID(rs.getString("atleta_ID"));

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


