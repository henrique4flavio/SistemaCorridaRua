package modelo;

import dao.AdministradorDAO;
import dao.OrganizadorDAO;
import dao.ProvaDAO;
import java.sql.SQLException;
import java.util.*;

public class Organizador extends Usuario {

    //Variaveis do banco de dados
    private int id;
    private String administrador_id;

    public Organizador(int id, String nome, String senha, String login, String email, String administrador_id) {
        super(nome, senha, login, email);
        this.id = id;
        this.administrador_id = administrador_id;
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

    public void setAdministrador_id(String administrador_id) {
        this.administrador_id = administrador_id;
    }

    public static List<Organizador> obterOrganizadores()
            throws ClassNotFoundException {
        return OrganizadorDAO.obterOrganizadores();
    }

    public void gravar() throws SQLException, ClassNotFoundException {

        OrganizadorDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        OrganizadorDAO.alterar(this);

    }

    public void excluir() throws SQLException, ClassNotFoundException {
        OrganizadorDAO.excluir(this);
    }

    public static Organizador obterOrganizador(int id) throws ClassNotFoundException, SQLException {
        return OrganizadorDAO.obterOrganizador(id);
    }

    public static Organizador logar(String login, String senha) throws ClassNotFoundException, SQLException {
        return OrganizadorDAO.logar(login, senha);
    }

}
