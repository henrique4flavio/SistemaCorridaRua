package modelo;

import java.util.*;

public class Percurso {

    private String nome;

    private double distancia;

    private int faixaEtaria;
    
    //Variaveis do banco de dados
    private int id;
    
    private String prova_id;

    public Percurso(int id, String nome, double distancia, int faixaEtaria, String prova_id) {
        this.nome = nome;
        this.distancia = distancia;
        this.faixaEtaria = faixaEtaria;
        this.prova_id = prova_id;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

   
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getNome() {
        return nome;
    }

    public String getProva_id() {
        return prova_id;
    }
    
    public void setProva_id(String prova_id) {
        this.prova_id = prova_id;
    }

    
    public void cadastrarPercurso() {

    }

    public void alterarPercurso() {

    }

    public Percurso consultarPercurso() {
        return null;
    }

    public void excluirPercurso() {

    }

    public void importarMapeamento() {

    }

    public void divulgarPercurso() {

    }

}
