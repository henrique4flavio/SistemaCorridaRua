package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getString;
import modelo.Organizador;

public class OrganizadorDAO {

    public static List<Organizador> obterOrganizadores() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Organizador> organizadores = new ArrayList<Organizador>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from organizador");
            while (rs.next()) {

                Organizador organizador = new Organizador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("senha"),
                        rs.getString("login"),
                        rs.getString("email"),
                        null);

                organizador.setAdministrador_id(rs.getString("administrador_id"));

                organizadores.add(organizador);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return organizadores;
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

    public static void gravar(Organizador organizador) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
          
            String sql = "insert into organizador(id,nome,senha,login,email,administrador_id) values(?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setInt(1, organizador.getId());
            comando.setString(2, organizador.getNome());
            comando.setString(3, organizador.getSenha());
            comando.setString(4, organizador.getSenha());
            comando.setString(5, organizador.getEmail());
            comando.setString(6, organizador.getAdministrador_id());
            
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {

            throw e;
        }

    }

    public static void alterar(Organizador organizador) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update organizador set nome=?,senha=?,login=?,email=?, administrador_id=? where id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, organizador.getNome());
            comando.setString(2, organizador.getSenha());
            comando.setString(3, organizador.getLogin());
            comando.setString(4, organizador.getEmail());
            comando.setString(5, organizador.getAdministrador_id());
            comando.setInt(6, organizador.getId());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Organizador organizador) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from organizador where id ="
                    + organizador.getId();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static Organizador obterOrganizador(int id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Organizador organizador = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from organizador where id = " + id);
            rs.next();

            organizador = new Organizador (rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("senha"),
                    rs.getString("login"),
                    rs.getString("email"), null);
            organizador.setAdministrador_id(rs.getString("administrador_id"));
           
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }

        return organizador;
    }

}
