package modelo;

import dao.ResultadoProvaDAO;
import java.sql.SQLException;
import java.util.*;

public class ResultadoProva {

    private String resultadoClassificacao;
    
    private String nomeProva;
    //Variaveis do banco de dados
    private int id;

    public ResultadoProva(int id, String resultadoClassificacao, String nomeProva) {
        this.resultadoClassificacao = resultadoClassificacao;
        this.id = id;
        
    }

    public String getNomeProva() {
        return nomeProva;
    }

    public void setNomeProva(String nomeProva) {
        this.nomeProva = nomeProva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResultadoClassificacao() {
        return resultadoClassificacao;
    }

    public void setResultadoClassificacao(String ResultadoClassificacao) {
        this.resultadoClassificacao = ResultadoClassificacao;
    }

    public void consultarResultadoIndividual() {

    }

    public void importarInformacaoChip() {

    }

    public void divulgarResultado() {

    }

    public void AlterarResultado() {

    }

    public void consultarResultado() {

    }

    public static List<ResultadoProva> obterResultadoProva()
            throws ClassNotFoundException {
        return ResultadoProvaDAO.obterResultadoProvas();

    }
    public void gravar() throws SQLException, ClassNotFoundException {

        ResultadoProvaDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ResultadoProvaDAO.alterar(this);

    }

    public void excluir() throws SQLException, ClassNotFoundException {
        ResultadoProvaDAO.excluir(this);
    }

    public static ResultadoProva obterResultadoProva(int id) throws ClassNotFoundException, SQLException {
        return ResultadoProvaDAO.obterResultadoProva(id);
    }
}

