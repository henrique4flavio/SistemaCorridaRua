package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Item;

public class ItemDAO {

    public static List<Item> obterItens() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Item> itens = new ArrayList<Item>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select*from item");
            while (rs.next()) {

                Item item = new Item(
                rs.getString("nome"));
                
                
                itens.add(item);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return itens;
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
