package modelo;

import java.util.*;

public class Lote {

    private String identificacao;

    private String dataInicio;

    private String dataFim;

    private String valor;

    //A chave abaixo é Estrangeira, do banco de dados
    private String prova_ID;

    public Lote(String dataInicio, String dataFim, String valor, String identificacao, String prova_ID) {
        this.valor = valor;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.prova_ID = prova_ID;
        this.identificacao = identificacao;

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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void CadastrarLote() {

    }

    public String getprova_ID() {
        return prova_ID;
    }

    public void setProva_ID(String prova_ID) {
        this.prova_ID = prova_ID;
    }

}
