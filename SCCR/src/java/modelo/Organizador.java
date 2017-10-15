package modelo;

import dao.OrganizadorDAO;
import java.util.*;

public class Organizador extends Usuario {
    
    //Variaveis do banco de dados
    private int id;
    private String administrador_id;

    public Organizador(int id, String nome, String senha, String login, String email, String administrador_id) {
        super(nome, senha, login, email);
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getAdministrador_id() {
        return administrador_id;
    }

    public void setAdministrador_ID(String administrador_id) {
        this.administrador_id = administrador_id;
    }
    
 
    
    public void cadastrarOrganizador() {
    }

    public String visualizarRanking() {
        return "";
    }

    public String visualizarClassificacao() {
        return "";
    }
    public static List<Organizador> obterOrganizador()
            throws ClassNotFoundException {
        return OrganizadorDAO.obterOrganizadores();
    }

}
