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
import modelo.ResultadoProva;

/**
 *
 * @author LaisAlves
 */
public class ManterResultadoProvasController extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String acao = request.getParameter("acao");
        if (acao.equals("importarResultadoProvas")) {
            importarResultadoProvas(request, response);
        }
        if(acao.equals("confirmarImportacaoProva")){
            confirmarImportacaoProva(request,response);
        }
        }
    public void importarResultadoProvas(HttpServletRequest request, HttpServletResponse response){
        try{
            
            RequestDispatcher view = request.getRequestDispatcher("manterResultadoProvas.jsp");
            view.forward(request, response);
        }catch (ServletException ex){
        }catch (IOException ex){
        }
    }      
 public void confirmarImportacaoProva(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException{
       int id = Integer.parseInt(request.getParameter("txtId"));
        String nome = request.getParameter("txtNomeAtleta");
        int numeroPeito= Integer.parseInt(request.getParameter("txtNumeroPeito"));
        String categoria = request.getParameter("txtCategoria");
        int classificacao = Integer.parseInt(request.getParameter("txtClassificacao"));
        int tempo = Integer.parseInt(request.getParameter("txtTempo"));
        String sexo = request.getParameter("txtSexo");
        String prova = request.getParameter("txtProva");
        
        ResultadoProva resultadoProva = new ResultadoProva(id, nome, numeroPeito, tempo,categoria, classificacao,  sexo, prova);
        
        try {
            resultadoProva.gravar();
           RequestDispatcher view = request.getRequestDispatcher("PesquisaResultadoProvasController");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (ServletException ex) {

        }
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterResultadoProvasController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterResultadoProvasController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterResultadoProvasController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterResultadoProvasController.class.getName()).log(Level.SEVERE, null, ex);
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
