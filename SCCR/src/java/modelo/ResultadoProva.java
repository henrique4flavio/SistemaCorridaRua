package modelo;

import java.util.*;

public class ResultadoProva {
    private int id;

    private String ResultadoClassificacao;

    public ResultadoProva(int id, String ResultadoClassificacao) {
        this.ResultadoClassificacao = ResultadoClassificacao;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResultadoClassificacao() {
        return ResultadoClassificacao;
    }

    public void setResultadoClassificacao(String ResultadoClassificacao) {
        this.ResultadoClassificacao = ResultadoClassificacao;
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

}
