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
import modelo.Prova;
import modelo.ControleChipRetornavel;

public class ManterControleChipRetornavelController extends HttpServlet {

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

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Excluir");
            // para chave estrangeira
            request.setAttribute("prova", Prova.obterProvas());
            request.setAttribute("atletas", Atleta.obterAtletas());

            int codChip = Integer.parseInt(request.getParameter("id"));

            ControleChipRetornavel controleChipRetornavel = ControleChipRetornavel.obterControleChipRetornavel(codChip);
            request.setAttribute("controleChipRetornavel", controleChipRetornavel);
            RequestDispatcher view = request.getRequestDispatcher("/manterControleChipRetornavel.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdControleChipRetornavel"));
        String identificadorAtleta = request.getParameter("txtIdentificadorAtleta");
        String prova_id = request.getParameter("txtProva");
        
        ControleChipRetornavel controleChipRetornavel = new ControleChipRetornavel(id, identificadorAtleta, prova_id);

        try {
            controleChipRetornavel.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaControleChipRetornavelController");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        } catch (ServletException ex) {

        }
    }

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("prova", Prova.obterProvas());

            RequestDispatcher view = request.getRequestDispatcher("/manterControleChipRetornavel.jsp");

            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdControleChipRetornavel"));
        String identificadorAtleta = request.getParameter("txtIdentificadorAtleta");
        String prova_id = request.getParameter("txtProva");

        try {
            Prova prova = Prova.obterProva(id);
            ControleChipRetornavel controleChipRetornavel = new ControleChipRetornavel(id, identificadorAtleta, prova_id);

            controleChipRetornavel.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaControleChipRetornavelController");
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
            request.setAttribute("provas", Prova.obterProvas());
            request.setAttribute("atletas", Atleta.obterAtletas());

            int codChip = Integer.parseInt(request.getParameter("id"));

            ControleChipRetornavel controleChipRetornavel = ControleChipRetornavel.obterControleChipRetornavel(codChip);
            request.setAttribute("controleChipRetornavel", controleChipRetornavel);
            RequestDispatcher view = request.getRequestDispatcher("/manterControleChipRetornavel.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {
        }
    }
     public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdControleChipRetornavel"));
        String identificadorAtleta = request.getParameter("txtIdentificadorAtleta");
        String prova_id = request.getParameter("txtProva");
        ControleChipRetornavel controleChipRetornavel = new ControleChipRetornavel(id, identificadorAtleta, prova_id);

        try {
            controleChipRetornavel.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaControleChipRetornavelController");
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
            Logger.getLogger(ManterControleChipRetornavelController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterControleChipRetornavelController.class.getName()).log(Level.SEVERE, null, ex);
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
