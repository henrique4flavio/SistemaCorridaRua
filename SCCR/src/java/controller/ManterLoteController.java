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
import modelo.Prova;
import modelo.Lote;

public class ManterLoteController extends HttpServlet {

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
            request.setAttribute("prova", Prova.obterProvas());

            RequestDispatcher view = request.getRequestDispatcher("/manterLote.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdLote"));
        String identificacao = request.getParameter("txtIdentificacaoLote");
        String dataInicio = request.getParameter("txtDataInicioLote");
        String dataFim = request.getParameter("txtDataFimLote");
        String valor = request.getParameter("txtValorLote");
        String prova_id = request.getParameter("optProva");

        try {
            Prova prova = Prova.obterProva(id);
            Lote lote = new Lote(id, dataInicio, dataFim, valor, identificacao, prova_id);

            lote.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaLoteController");
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
            request.setAttribute("prova", Prova.obterProvas());
            
            int codLote = Integer.parseInt(request.getParameter("id"));
            
            Lote lote = Lote.obterLote(codLote);
            request.setAttribute("lote", lote);

            RequestDispatcher view = request.getRequestDispatcher("/manterLote.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdLote"));
        String identificacao = request.getParameter("txtIdentificacaoLote");
        String dataInicio = request.getParameter("txtDataInicioLote");
        String dataFim = request.getParameter("txtDataFimLote");
        String valor = request.getParameter("txtValorLote");
        String prova_id = request.getParameter("optProva");

        try {
            Prova prova = Prova.obterProva(id);
            Lote lote = new Lote(id, dataInicio, dataFim, valor, identificacao, prova_id);

            lote.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaLoteController");
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
            request.setAttribute("prova", Prova.obterProvas());
   
           int codLote = Integer.parseInt(request.getParameter("id"));
            
            Lote lote = Lote.obterLote(codLote);
            request.setAttribute("lote", lote);
            
            RequestDispatcher view = request.getRequestDispatcher("/manterLote.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
       int id = Integer.parseInt(request.getParameter("txtIdLote"));
        String identificacao = request.getParameter("txtIdentificacaoLote");
        String dataInicio = request.getParameter("txtDataInicioLote");
        String dataFim = request.getParameter("txtDataFimLote");
        String valor = request.getParameter("txtValorLote");
        String prova_id = request.getParameter("optProva");
        
        Lote lote = new Lote(id, dataInicio, dataFim, valor, identificacao, prova_id);

        try {
            lote.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaLoteController");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        } catch (ServletException ex) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterLoteController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterLoteController.class.getName()).log(Level.SEVERE, null, ex);
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
