
package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.ControleChipRetornavel;

public class ControleChipRetornavelDAO {
    public static List<ControleChipRetornavel> obterControleChipRetornaveis() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<ControleChipRetornavel> controleChipRetornaveis = new ArrayList<ControleChipRetornavel>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from controle_chip_retornavel");
            while (rs.next()) {

                ControleChipRetornavel controleChipRetornavel = new ControleChipRetornavel
                (rs.getInt("identificadorAtleta"), null);
                controleChipRetornavel.setProva_ID(rs.getString("prova_ID"));
                        
             

                controleChipRetornaveis.add(controleChipRetornavel);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return controleChipRetornaveis;
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
    
   