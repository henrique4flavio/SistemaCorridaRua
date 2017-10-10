package modelo;

import java.util.*;

public class Prova {

    private String nomeProva;

    private String localLargada;

    private String horarioLargada;

    private String dataDaProva;

    private int maxParticipantes;

    private String dataInicioInscricao;

    private String dataFimInscricao;

    private String faixaEtaria;
    
    //As chaves abaixo são Estrangeiras, do banco de dados 
    private String organizador_ID;
    
    private String ranking_ID;
    
    private String resultado_prova_ID;

    public Prova(String nomeProva, String localLargada, String horarioLargada, String dataDaProva, int maxParticipantes, String dataInicioInscricao, String dataFimInscricao, String faixaEtaria, String organizador_ID, String ranking_ID, String resultado_prova_ID) {
        this.nomeProva = nomeProva;
        this.localLargada = localLargada;
        this.horarioLargada = horarioLargada;
        this.dataDaProva = dataDaProva;
        this.maxParticipantes = maxParticipantes;
        this.dataInicioInscricao = dataInicioInscricao;
        this.dataFimInscricao = dataFimInscricao;
        this.faixaEtaria = faixaEtaria;
        this.organizador_ID = organizador_ID;
        this.ranking_ID = ranking_ID;
        this.resultado_prova_ID = resultado_prova_ID;
    }

    
    
    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getNomeProva() {
        return nomeProva;
    }

    
    public void setNomeProva(String nomeProva) {
        this.nomeProva = nomeProva;
    }

    public String getLocalLargada() {
        return localLargada;
    }

    public void setLocalLargada(String localLargada) {
        this.localLargada = localLargada;
    }

    public String getHorarioLargada() {
        return horarioLargada;
    }

    public void setHorarioLargada(String horarioLargada) {
        this.horarioLargada = horarioLargada;
    }

    public String getDataDaProva() {
        return dataDaProva;
    }

    public void setDataDaProva(String dataDaProva) {
        this.dataDaProva = dataDaProva;
    }

    public int getMaxParticipantes() {
        return maxParticipantes;
    }

    public void setMaxParticipantes(int maxParticipantes) {
        this.maxParticipantes = maxParticipantes;
    }

    public String getDataInicioInscricao() {
        return dataInicioInscricao;
    }

    public void setDataInicioInscricao(String dataInicioInscricao) {
        this.dataInicioInscricao = dataInicioInscricao;
    }

    public String getDataFimInscricao() {
        return dataFimInscricao;
    }

    public void setDataFimInscricao(String dataFimInscricao) {
        this.dataFimInscricao = dataFimInscricao;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }
    public String getOrganizador_ID() {
        return organizador_ID;
    }

    public void setOrganizador_ID(String organizador_ID) {
        this.organizador_ID = organizador_ID;
    }

    public String getRanking_ID() {
        return ranking_ID;
    }

    public void setRanking_ID(String ranking_ID) {
        this.ranking_ID = ranking_ID;
    }

    public String getResultado_prova_ID() {
        return resultado_prova_ID;
    }

    public void setResultado_prova_ID(String resultado_prova_ID) {
        this.resultado_prova_ID = resultado_prova_ID;
    }


    public void cadastrarProva() {

    }

    public void alterarProva() {

    }

    public Prova consultarProva() {
        return null;
    }

    public void excluirProva() {

    }

    public void cadastrarPercursosProva(Percurso percurso) {

    }

    public void controlarEmprestimoChip() {

    }

    public void excluirKitProva(Kit kit) {

    }

    public void cadastrarProvaRanking(Ranking ranking) {

    }

}
