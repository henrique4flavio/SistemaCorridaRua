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
    
    //Variaveis do banco de dados
    private int id;
    
    private String organizador_id;
    
    private String ranking_id;
    
    private String resultado_prova_id;

    public Prova(int id, String nomeProva, String localLargada, String horarioLargada, String dataDaProva, int maxParticipantes, String dataInicioInscricao, String dataFimInscricao, String faixaEtaria, String organizador_id, String ranking_id, String resultado_prova_id) {
        this.nomeProva = nomeProva;
        this.localLargada = localLargada;
        this.horarioLargada = horarioLargada;
        this.dataDaProva = dataDaProva;
        this.maxParticipantes = maxParticipantes;
        this.dataInicioInscricao = dataInicioInscricao;
        this.dataFimInscricao = dataFimInscricao;
        this.faixaEtaria = faixaEtaria;
        this.organizador_id = organizador_id;
        this.ranking_id = ranking_id;
        this.resultado_prova_id = resultado_prova_id;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRanking_id(String ranking_id) {
        this.ranking_id = ranking_id;
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
    public String getOrganizador_id() {
        return organizador_id;
    }

    public void setOrganizador_id(String organizador_id) {
        this.organizador_id = organizador_id;
    }

    public String getRanking_id() {
        return ranking_id;
    }

    public void setRanking_ID(String ranking_id) {
        this.ranking_id = ranking_id;
    }

    public String getResultado_prova_id() {
        return resultado_prova_id;
    }

    public void setResultado_prova_id(String resultado_prova_id) {
        this.resultado_prova_id = resultado_prova_id;
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
