package modelo;

import dao.AdministradorDAO;
import java.util.*;

public class Administrador extends Usuario {
    
    private int id;

    public Administrador(int id, String nome, String senha, String login, String email) {
        super(nome, senha, login, email);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public static List<Administrador> obterAdministradores()
            throws ClassNotFoundException {
        return AdministradorDAO.obterAdministradores();
    }

    

    
    

}
