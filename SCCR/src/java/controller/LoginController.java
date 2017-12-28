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
import javax.servlet.http.HttpSession;
import modelo.Administrador;
import modelo.Atleta;
import modelo.Organizador;

/**
 *
 * @author LaisAlves
 */
public class LoginController extends HttpServlet {

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
        if (acao.equals("logar")) {
            logar(request, response);
        } else {
            if (acao.equals("logout")) {
                logout(request, response);
            }
        }
    }

    private String logar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException, SQLException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String Usuario = request.getParameter("optUsuario");
        try {
            if (Usuario.equals("administrador")) {
                try {
                    Administrador administrador = Administrador.logar(login, senha);
                    if (administrador != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("administrador", administrador);
                        session.setAttribute("usuario", administrador);
                        RequestDispatcher view = request.getRequestDispatcher("/administradorHome.jsp");
                        view.forward(request, response);
                    } else {
                        request.setAttribute("mensagemErro", "Usuário não encontrado");
                        RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                        view.forward(request, response);
                    }

                } catch (IOException | ClassNotFoundException | ServletException ex) {
                }
            } else if (Usuario.equals("organizador")) {
                try {
                    Organizador organizador = Organizador.logar(login, senha);
                    if (organizador != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("organizador", organizador);
                        session.setAttribute("usuario", "organizador");
                        RequestDispatcher view = request.getRequestDispatcher("/organizadorHome.jsp");
                        view.forward(request, response);
                    } else {
                        request.setAttribute("mensagemErro", "Usuário não encontrado");
                        RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                        view.forward(request, response);
                    }

                } catch (IOException | ClassNotFoundException | ServletException ex) {
                }
            } else if (Usuario.equals("atleta")) {
                try {
                    Atleta atleta = Atleta.logar(login, senha);
                    if (atleta != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("atleta", atleta);
                        session.setAttribute("usuario", "atleta");
                        RequestDispatcher view = request.getRequestDispatcher("/atletaHome.jsp");
                        view.forward(request, response);
                    } else {
                        request.setAttribute("mensagemErro", "Usuario não encontrado");
                        RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                        view.forward(request, response);
                    }

                } catch (IOException | ClassNotFoundException | ServletException ex) {
                }

            }

        } catch (NullPointerException ex) {
            try {
                response.sendRedirect("index.jsp");
            } catch (IOException ex1) {
            }
        }
        return null;
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void logout(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();

        }
        try {
            response.sendRedirect("index.jsp");
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
