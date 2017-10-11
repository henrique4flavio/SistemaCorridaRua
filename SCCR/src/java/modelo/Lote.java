package modelo;

import java.util.*;

public class Lote {

    private String identificacao;

    private String dataInicio;

    private String dataFim;

    private String valor;

    //Variaveis do banco de dados
    private int id;
    
    private String prova_id;

    public Lote(int id, String dataInicio, String dataFim, String valor, String identificacao, String prova_id) {
        this.valor = valor;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.prova_id = prova_id;
        this.identificacao = identificacao;
        this.id = id;

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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void CadastrarLote() {

    }

    public String getprova_id() {
        return prova_id;
    }

    public void setProva_id(String prova_id) {
        this.prova_id = prova_id;
    }

}
