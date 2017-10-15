package modelo;

import dao.ItemDAO;
import java.util.*;

public class Item {

    private String nomeItem;

    //Variaveis do banco de dados
    private int id;
  
    public  Item(int id,String nomeItem) {

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

    public void cadastrarItem() {

    }

    public void alterarItem() {

    }

    public void excluitItem() {

    }

    public Item consultarItem() {

        return null;
    }
   public static List<Item> obterItem()
            throws ClassNotFoundException {
        return ItemDAO.obterItens();

}
}
