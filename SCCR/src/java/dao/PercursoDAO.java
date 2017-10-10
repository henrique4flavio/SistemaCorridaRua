
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getString;
import modelo.Percurso;

public class PercursoDAO {
    
    
    
     public static List<Percurso> obterPercursos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Percurso> percursos = new ArrayList<Percurso>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from percurso");
            while (rs.next()) {

                Percurso percurso = new Percurso(rs.getString("nome"), 
                rs.getDouble("distancia"), rs.getInt("faixaEtaria"), null);
                      
                        percurso.setProva_ID(rs.getString("prova_ID"));
            
                percursos.add(percurso);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return percursos;
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
    

