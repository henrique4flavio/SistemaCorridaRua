package modelo;

import java.util.*;

public class ControleChipRetornavel {

    private int identificadorAtleta;
     //Variaveis do banco de dados
    private int id;
    
    private String prova_id;

    public ControleChipRetornavel(int id, int identificadorAtleta, String prova_id) {
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
    

    public int getIdentificadorAtleta() {
        return identificadorAtleta;
    }

    public String getProva_id() {
        return prova_id;
    }

    public void setProva_id(String prova_id) {
        this.prova_id = prova_id;
    }
    

    public void cadastrar() {

    }

    public void excluir() {

    }

    public void gerarRelatorioDeEntrega() {

    }

}
