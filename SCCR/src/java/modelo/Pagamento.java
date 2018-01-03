package modelo;

public abstract class Pagamento {

    private int id;
    private Inscricao inscricao;
    private Prova inscricaoProva;
    private int inscricao_id;
    private int inscricaoProva_id;

    Pagamento(int id, Inscricao inscricao, Prova inscricaoProva) {
        this.id = id;
        this.inscricao = inscricao;
        this.inscricaoProva = inscricaoProva;
    }

    Pagamento(Inscricao inscricao, Prova inscricaoProva) {
        this.inscricao = inscricao;
        this.inscricaoProva = inscricaoProva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }

    public int getInscricao_id() {
        return inscricao_id;
    }

    public void setInscricao_id(int inscricao_id) {
        this.inscricao_id = inscricao_id;
    }

    public Prova getInscricaoProva() {
        return inscricaoProva;
    }

    public void setInscricaoProva(Prova inscricaoProva) {
        this.inscricaoProva = inscricaoProva;
    }

    public int getInscricaoProva_id() {
        return inscricaoProva_id;
    }

    public void setInscricaoProva_id(int inscricaoProva_id) {
        this.inscricaoProva_id = inscricaoProva_id;
    }
    
    public abstract void confirmarPagamento();

}
