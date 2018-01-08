package modelo;

import dao.InscricaoDAO;
import java.sql.SQLException;
import java.util.*;

public class Inscricao {
<<<<<<< HEAD
 
    private Pagamento pagamento;
=======

    private String formaPagamento;

    private int pago;
    
    private int kitRetirado;

>>>>>>> parent of 6a607e4... upgrade

    // private Atleta cpf;
    //Variaveis do banco de dados
    private Atleta atleta;
    private Percurso percurso;
    private Prova prova;
    private Kit kit;
    
    
    
    private int id;
    
    private int numeroPeito;
    
    private String categoria;
    
    private String total;

    private String kit_id;

    private String prova_id;

    private String percurso_id;

    private String atleta_id;
<<<<<<< HEAD
    
    private int codPagamento;

    
 public Inscricao(int id,int numeroPeito, String categoria,String total,Pagamento pagamento,
            Kit kit, Prova prova, Percurso percurso, Atleta atleta) {
        
        this.id = id;
        this.numeroPeito = GerarNumeroPeito();
        this.categoria = categoria;
        this.total = total;
        
        this.pagamento = pagamento;
        this.atleta = atleta;
        this.percurso = percurso;
        this.prova = prova;
        this.kit = kit;
     
        
    }
        
    
 public Inscricao(int id,int numeroPeito,String categoria,
            Kit kit, Prova prova, Percurso percurso, Atleta atleta) {
        
        this.id = id;
        this.numeroPeito = GerarNumeroPeito();
        this.categoria = categoria;         
        
        this.pagamento = pagamento;
        this.atleta = atleta;
        this.percurso = percurso;
        this.prova = prova;
        this.kit = kit;
=======
 public Inscricao(int id,int numeroPeito,int pago, String formaPagamento, String total,String categoria,
            String kit_id, String prova_id, String percurso_id, String atleta_id) {
        
        this.id = id;
        this.numeroPeito =GerarNumeroPeito();
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
 public Inscricao(int id,String formaPagamento, String total,String categoria,
            String kit_id, String prova_id, String percurso_id, String atleta_id) {
        
        this.id = id;
        this.numeroPeito = GerarNumeroPeito();
        this.pago = pago;
        this.formaPagamento = formaPagamento;
        this.categoria = categoria;
        this.kit_id = kit_id;
        this.prova_id = prova_id;
        this.percurso_id = percurso_id;
        this.atleta_id = atleta_id;
        this.total = total;
        this.kitRetirado = kitRetirado;
>>>>>>> parent of 6a607e4... upgrade
    }
    public Inscricao(int id,int pago, String formaPagamento, String total,String categoria,
            String kit_id, String prova_id, String percurso_id, String atleta_id) {
        
        this.id = id;
        this.numeroPeito = numeroPeito;
        this.pago = pago;
        this.formaPagamento = formaPagamento;
        this.categoria = categoria;
        this.kit_id = kit_id;
        this.prova_id = prova_id;
        this.percurso_id = percurso_id;
        this.atleta_id = atleta_id;
        this.total = total;
        this.kitRetirado = kitRetirado;
        this.numeroPeito=GerarNumeroPeito();
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
    public int getCodPagamento() {
        return codPagamento;
    }

<<<<<<< HEAD
    public void setCodPagamento(int codPagamento) {
        this.codPagamento = codPagamento;
=======
    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
>>>>>>> parent of 6a607e4... upgrade
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

<<<<<<< HEAD
    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public Percurso getPercurso() {
        return percurso;
    }

    public void setPercurso(Percurso percurso) {
        this.percurso = percurso;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public Kit getKit() {
        return kit;
    }

    public void setKit(Kit kit) {
        this.kit = kit;
    }

=======
    public int getPago() {
        return pago;
    }
>>>>>>> parent of 6a607e4... upgrade

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

<<<<<<< HEAD
  
=======
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
    
    
>>>>>>> parent of 6a607e4... upgrade
    public int GerarNumeroPeito (){
        int valor = (int) (Math.random() * 199999999);
        return valor;
    }
    
    

}
