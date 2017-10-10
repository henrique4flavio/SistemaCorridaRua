package modelo;

import java.util.*;

public class Inscricao {

    private String dataInscricao;

    private int numeroInscricao;

    private String formaPagamento;
    
    //A chave abaixo é Estrangeira, do banco de dados
    private String kit_ID;
    
    private String controle_chip_retornavel_ID;
    
    private String prova_ID;
    
    private String percurso_ID;
    
    private String atleta_ID;

    public Inscricao(String dataInscricao, int numeroInscricao, String formaPagamento, String kit_ID, String controle_chip_retornavel_ID, String prova_ID, String percurso_ID, String atleta_ID) {
        this.dataInscricao = dataInscricao;
        this.numeroInscricao = numeroInscricao;
        this.formaPagamento = formaPagamento;
        this.kit_ID = kit_ID;
        this.controle_chip_retornavel_ID = controle_chip_retornavel_ID;
        this.prova_ID = prova_ID;
        this.percurso_ID = percurso_ID;
        this.atleta_ID = atleta_ID;
    }
            
            
    

    public String getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(String dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public int getNumeroInscricao() {
        return numeroInscricao;
    }

    public void setNumeroInscricao(int numeroInscricao) {
        this.numeroInscricao = numeroInscricao;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getKit_ID() {
        return kit_ID;
    }

    public void setKit_ID(String kit_ID) {
        this.kit_ID = kit_ID;
    }

    public String getControle_chip_retornavel_ID() {
        return controle_chip_retornavel_ID;
    }

    public void setControle_chip_retornavel_ID(String controle_chip_retornavel_ID) {
        this.controle_chip_retornavel_ID = controle_chip_retornavel_ID;
    }

    public String getProva_ID() {
        return prova_ID;
    }

    public void setProva_ID(String prova_ID) {
        this.prova_ID = prova_ID;
    }

    public String getPercurso_ID() {
        return percurso_ID;
    }

    public void setPercurso_ID(String percurso_ID) {
        this.percurso_ID = percurso_ID;
    }

    public String getAtleta_ID() {
        return atleta_ID;
    }

    public void setAtleta_ID(String atleta_ID) {
        this.atleta_ID = atleta_ID;
    }
    

    public void inscreverAtleta(Atleta atleta, Prova prova) {

    }

    public void alterarInscricao(Atleta atleta, Prova prova) {

    }

    public void consultarInscricao(Atleta atleta, Prova prova) {

    }

    public void excluirInscricao(Atleta atleta, Prova prova) {

    }

    public void emitirComprovanteIncricao() {

    }

}
