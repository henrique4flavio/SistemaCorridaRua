package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Administrador;
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

}
