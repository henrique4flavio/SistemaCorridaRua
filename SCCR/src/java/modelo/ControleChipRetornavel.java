package modelo;

import java.util.*;

public class ControleChipRetornavel {

    private int identificadorAtleta;
    
    private String prova_ID;

    public ControleChipRetornavel(int identificadorAtleta, String prova_ID) {
        this.identificadorAtleta = identificadorAtleta;
        this.prova_ID = prova_ID;
    }

    public int getIdentificadorAtleta() {
        return identificadorAtleta;
    }

    public String getProva_ID() {
        return prova_ID;
    }

    public void setProva_ID(String prova_ID) {
        this.prova_ID = prova_ID;
    }
    

    public void cadastrar() {

    }

    public void excluir() {

    }

    public void gerarRelatorioDeEntrega() {

    }

}
