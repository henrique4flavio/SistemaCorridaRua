
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Boleto;
import modelo.Prova;
import modelo.Inscricao;


public class BoletoDAO {

    public static List<Boleto> obterBoletos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Boleto> Boletos = new ArrayList<>();

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from boleto");
            while (rs.next()) {
                Boleto boleto = new Boleto(
                        rs.getInt("id"),
                        rs.getString("codigo_barra"),
                        rs.getString("data_emissao"),
                        rs.getString("data_vencimento"),
                        rs.getString("nome_titular"),
                        rs.getString("cpf_titular"),
                        null,
                        null);
                boleto.setInscricao_id(rs.getInt("inscricao_id"));
                boleto.setInscricao(Inscricao.obterInscricao(boleto.getInscricao_id()));
                boleto.setInscricaoProva_id(rs.getInt("inscricao_prova_id"));
                boleto.setInscricaoProva(Prova.obterProva(boleto.getInscricaoProva_id()));
                Boletos.add(boleto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return Boletos;
    }

    public static void gravar(Boleto boleto) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO boleto (codigo_barra, data_emissao, data_vencimento, nome_titular, cpf_titular, inscricao_id, inscricao_corrida_id) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, boleto.getCodigoBarra());
            comando.setString(2, boleto.getDataEmissao());
            comando.setString(3, boleto.getDataVencimento());
            comando.setString(4, boleto.getNomeTitular());
            comando.setString(5, boleto.getCpfTitular());
            comando.setInt(6, boleto.getInscricao_id());
            comando.setInt(7, boleto.getInscricaoProva_id());

            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(Boleto boleto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE boleto SET codigo_barra = ?, data_emissao = ?, data_vencimento = ?, nome_titular = ?, cpf_titular = ?, inscricao_id = ?, inscricao_corrida_id = ? WHERE id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, boleto.getCodigoBarra());
            comando.setString(2, boleto.getDataEmissao());
            comando.setString(3, boleto.getDataVencimento());
            comando.setString(4, boleto.getNomeTitular());
            comando.setString(5, boleto.getCpfTitular());
            comando.setInt(6, boleto.getInscricao_id());
            comando.setInt(7, boleto.getInscricaoProva_id());
            comando.setInt(8, boleto.getId());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Boleto boleto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "DELETE FROM boleto WHERE id = " + boleto.getId();
            comando.execute(stringSQL);

        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static Boleto obterBoleto(int id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Boleto boleto = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM boleto WHERE id = " + id);
            rs.first();
            boleto = new Boleto(
                    rs.getInt("id"),
                    rs.getString("codigo_barra"),
                    rs.getString("data_emissao"),
                    rs.getString("data_vencimento"),
                    rs.getString("nome_titular"),
                    rs.getString("cpf_titular"),
                    null,
                    null);
            boleto.setInscricao_id(rs.getInt("inscricao_id"));
            boleto.setInscricaoProva_id(rs.getInt("inscricao_corrida_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return boleto;
    }

    public static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }

            if (comando != null) {
                conexao.close();
            }

        } catch (SQLException e) {

        }
    }
}