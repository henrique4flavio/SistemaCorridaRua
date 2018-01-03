package modelo;

import dao.ItemDAO;
import java.sql.SQLException;
import java.util.*;

public class Item {

    private String nomeItem;

    //Variaveis do banco de dados
    private int id;

    public Item(int id, String nomeItem) {

        this.nomeItem = nomeItem;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public static List<Item> obterItens()
            throws ClassNotFoundException {
        return ItemDAO.obterItens();

    }

    public void gravar() throws SQLException, ClassNotFoundException {

        ItemDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ItemDAO.alterar(this);

    }

    public void excluir() throws SQLException, ClassNotFoundException {
        ItemDAO.excluir(this);
    }

    public static Item obterItem(int id) throws ClassNotFoundException, SQLException {
        return ItemDAO.obterItem(id);
    }
}
