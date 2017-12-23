/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Atleta;
import modelo.Inscricao;
import modelo.ResultadoProva;

/**
 *
 * @author LaisAlves
 */
public class PesquisaResultadoProvasController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("geralFemininoAsconcer")) {
            geralFemininoAsconcer(request, response);
        } 
        if(acao.equals("geralMasculinoAsconcer")){
            geralMasculinoAsconcer(request,response);
        }
        if(acao.equals("geralAsconcer")){
            geralAsconcer(request,response);
        }
        if(acao.equals("visualizarProvas")){
            visualizarProvas(request,response);
        }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  
}
     public void visualizarProvas(HttpServletRequest request, HttpServletResponse response) throws SQLException {
         RequestDispatcher view = request.getRequestDispatcher("/PaginaResultadoProvas.jsp");
         try {
             view.forward(request, response);
         } catch (ServletException ex) {
             Logger.getLogger(PesquisaResultadoProvasController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(PesquisaResultadoProvasController.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
      public void geralAsconcer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            
            request.setAttribute("resultadoProvas",ResultadoProva.obterResultadoGeralProva(1));
            request.setAttribute("atleta", Atleta.obterAtletas());
            request.setAttribute("inscricao", Inscricao.obterInscricoes());
           
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoProvas.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaResultadoProvasController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaResultadoProvasController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

        }

    }
     
      public void geralMasculinoAsconcer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String prova = "Asconcer";
            request.setAttribute("resultadoProvas",ResultadoProva.obterResultadoGeralMasculinoProva(1));
            request.setAttribute("atleta", Atleta.obterAtletas());
            request.setAttribute("inscricao", Inscricao.obterInscricoes());
           
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoProvas.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaResultadoProvasController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaResultadoProvasController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

        }

    }
      public void geralFemininoAsconcer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String prova = "Asconcer";
            request.setAttribute("resultadoProvas",ResultadoProva.obterResultadoGeralFemininoProva(1));
            request.setAttribute("atleta", Atleta.obterAtletas());
            request.setAttribute("inscricao", Inscricao.obterInscricoes());
           
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoProvas.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaResultadoProvasController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaResultadoProvasController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

        }

    }
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaResultadoProvasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaResultadoProvasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}