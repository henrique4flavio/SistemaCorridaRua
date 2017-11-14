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
import modelo.Administrador;
import modelo.Organizador;

public class ManterOrganizadorController extends HttpServlet {

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
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        }else{
            if (acao.equals("confirmarIncluir")) {
                confirmarIncluir(request, response);
            } else {
                if (acao.equals("prepararExcluir")) {
                    prepararExcluir(request, response);
                } else {
                    if (acao.equals("confirmarExcluir")) {
                        confirmarExcluir(request, response);
                    } else {
                        if (acao.equals("prepararEditar")) {
                            prepararEditar(request, response);
                        } else {
                            if (acao.equals("confirmarEditar")) {
                                confirmarEditar(request, response);
                            }
                        }
                    }
                }
            }
        }
    }

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao","Incluir");
            request.setAttribute("administrador", Administrador.obterAdministradores());

            RequestDispatcher view = request.getRequestDispatcher("/manterOrganizador.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {

        }

    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdOrganizador"));
        String nome = request.getParameter("txtNomeOrganizador");
        String senha = request.getParameter("txtSenhaOrganizador");
        String login = request.getParameter("txtloginOrganizador");
        String email = request.getParameter("txtEmailOrganizador");
        String administrador_id = request.getParameter("txtCodigoAdministrador");
        
        try {
            Administrador administrador = Administrador.obterAdministrador(id);
            Organizador organizador = new Organizador(id, nome, senha, login, email, administrador_id);

            organizador.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaOrganizadorController");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        } catch (ServletException ex) {

        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("administrador", Administrador.obterAdministradores());
            
            int codOrganizador = Integer.parseInt(request.getParameter("id"));

            Organizador organizador = Organizador.obterOrganizador(codOrganizador);
            request.setAttribute("organizador", organizador);
            RequestDispatcher view = request.getRequestDispatcher("/manterOrganizador.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {
        }
    }

    
    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdOrganizador"));
        String nome = request.getParameter("txtNomeOrganizador");
        String senha = request.getParameter("txtSenhaOrganizaador");
        String login = request.getParameter("txtloginOrganizador");
        String email = request.getParameter("txtEmailOrganizador");
        String administrador_id = request.getParameter("txtCodigoAdministrador");

        Organizador organizador = new Organizador(id, nome, senha, login, email, administrador_id);

        try {
            organizador.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaOrganizadorController");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        } catch (ServletException ex) {

        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Editar");
            request.setAttribute("Administrador", Administrador.obterAdministradores());
            
            int codOrganizador = Integer.parseInt(request.getParameter("id"));

            Organizador organizador = Organizador.obterOrganizador(codOrganizador);
            request.setAttribute("organizador", organizador);
            RequestDispatcher view = request.getRequestDispatcher("/manterOrganizador.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdOrganizador"));
        String nome = request.getParameter("txtNomeOrganizador");
        String senha = request.getParameter("txtSenhaOrganizaador");
        String login = request.getParameter("txtloginOganizador");
        String email = request.getParameter("txtEmailOrganizador");
        String administrador_id = request.getParameter("txtCodigoAdministrador");

        Organizador organizador = new Organizador(id, nome, senha, login, email, administrador_id);

        try {
            organizador.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaOrganizadorController");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

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
        } catch (SQLException ex) {
            Logger.getLogger(ManterOrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterOrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
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
