package modelo;

import dao.KitDAO;
import java.sql.SQLException;
import java.util.*;

public class Kit {

    private String nomeKit;
    //Variaveis do banco de dados
    private int id;
    
    private float valor;

    public Kit(int id, String nomeKit, float valor) {
        this.nomeKit = nomeKit;
        this.id = id;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
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

    public static List<Kit> obterKits()
            throws ClassNotFoundException {
        return KitDAO.obterKits();

    }
     public void gravar() throws SQLException, ClassNotFoundException {

        KitDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        KitDAO.alterar(this);

    }

    public void excluir() throws SQLException, ClassNotFoundException {
        KitDAO.excluir(this);
    }

    public static Kit obterKit(int id) throws ClassNotFoundException, SQLException {
        return KitDAO.obterKit(id);
    }

}
