package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Administrador;
import modelo.Inscricao;

public class InscricaoDAO {

    public static List<Inscricao> obterInscricoes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Inscricao> inscricoes = new ArrayList<Inscricao>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from inscricao");
            while (rs.next()) {

                Inscricao inscricao = new Inscricao(rs.getInt("id"), rs.getString("dataInscricao"),
                        rs.getInt("numeroInscricao"),
                        rs.getString("formaPagamento"), null, null, null, null, null);
                inscricao.setKit_id(rs.getString("kit_id"));
                inscricao.setControle_chip_retornavel_id(rs.getString("controle_chip_retornavel_id"));
                inscricao.setProva_ID(rs.getString("prova_id"));
                inscricao.setPercurso_ID(rs.getString("percurso_id"));
                inscricao.setAtleta_ID(rs.getString("atleta_id"));

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

    public static void gravar(Inscricao inscricao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            // caso de herança tem qeu fazer para as duas classes .
            String sql = "insert into inscricao (id,dataInscricao,numeroInscricao,formaPagamento,kit_id,controle_chip_retornavel_id,prova_id,percurso_id,atleta_id)" + "values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setInt(1, inscricao.getId());
            comando.setString(2, inscricao.getDataInscricao());
            comando.setInt(3, inscricao.getNumeroInscricao());
            comando.setString(4, inscricao.getFormaPagamento());
            comando.setString(5, inscricao.getKit_id());
            comando.setString(6, inscricao.getControle_chip_retornavel_id());
            comando.setString(7, inscricao.getProva_id());
            comando.setString(8, inscricao.getPercurso_id());
            comando.setString(9, inscricao.getAtleta_id());
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

    public static void alterar(Inscricao inscricao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update inscricao set dataInscricao= ?,numeroInscricao=?,formaPagamento=?,kit_id=?,controle_chip_retornavel_id=?,prova_id=?,percurso_id=?,atleta_id=? where id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, inscricao.getDataInscricao());
            comando.setInt(2, inscricao.getNumeroInscricao());
            comando.setString(3, inscricao.getFormaPagamento());
            comando.setString(4, inscricao.getKit_id());
            comando.setString(5, inscricao.getControle_chip_retornavel_id());
            comando.setString(6, inscricao.getProva_id());
            comando.setString(7, inscricao.getPercurso_id());
            comando.setString(8, inscricao.getAtleta_id());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Inscricao inscricao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from inscricao where id ="
                    + inscricao.getId();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static Inscricao obterInscricao(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Inscricao inscricao = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select *from inscricao id = " + id);
            rs.first();

            inscricao = new Inscricao(rs.getInt("id"), rs.getString("dataInscricao"),
                    rs.getInt("numeroInscricao"),
                    rs.getString("formaPagamento"), null, null, null, null, null);
            inscricao.setKit_id(rs.getString("kit_id"));
            inscricao.setControle_chip_retornavel_id(rs.getString("controle_chip_retornavel_id"));
            inscricao.setProva_ID(rs.getString("prova_id"));
            inscricao.setPercurso_ID(rs.getString("percurso_id"));
            inscricao.setAtleta_ID(rs.getString("atleta_id"));

            // para chave estrangeira.
            //curso.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador"))
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }

        return inscricao;
    }

}
