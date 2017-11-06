package modelo;

import dao.AtletaDAO;
import dao.ControleChipRetornavelDAO;
import java.sql.SQLException;
import java.util.*;

public class ControleChipRetornavel {

    private String identificadorAtleta;
    //Variaveis do banco de dados
    private int id;

    private String prova_id;

    public ControleChipRetornavel(int id, String identificadorAtleta, String prova_id) {
        this.identificadorAtleta = identificadorAtleta;
        this.prova_id = prova_id;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificadorAtleta() {
        return identificadorAtleta;
    }

    public void setIdentificadorAtleta(String identificadorAtleta) {
        this.identificadorAtleta = identificadorAtleta;
    }

    public String getProva_id() {
        return prova_id;
    }

    public void setProva_id(String prova_id) {
        this.prova_id = prova_id;
    }

    /*
    public void cadastrar() {

    }
     */
    public void gerarRelatorioDeEntrega() {

    }

    public static List<ControleChipRetornavel> obterControleChipRetornavel()
            throws ClassNotFoundException {
        return ControleChipRetornavelDAO.obterControleChipRetornaveis();

    }

    public void gravar() throws SQLException, ClassNotFoundException {

        ControleChipRetornavelDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ControleChipRetornavelDAO.alterar(this);

    }

    public void excluir() throws SQLException, ClassNotFoundException {
        ControleChipRetornavelDAO.excluir(this);
    }

    public static ControleChipRetornavel obterControleChipRetornavel(int id) throws ClassNotFoundException, SQLException {
        return ControleChipRetornavelDAO.obterControleChipRetornavel(id);
    }
}
