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
import modelo.Kit;
import modelo.Organizador;
import modelo.Percurso;
import modelo.Prova;
import modelo.ResultadoRanking;

/**
 *
 * @author LaisAlves
 */
public class PesquisaResultadoRanking extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String acao = request.getParameter("acao");
         if(acao.equals("visualizarRanking")){
            visualizarRanking(request,response);
        }
         if(acao.equals("geralMasculinoInfantilRankingJF")){
             geralMasculinoInfantilRankingJF(request,response);
         }
         if(acao.equals("geralFemininoInfantilRankingJF"))
             geralFemininoInfantilRankingJF(request,response);
         if(acao.equals("geralFemininoAdultoRankingJF"))
             geralFemininoAdultoRankingJF(request,response);
         if(acao.equals("geralMasculinoAdultoRankingJF")){
             geralMasculinoAdultoRankingJF(request,response);
    }
         if(acao.equals("geralFemininoIdosoRankingJF")){
             geralFemininoIdosoRankingJF(request,response);
         }
         if(acao.equals("geralMasculinoIdosoRankingJF")){
             geralMasculinoIdosoRankingJF(request,response);
         }
         if(acao.equals("geralMasculinoRankingJF"))
             geralMasculinoRankingJF(request,response);
         if(acao.equals("geralFemininoRankingJF"))
             geralFemininoRankingJF(request,response);
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
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

    private void visualizarRanking(HttpServletRequest request, HttpServletResponse response) {
        
     try {
            
            RequestDispatcher view = request.getRequestDispatcher("/PaginaResultadoRanking.jsp");

            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        }
    
    }
    public void geralFemininoRankingJF(HttpServletRequest request, HttpServletResponse response) throws SQLException {
       try{
        String ranking = "RankingJF";
        try{
        request.setAttribute("resultadoRanking",ResultadoRanking.obterResultadoGeralFemininoRanking(ranking));
        }catch (SQLException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoRanking.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
        }

       }catch (ClassNotFoundException ex) {

        }
    }
    public void geralMasculinoRankingJF(HttpServletRequest request, HttpServletResponse response) throws SQLException {
       try{
        String ranking = "RankingJF";
        try{
        request.setAttribute("resultadoRanking",ResultadoRanking.obterResultadoGeralMasculinoRanking(ranking));
        }catch (SQLException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoRanking.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
        }

       }catch (ClassNotFoundException ex) {

        }
    }
   
      
    public void geralMasculinoAdultoRankingJF(HttpServletRequest request, HttpServletResponse response) throws SQLException {
       try{
        String ranking = "RankingJF";
        try{
        request.setAttribute("resultadoRanking",ResultadoRanking.obterResultadoGeralMasculinoAdultoRanking(ranking));
        }catch (SQLException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoRanking.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
        }

       }catch (ClassNotFoundException ex) {

        }
    }
    public void geralFemininoAdultoRankingJF(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String ranking = "RankingJF";
            try{
            request.setAttribute("resultadoRanking",ResultadoRanking.obterResultadoGeralFemininoAdultoRanking(ranking));
            }catch (SQLException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoRanking.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

        }

    }
    
     public void geralMasculinoInfantilRankingJF(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String  numero ="RankingJF";
            try {
                request.setAttribute("resultadoRanking", ResultadoRanking.obterResultadoGeralMasculinoInfantilRanking(numero));
            } catch (SQLException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoRanking.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

        }


}
     
     public void geralFemininoInfantilRankingJF(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        
         try {
           String ranking = "RankingJF";
           try{
            request.setAttribute("resultadoRanking",ResultadoRanking.obterResultadoGeralFemininoInfantilRanking(ranking));
         }catch (SQLException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoRanking.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

        }

    }
     public void geralFemininoIdosoRankingJF(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        
         try {
           String ranking = "RankingJF";
           try{
            request.setAttribute("resultadoRanking",ResultadoRanking.obterResultadoGeralFemininoIdosoRanking(ranking));
         }catch (SQLException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoRanking.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

        }

    }
     public void geralMasculinoIdosoRankingJF(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        
         try {
           String ranking = "RankingJF";
           try{
            request.setAttribute("resultadoRanking",ResultadoRanking.obterResultadoGeralMasculinoIdosoRanking(ranking));
         }catch (SQLException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoRanking.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaResultadoRanking.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

        }

    }
}