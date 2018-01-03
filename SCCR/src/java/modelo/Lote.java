package modelo;

import dao.LoteDAO;
import java.sql.SQLException;
import java.util.*;

public class Lote {

    private String identificacao;

    private String dataInicio;

    private String dataFim;

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    //Variaveis do banco de dados
    private int id;
    private String desconto;

    private String prova_id;

    public Lote(int id, String dataInicio, String dataFim, String identificacao, String desconto, String prova_id) {

        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.prova_id = prova_id;
        this.identificacao = identificacao;
        this.id = id;
        this.desconto = desconto;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public void CadastrarLote() {

    }

    public String getprova_id() {
        return prova_id;
    }

    public void setProva_id(String prova_id) {
        this.prova_id = prova_id;
    }

    public static List<Lote> obterLotes()
            throws ClassNotFoundException {
        return LoteDAO.obterLotes();
    }

    public void gravar() throws SQLException, ClassNotFoundException {

        LoteDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        LoteDAO.alterar(this);

    }

    public void excluir() throws SQLException, ClassNotFoundException {
        LoteDAO.excluir(this);
    }

    public static Lote obterLote(int id) throws ClassNotFoundException, SQLException {
        return LoteDAO.obterLote(id);
    }
}
