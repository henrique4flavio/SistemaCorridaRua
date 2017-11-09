package modelo;

import dao.ProvaDAO;
import java.sql.SQLException;
import java.util.*;

public class Prova {

    private String nomeProva;

    private String localLargada;

    private String horarioLargada;

    private String dataProva;

    private String maxParticipantes;

    private String inicioInscricao;

    private String fimInscricao;

    private String faixaEtaria;
    
    //Variaveis do banco de dados
    private int id;
    
    private String organizador_id;
    
    private String  ranking_id;
    

    

    public Prova(int id, String nomeProva, String localLargada, String horarioLargada, String dataProva, String maxParticipantes, String inicioInscricao, String fimInscricao, String faixaEtaria, String organizador_id, String ranking_id) {
        this.nomeProva = nomeProva;
        this.localLargada = localLargada;
        this.horarioLargada = horarioLargada;
        this.dataProva = dataProva;
        this.maxParticipantes = maxParticipantes;
        this.inicioInscricao = inicioInscricao;
        this.fimInscricao = fimInscricao;
        this.faixaEtaria = faixaEtaria;
        this.organizador_id = organizador_id;
        this.ranking_id = ranking_id;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrganizador() {
        return organizador_id;
    }

    public void setOrganizador(String organizador) {
        this.organizador_id = organizador_id;
    }

    public String getRanking() {
        return ranking_id;
    }

    public void setRanking(String ranking) {
        this.ranking_id = ranking_id;
    }

    public void setRanking_id(String  ranking_id) {
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

    public String getDataProva() {
        return dataProva;
    }

    public void setDataProva(String dataProva) {
        this.dataProva = dataProva;
    }

    public String getMaxParticipantes() {
        return maxParticipantes;
    }

    public void setMaxParticipantes(String maxParticipantes) {
        this.maxParticipantes = maxParticipantes;
    }

    public String getInicioInscricao() {
        return inicioInscricao;
    }

    public void setInicioInscricao(String inicioInscricao) {
        this.inicioInscricao = inicioInscricao;
    }

    public String getFimInscricao() {
        return fimInscricao;
    }

    public void setFimInscricao(String fimInscricao) {
        this.fimInscricao = fimInscricao;
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
    public static List<Prova> obterProvas()
            throws ClassNotFoundException {
        return ProvaDAO.obterProvas();

    }
    public void gravar() throws SQLException, ClassNotFoundException {

        ProvaDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ProvaDAO.alterar(this);

    }

    public void excluir() throws SQLException, ClassNotFoundException {
        ProvaDAO.excluir(this);
    }

    public static Prova obterProva(int id) throws ClassNotFoundException, SQLException {
        return ProvaDAO.obterProva(id);
    }

}
