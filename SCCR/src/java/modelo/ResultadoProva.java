package modelo;

import dao.ResultadoProvaDAO;
import java.util.*;

public class ResultadoProva {

    private String resultadoClassificacao;
    //Variaveis do banco de dados
    private int id;

    public ResultadoProva(int id, String ResultadoClassificacao) {
        this.resultadoClassificacao = ResultadoClassificacao;
        this.id = id;
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
}
