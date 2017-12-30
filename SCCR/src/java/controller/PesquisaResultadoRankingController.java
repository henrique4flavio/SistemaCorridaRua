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
import modelo.ResultadoProva;
import modelo.ResultadoRanking;

/**
 *
 * @author LaisAlves
 */
public class PesquisaResultadoRankingController extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
         String acao = request.getParameter("acao");
        if(acao.equals("geralMasculinoRankingJF")){
            geralMasculinoRankingJF(request,response);
        }
        if(acao.equals("geralFemininoRankingJF")){
            geralFemininoRankingJF(request,response);
        }
        if(acao.equals("geralMasculinoInfantilRankingJF")){
            geralMasculinoInfantilRankingJF(request,response);
        }
        if(acao.equals("geralFemininoInfantilRankingJF")){
            geralFemininoInfantilRankingJF(request,response);
        }
        if(acao.equals("geralFemininoAdultoAsconcer")){
            geralFemininoAdultoRankingJF(request,response);
        }
        if(acao.equals("geralMasculinoAdultoRankingJF")){
            geralMasculinoAdultoRankingJF(request,response);
        }
        if(acao.equals("geralMasculinoIdosoRankingJF")){
            geralMasculinoIdosoRankingJF(request,response);
        }
        if(acao.equals("geralFemininoIdosoRankingJF")){
            geralFemininoIdosoRankingJF(request,response);
        }
        if(acao.equals("visualizarRanking")){
            visualizarRanking(request,response);
        }
    
  
}
     public void visualizarRanking(HttpServletRequest request, HttpServletResponse response) throws SQLException {
         RequestDispatcher view = request.getRequestDispatcher("/PaginaResultadoRanking.jsp");
         try {
             view.forward(request, response);
         } catch (ServletException ex) {
             Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
     
     
      public void geralMasculinoInfantilRankingJF(HttpServletRequest request, HttpServletResponse response) throws SQLException {
         try{
          String ranking = "RankingJF";
          request.setAttribute("resultadoRanking",ResultadoRanking.obterResultadoGeralMasculinoInfantilRanking(ranking));
          RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoRanking.jsp");
          try {
              view.forward(request, response);
          } catch (ServletException ex) {
              Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
          }
         } catch (ClassNotFoundException ex) {

        }
    
      }
    public void geralFemininoInfantilRankingJF(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String ranking = "RankingJF";
            request.setAttribute("resultadoRanking",ResultadoRanking.obterResultadoGeralFemininoInfantilRanking(ranking));
            
           
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoRanking.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

        }

    }
    public void geralFemininoAdultoRankingJF(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String ranking = "RankingJF";
            request.setAttribute("resultadoRanking",ResultadoRanking.obterResultadoGeralFemininoAdultoRanking(ranking));
            
           
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoProvas.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

        }

    }
    public void geralMasculinoAdultoRankingJF(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        String ranking = "RankingJF";
        request.setAttribute("resultadoRanking",ResultadoRanking.obterResultadoGeralMasculinoIdosoRanking(ranking));
        RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoRanking.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public void geralFemininoIdosoRankingJF(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String ranking = "RankingJF";
            request.setAttribute("resultadoRanking",ResultadoRanking.obterResultadoGeralFemininoIdosoRanking(ranking));
            
           
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoRanking.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

        }

    }
      
     public void geralMasculinoIdosoRankingJF(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String ranking = "RankingJF";
            request.setAttribute("resultadoRanking",ResultadoRanking.obterResultadoGeralMasculinoIdosoRanking(ranking));
            
           
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoRanking.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

        }

    }
    
     
     public void geralMasculinoRankingJF(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String ranking = "RankingJF";
            request.setAttribute("resultadoRanking",ResultadoRanking.obterResultadoGeralMasculinoRanking(ranking));
            
           
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoRanking.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

        }

    }
     
     public void geralFemininoRankingJF(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String ranking = "RankingJF";
            request.setAttribute("resultadoRanking",ResultadoRanking.obterResultadoGeralFemininoRanking(ranking));
            
           
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoRanking.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaResultadoRankingController.class.getName()).log(Level.SEVERE, null, ex);
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
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
  

