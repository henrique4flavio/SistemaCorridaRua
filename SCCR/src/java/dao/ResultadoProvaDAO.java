package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            ResultSet rs = comando.executeQuery("select * from resultadoprova");
            while (rs.next()) {

                ResultadoProva resultadoProva = new ResultadoProva(
                rs.getInt("id"), 
                rs.getString("resultadoClassificacao"),
                rs.getString("nomeProva"));

                
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
    public static void gravar(ResultadoProva resultadoProva) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            // caso de herança tem qeu fazer para as duas classes .
            String sql = "insert into resultadoprova (resultadoClassificacao,nomeProva,id) values(?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, resultadoProva.getResultadoClassificacao());
            comando.setInt(2, resultadoProva.getId());
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

    public static void alterar(ResultadoProva resultadoProva) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update resultadoprova set resultadoClassificacao=?,nomeProva=? where id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, resultadoProva.getResultadoClassificacao());
            comando.setInt(2, resultadoProva.getId());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(ResultadoProva resultadoProva) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from resultadoprova where id ="
                    + resultadoProva.getId();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static ResultadoProva obterResultadoProva(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        ResultadoProva resultadoProva = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * resultadoprova id = " + id);
            rs.first();

            resultadoProva = new ResultadoProva(
                    rs.getInt("id"),
                    rs.getString("resultadoClassificacao"),
                    rs.getString("nomeProva"));
            // para chave estrangeira.
            //curso.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador"))
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }

        return resultadoProva;
    }

}


