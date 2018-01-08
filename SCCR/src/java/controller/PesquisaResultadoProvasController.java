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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if(acao.equals("geralFemininoAsconcer")){
            geralFemininoAsconcer(request,response);
        }
        if(acao.equals("geralMasculinoAsconcer")){
            geralMasculinoAsconcer(request,response);
        }
        if(acao.equals("geralMasculinoInfantilAsconcer")){
            geralMasculinoInfantilAsconcer(request,response);
        }
        if(acao.equals("geralFemininoInfantilAsconcer")){
            geralFemininoInfantilAsconcer(request,response);
        }
        if(acao.equals("geralFemininoAdultoAsconcer")){
            geralFemininoAdultoAsconcer(request,response);
        }
        if(acao.equals("geralMasculinoAdultoAsconcer")){
            geralMasculinoAdultoAsconcer(request,response);
        }
        if(acao.equals("geralMasculinoIdosoAsconcer")){
            geralMasculinoIdosoAsconcer(request,response);
        }
        if(acao.equals("geralFemininoIdosoAsconcer")){
            geralFemininoIdosoAsconcer(request,response);
        }
        if(acao.equals("visualizarResultado")){
            visualizarResultado(request,response);
        }
        request.setAttribute("resultadoProva",ResultadoProva.obterResultados());
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoProvas.jsp");
         
        
   
  
}
     public void visualizarResultado(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
         request.setAttribute("resultadoProva",ResultadoProva.obterResultados());
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaResultadoProvas.jsp");
         
         try {
             view.forward(request, response);
         } catch (ServletException ex) {
             Logger.getLogger(PesquisaResultadoProvasController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(PesquisaResultadoProvasController.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
     
     
      public void geralMasculinoInfantilAsconcer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String prova = "Asconcer";
            request.setAttribute("resultadoProvas",ResultadoProva.obterResultadoGeralMasculinoInfantilProva(prova));
            
           
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
      
    public void geralFemininoInfantilAsconcer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String prova = "Asconcer";
            request.setAttribute("resultadoProvas",ResultadoProva.obterResultadoGeralFemininoInfantilProva(prova));
            
           
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
    public void geralFemininoAdultoAsconcer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String prova = "Asconcer";
            request.setAttribute("resultadoProvas",ResultadoProva.obterResultadoGeralFemininoAdultoProva(prova));
            
           
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
    public void geralMasculinoAdultoAsconcer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String prova = "Asconcer";
            request.setAttribute("resultadoProvas",ResultadoProva.obterResultadoGeralMasculinoIdosoProva(prova));
            
           
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
    
     public void geralFemininoIdosoAsconcer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String prova = "Asconcer";
            request.setAttribute("resultadoProvas",ResultadoProva.obterResultadoGeralFemininoIdosoProva(prova));
            
           
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
      
     public void geralMasculinoIdosoAsconcer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            String prova = "Asconcer";
            request.setAttribute("resultadoProvas",ResultadoProva.obterResultadoGeralMasculinoIdosoProva(prova));
            
           
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
            request.setAttribute("resultadoProvas",ResultadoProva.obterResultadoGeralMasculinoProva(prova));
            
           
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
            request.setAttribute("resultadoProvas",ResultadoProva.obterResultadoGeralFemininoProva(prova));
            
           
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
        } catch (ClassNotFoundException ex) {
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
        } catch (ClassNotFoundException ex) {
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