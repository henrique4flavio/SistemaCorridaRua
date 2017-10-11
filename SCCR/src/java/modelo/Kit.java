package modelo;

import java.util.*;

public class Kit {
    private int id;
    
    private String nomeKit;

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

}
