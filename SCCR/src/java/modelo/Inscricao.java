package modelo;

import dao.InscricaoDAO;
import java.sql.SQLException;
import java.util.*;

public class Inscricao {

    private String formaPagamento;
    
   // private Atleta cpf;
    
    //Variaveis do banco de dados
    private int numeroPeito;

    private String total;
    
    private String kit_id;

    private String prova_id;

    private String percurso_id;

    private String atleta_id;

    public Inscricao(int numeroPeito, String formaPagamento, String total,
            String kit_id, String prova_id, String percurso_id,String atleta_id) {
        this.numeroPeito = numeroPeito;
        this.formaPagamento = formaPagamento;
        this.kit_id = kit_id;
        this.prova_id = prova_id;
        this.percurso_id = percurso_id;
        this.atleta_id = atleta_id;
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
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

    public int getNumeroPeito() {
        return numeroPeito;
    }

    public void setNumeroPeito(int numeroPeito) {
        this.numeroPeito = numeroPeito;
    }

    public void setKit_id(String kit_id) {
        this.kit_id = kit_id;
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

    public static List<Inscricao> obterInscricoes()
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

    public static List<Inscricao> pesquisaInscricao(String numero)
            throws ClassNotFoundException, SQLException {
        return InscricaoDAO.pesquisaInscricao(numero);

    }

    
}
