package modelo;

import java.util.*;

public class Percurso {

    private String nome;

    private double distancia;

    private int faixaEtaria;
    
    //A chave abaixo é Estrangeira, do banco de dados
    private String prova_ID;

    public Percurso(String nome, double distancia, int faixaEtaria, String prova_ID) {
        this.nome = nome;
        this.distancia = distancia;
        this.faixaEtaria = faixaEtaria;
        this.prova_ID = prova_ID;
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

    public String getProva_ID() {
        return prova_ID;
    }
    
    public void setProva_ID(String prova_ID) {
        this.prova_ID = prova_ID;
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
