package modelo;

import java.util.*;

public class Organizador extends Usuario {

    
    //A chave abaixo é Estrangeira, do banco de dados
    private String administrador_ID;

    public Organizador(String nome, String senha, String login, String email, String administrador_ID) {
        super(nome, senha, login, email);

    }

    public String getAdministrador_ID() {
        return administrador_ID;
    }

    public void setAdministrador_ID(String administrador_ID) {
        this.administrador_ID = administrador_ID;
    }
    
 
    
    public void cadastrarOrganizador() {
    }

    public String visualizarRanking() {
        return "";
    }

    public String visualizarClassificacao() {
        return "";
    }

}
