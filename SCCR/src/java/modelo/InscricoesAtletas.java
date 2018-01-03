/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.InscricaoDAO;
import dao.InscricoesAtletasDAO;

import java.sql.SQLException;
import java.util.List;



public class InscricoesAtletas {
    private int numeroPeito;
    private int idProva;

    public int getIdProva() {
        return idProva;
    }

    public void setIdProva(int idProva) {
        this.idProva = idProva;
    }

    public InscricoesAtletas(int numeroPeito, int Prova_id) {
        this.numeroPeito = numeroPeito;
        this.idProva = Prova_id;
    }

    public int getNumeroPeito() {
        return numeroPeito;
    }

    public void setNumeroPeito(int numeroPeito) {
        this.numeroPeito = numeroPeito;
    }

    

   
    public static List<InscricoesAtletas> obterInscricoesAtletas(int prova_id) throws ClassNotFoundException,SQLException {
        return InscricoesAtletasDAO.obterInscricoes(prova_id);
    }
}
