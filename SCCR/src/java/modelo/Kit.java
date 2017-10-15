package modelo;

import dao.KitDAO;
import java.util.*;

public class Kit {
    
    private String nomeKit;
    //Variaveis do banco de dados
    private int id;

    public Kit(int id, String nomeKit) {
        this.nomeKit = nomeKit;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNomeKit() {
        return nomeKit;
    }

    public void setNomeKit(String nomeKit) {
        this.nomeKit = nomeKit;
    }

    public void adicionarElementoKit(Item item) {
    }

    public void excluirElementoKit() {
    }
    
    public static List<Kit> obterKit()
            throws ClassNotFoundException {
        return KitDAO.obterKits();

}
    

}
