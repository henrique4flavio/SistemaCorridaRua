package modelo;

import dao.InscricaoDAO;
import java.sql.SQLException;
import java.util.*;

public class Inscricao {

    private String dataInscricao;

    private int numeroInscricao;

    private String formaPagamento;

    //Variaveis do banco de dados
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String kit_id;

    private String controle_chip_retornavel_id;

    private String prova_id;

    private String percurso_id;

    private String atleta_id;

    public Inscricao(int id, String dataInscricao, int numeroInscricao, String formaPagamento, String kit_id, String controle_chip_retornavel_id, String prova_id, String percurso_id, String atleta_id) {
        this.dataInscricao = dataInscricao;
        this.numeroInscricao = numeroInscricao;
        this.formaPagamento = formaPagamento;
        this.kit_id = kit_id;
        this.controle_chip_retornavel_id = controle_chip_retornavel_id;
        this.prova_id = prova_id;
        this.percurso_id = percurso_id;
        this.atleta_id = atleta_id;
        this.id = id;
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

    public String getKit_id() {
        return kit_id;
    }

    public void setKit_id(String kit_id) {
        this.kit_id = kit_id;
    }

    public String getControle_chip_retornavel_id() {
        return controle_chip_retornavel_id;
    }

    public void setControle_chip_retornavel_id(String controle_chip_retornavel_id) {
        this.controle_chip_retornavel_id = controle_chip_retornavel_id;
    }

    public String getProva_id() {
        return prova_id;
    }

    public void setProva_id(String prova_id) {
        this.prova_id = prova_id;
    }

    public String getPercurso_id() {
        return percurso_id;
    }

    public void setPercurso_id(String percurso_id) {
        this.percurso_id = percurso_id;
    }

    public String getAtleta_id() {
        return atleta_id;
    }

    public void setAtleta_id(String atleta_id) {
        this.atleta_id = atleta_id;
    }

    public void inscreverAtleta(Atleta atleta, Prova prova) {

    }

    /*
    public void alterarInscricao(Atleta atleta, Prova prova) {

    }
     */
    public void consultarInscricao(Atleta atleta, Prova prova) {

    }

    /*
    public void excluirInscricao(Atleta atleta, Prova prova) {

    }
     */
    public void emitirComprovanteIncricao() {

    }

    public static List<Inscricao> obterInscricao()
            throws ClassNotFoundException {
        return InscricaoDAO.obterInscricoes();

    }

    public void gravar() throws SQLException, ClassNotFoundException {

        InscricaoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        InscricaoDAO.alterar(this);

    }

    public void excluir() throws SQLException, ClassNotFoundException {
        InscricaoDAO.excluir(this);
    }

    public static Inscricao obterInscricao(int id) throws ClassNotFoundException, SQLException {
        return InscricaoDAO.obterInscricao(id);
    }
}
