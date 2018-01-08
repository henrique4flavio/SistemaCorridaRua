/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Kit;
import modelo.Organizador;
import modelo.Prova;
import modelo.Ranking;

/**
 *
 * @author flavi
 */
public class PesquisaProvaController extends HttpServlet {

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
        if (acao.equals("listarProvas")) {
            listarProvas(request, response);
        } else {
            if (acao.equals("gridProvas")) {
                gridProvas(request, response);
            } else {
                if (acao.equals("visualizarProva")) {
                    try {
                        visualizarProva(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(PesquisaProvaController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    if (acao.equals("pesquisa")) {
                        pesquisaProva(request, response);

                    }
                }
            }
        }
    }
     public void listarProvasOrganizador(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("provas", Prova.obterProvasOrganizador());
            request.setAttribute("organizadores", Organizador.obterOrganizadores());
            request.setAttribute("ranking", Ranking.obterRankings());
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaProva.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaProvaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaProvaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

        }

    }

    public void listarProvas(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("provas", Prova.obterProvas());
            request.setAttribute("organizadores", Organizador.obterOrganizadores());
            request.setAttribute("ranking", Ranking.obterRankings());
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaProva.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaProvaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaProvaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

        }

    }

    public void visualizarProva(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Visualizar");
            request.setAttribute("organizador", Organizador.obterOrganizadores());
            request.setAttribute("kit", Kit.obterKits());

            int codProva = Integer.parseInt(request.getParameter("id"));

            Prova prova = Prova.obterProva(codProva);
            request.setAttribute("prova", prova);
            RequestDispatcher view = request.getRequestDispatcher("/viewProva.jsp");

            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void gridProvas(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("provas", Prova.obterProvas());
            request.setAttribute("organizadores", Organizador.obterOrganizadores());
            request.setAttribute("ranking", Ranking.obterRankings());
            RequestDispatcher view = request.getRequestDispatcher("index2.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaProvaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaProvaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

        }

    }
    
     public void pesquisaProva(HttpServletRequest request, HttpServletResponse response) {
        try {
            String nome = request.getParameter("nome");
            try {
                request.setAttribute("provas", Prova.pesquisaProva(nome));
            } catch (SQLException ex) {
                Logger.getLogger(PesquisaProvaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("organizadores", Organizador.obterOrganizadores());
            request.setAttribute("ranking", Ranking.obterRankings());
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaProva.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaProvaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaProvaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

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
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaProvaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PesquisaProvaController.class.getName()).log(Level.SEVERE, null, ex);
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
