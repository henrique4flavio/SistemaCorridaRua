
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            ResultSet rs = comando.executeQuery("select * from percurso");
            while (rs.next()) {

                Percurso percurso = new Percurso(
                rs.getInt("id"), 
                rs.getString("nome"), 
                rs.getString("distancia"),
                rs.getString("faixaEtaria"), 
                null);
                      
                percurso.setProva_id(rs.getString("prova_id"));
            
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
    public static void gravar(Percurso percurso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            // caso de herança tem que fazer para as duas classes .
            String sql = "insert into percurso (id, nome, distancia, faixaEtaria, prova_id) values(?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setInt(1, percurso.getId());
            comando.setString(2, percurso.getNome());
            comando.setString(3, percurso.getDistancia());
            comando.setString(4, percurso.getFaixaEtaria());
            comando.setString(5, percurso.getProva_id());
            
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {

            throw e;
        }

    }

    public static void alterar(Percurso percurso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update percurso set nome=?,distancia=?,faixaEtaria=?,prova_id=? where id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, percurso.getNome());
            comando.setString(2, percurso.getDistancia());
            comando.setString(3, percurso.getFaixaEtaria());
            comando.setString(4, percurso.getProva_id());
            comando.setInt(5, percurso.getId());
            
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Percurso percurso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from percurso where id ="
                    + percurso.getId();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static Percurso obterPercurso(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Percurso percurso = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * percurso where id = " + id);
            rs.first();

            percurso = new Percurso(rs.getInt("id"), rs.getString("nome"), 
                rs.getString("distancia"), rs.getString("faixaEtaria"), null);
                      
                        percurso.setProva_id(rs.getString("prova_id"));
            // para chave estrangeira.
            //curso.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador"))
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }

        return percurso;
    }

}
    

