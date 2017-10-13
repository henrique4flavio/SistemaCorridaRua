package modelo;

import dao.ItemDAO;
import java.util.*;

public class Item {

    private String nomeItem;
<<<<<<< HEAD
    //Variaveis do banco de dados
    private int id;
    
    public Item(int id, String nomeItem) {
=======
    private int id;
 public  Item(int id,String nomeItem) {
>>>>>>> d9750e82da41a2dc37d39e5c59740e3d5346ec47
        this.nomeItem = nomeItem;
        this.id = id;
    }

<<<<<<< HEAD
=======

>>>>>>> d9750e82da41a2dc37d39e5c59740e3d5346ec47
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
<<<<<<< HEAD
    
    
=======

   
>>>>>>> d9750e82da41a2dc37d39e5c59740e3d5346ec47
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
