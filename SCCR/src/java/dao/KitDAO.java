package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Kit;


public class KitDAO {

    public static List<Kit> obterKits() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Kit> kits = new ArrayList<Kit>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from kit");
            while (rs.next()) {

                Kit kit = new Kit(
                        rs.getInt("id"), 
                        rs.getString("nomeKit"));

                
                kits.add(kit);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return kits;
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
    
    public static void gravar(Kit kit) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            // caso de herança tem qeu fazer para as duas classes .
            String sql = "insert into kit (id, nomeKit) values(?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, kit.getId());
            comando.setString(2, kit.getNomeKit());
           
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {

            throw e;
        }

    }

    public static void alterar(Kit kit) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update kit set nomeKit=? where id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, kit.getNomeKit());
            comando.setInt(2, kit.getId());
 
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Kit kit) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from kit where id ="
                    + kit.getId();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static Kit obterKit(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Kit kit = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from kit id = " + id);
            rs.next();

            kit = new Kit(rs.getInt("id"), rs.getString("nomeKit"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }

        return kit;
    }

}

