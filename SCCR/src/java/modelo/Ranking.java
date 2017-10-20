package modelo;

import dao.RankingDAO;
import java.sql.SQLException;
import java.util.*;

public class Ranking {

    private String nome;
    //Variaveis do banco de dados
    private int id;

    public Ranking(int id, String nome) {
        this.nome = nome;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String consultarRanking() {
        return "";
    }

    public boolean cadastrarRanking() {
        return false;
    }

    public void cadastrarAtletaRanking() {

    }

    public void divulgarRanking() {

    }

    public static List<Ranking> obterRanking()
            throws ClassNotFoundException {
        return RankingDAO.obterRankings();

    }

    public void gravar() throws SQLException, ClassNotFoundException {

        RankingDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        RankingDAO.alterar(this);

    }

    public void excluir() throws SQLException, ClassNotFoundException {
        RankingDAO.excluir(this);
    }

    public static Ranking obterRanking(int id) throws ClassNotFoundException, SQLException {
        return RankingDAO.obterRanking(id);
    }
}
