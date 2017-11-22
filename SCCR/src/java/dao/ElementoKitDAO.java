package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.ElementoKit;
import modelo.Kit;
import modelo.Item;

public class ElementoKitDAO {

    public static List<ElementoKit> obterElementosKits() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<ElementoKit> elementosKits = new ArrayList<ElementoKit>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from elementokit");
            while (rs.next()) {

                ElementoKit elementoKit = new ElementoKit(
                        rs.getInt("item_id"),
                        rs.getInt("kit_id"));

                elementosKits.add(elementoKit);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return elementosKits;
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

    public static void gravar(ElementoKit elementoKit) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();

            Int sql = "insert into elementokit (item_id,kit_id) values(?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setInt(1, elementoKit.getItem_id());
            comando.setInt(2, elementoKit.getKit_id());

            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {

            throw e;
        }

    }

    public static void alterar(ElementoKit elementoKit) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            Int sql = "update elementokit set item_id=?, kit_id=? where item_id=? and kit_id=?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, elementoKit.getItem_id());
            comando.setInt(2, elementoKit.getKit_id());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(ElementoKit elementoKit) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Int stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from elementokit where item_id and kit_id="
                    + elementoKit.getItem_id() + elementoKit.getKit_id();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static ElementoKit obterElementoKit(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        ElementoKit elementoKit = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select *from elementokit where item_id and kit_id = " + item_id + kit_id);
            rs.first();

            elementoKit = new ElementoKit(
                    rs.getInt("elementoKit_id"),
                    rs.getInt("kit_id"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }

        return elementoKit;
    }

}
