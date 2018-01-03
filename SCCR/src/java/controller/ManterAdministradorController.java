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

public class ManterAdministradorController extends HttpServlet {

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
            RequestDispatcher view = request.getRequestDispatcher("/manterAdministrador.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        }

    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdAdministrador"));
        String nomeAdministrador = request.getParameter("txtNomeAdministrador");
        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenhaAdm");
        String login = request.getParameter("txtLoginAdm");

        try {
            Administrador administrador = new Administrador(id, nomeAdministrador, senha, login, email);
            administrador.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAdministradorController");
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
            // para chave estrangeira
            //request.setAttribute("administrador", Administrador.obterAdministrador());

            int codAdministrador = Integer.parseInt(request.getParameter("id"));

            Administrador administrador = Administrador.obterAdministrador(codAdministrador);
            request.setAttribute("administrador", administrador);
            RequestDispatcher view = request.getRequestDispatcher("/manterAdministrador.jsp");
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
        int id = Integer.parseInt(request.getParameter("txtIdAdministrador"));
        String nome = request.getParameter("txtNomeAdministrador");
        String email = request.getParameter("txtEmail");
        String login = request.getParameter("txtLoginAdm");
        String senha = request.getParameter("txtSenhaAdm");
        Administrador administrador = new Administrador(id, nome, senha, login, email);

        try {
            administrador.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAdministradorController");
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
            // para chave estrangeira
            //request.setAttribute("administrador", Administrador.obterAdministrador());

            int codAdministrador = Integer.parseInt(request.getParameter("id"));

            Administrador administrador = Administrador.obterAdministrador(codAdministrador);
            request.setAttribute("administrador", administrador);
            RequestDispatcher view = request.getRequestDispatcher("/manterAdministrador.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdAdministrador"));
        String nomeAdministrador = request.getParameter("txtNomeAdministrador");
        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenhaAdm");
        String login = request.getParameter("txtLoginAdm");

        try {
            Administrador administrador = new Administrador(id, nomeAdministrador, senha, login, email);
            administrador.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAdministradorController");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        } catch (ServletException ex) {

        }

    }

}
