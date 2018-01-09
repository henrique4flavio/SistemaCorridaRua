package modelo;

import dao.InscricaoDAO;
import java.sql.SQLException;
import java.util.*;

public class Inscricao {

    private String formaPagamento;

    private int pago;
    
    private int kitRetirado;


    // private Atleta cpf;
    //Variaveis do banco de dados
    private int id;
    
    private int numeroPeito;
    
    private String categoria;
    
    private String total;

    private String kit_id;

    private String prova_id;

    private String percurso_id;

    private String atleta_id;
    
 public Inscricao(int id,int pago, String formaPagamento, String total,String categoria,
            String kit_id, String prova_id, String percurso_id, String atleta_id) {
        
        this.id = id;
        this.pago = pago;
        this.formaPagamento = formaPagamento;
        this.categoria = categoria;
        this.kit_id = kit_id;
        this.prova_id = prova_id;
        this.percurso_id = percurso_id;
        this.atleta_id = atleta_id;
        this.total = total;
        this.kitRetirado = kitRetirado;
    }
 
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPago() {
        return pago;
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

    public void setPago(int pago) {
        this.pago = pago;
    }
    public int isKitRetirado() {
        return kitRetirado;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public int getKitRetirado() {
        return kitRetirado;
    }

    public void setKitRetirado(int kitRetirado) {
        this.kitRetirado = kitRetirado;
    }
    
    
    public static List<Inscricao> obterInscricoesPagas(int prova_id) throws ClassNotFoundException {
        return InscricaoDAO.obterInscricoesPagas(prova_id);
    }

    public static List<Inscricao> obterInscricoesNaoPagas(int prova_id) throws ClassNotFoundException {
        return InscricaoDAO.obterInscricoesNaoPagas(prova_id);
    }
    
    
    public int GerarNumeroPeito (){
        int valor = (int) (Math.random() * 199999999);
        return valor;
    }
    

}
