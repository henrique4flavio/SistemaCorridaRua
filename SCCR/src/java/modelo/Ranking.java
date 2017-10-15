package modelo;

import dao.RankingDAO;
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

}
