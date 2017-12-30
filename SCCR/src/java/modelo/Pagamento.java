package modelo;

public abstract class Pagamento {

    private int id;
    private Inscricao inscricao;
    private int inscricao_id;

    public Pagamento(int id, Inscricao inscricao, int inscricaoNumeroPeito) {
        this.id = id;
        this.inscricao = inscricao;
    }

    Pagamento(Inscricao inscricao) {
        this.inscricao = inscricao;
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

    public abstract void confirmarPagamento();

}
