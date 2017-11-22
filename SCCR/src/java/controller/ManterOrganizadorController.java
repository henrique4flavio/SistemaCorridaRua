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
import modelo.Organizador;
import modelo.Administrador;

public class ManterOrganizadorController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else {
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
            request.setAttribute("operacao", "Incluir");
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
        String nomeAdministrador = request.getParameter("txtNomeOrganizador");
        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");
        String login = request.getParameter("txtLogin");
        
        String administrador_id = request.getParameter("txtAdministrador_id");

        try {
            Administrador administrador = Administrador.obterAdministrador(id);
            Organizador organizador = new Organizador(id, nomeAdministrador, senha, login, email, administrador_id);
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
            request.setAttribute("administradores", Administrador.obterAdministradores());

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
            Logger.getLogger(ManterAdministradorController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterAdministradorController.class.getName()).log(Level.SEVERE, null, ex);
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

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdOrganizador"));
        String nome = request.getParameter("txtNomeOrganizador");
        String email = request.getParameter("txtEmail");
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");
        String administrador_id = request.getParameter("txtAdministrador_id");
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

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdOrganizador"));
        String nome = request.getParameter("txtNomeOrganizador");
        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");
        String login = request.getParameter("txtLogin");
        String administrador_id = request.getParameter("txtAdministrador_id");

        try {
            Organizador organizador = new Organizador(id, nome, senha, login, email, administrador_id);
            organizador.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaOrganizadorController");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        } catch (ServletException ex) {

        }

    }

}
