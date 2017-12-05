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
import modelo.Kit;
import modelo.Prova;
import modelo.Percurso;
import modelo.Atleta;
import modelo.Inscricao;

public class ManterInscricaoController extends HttpServlet {

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
                            } else {
                                if (acao.equals("escolherProva")) {
                                    escolherProva(request, response);
                                }
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
            request.setAttribute("provas", Prova.obterProvas());
            request.setAttribute("kit", Kit.obterKits());
            request.setAttribute("percurso", Percurso.obterPercursos());
            request.setAttribute("atleta", Atleta.obterAtletas());

            int codInscricao = Integer.parseInt(request.getParameter("id"));

            Inscricao inscricao = Inscricao.obterInscricao(codInscricao);
            request.setAttribute("inscricao", inscricao);
            RequestDispatcher view = request.getRequestDispatcher("/manterInscricao.jsp");
            view.forward(request, response);

            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtId"));
        String dataInscricao = request.getParameter("txtDataInscricao");
        int numeroInscricao = Integer.parseInt(request.getParameter("txtNumeroInscricao"));
        String formaPagamento = request.getParameter("optFormaPagamento");
        String kit_id = request.getParameter("optKit");
        String prova_id = request.getParameter("optProva");
        String atleta_id = request.getParameter("txtAtleta");
        String percurso_id = request.getParameter("optPercurso");

        Inscricao inscricao = new Inscricao(id, dataInscricao, numeroInscricao, formaPagamento, kit_id, prova_id, percurso_id, atleta_id);

        try {
            inscricao.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaInscricaoController");
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
            request.setAttribute("kit", Kit.obterKits());
            request.setAttribute("prova", Prova.obterProvas());
            request.setAttribute("percurso", Percurso.obterPercursos());
            request.setAttribute("atleta", Atleta.obterAtletas());

            RequestDispatcher view = request.getRequestDispatcher("/manterInscricao.jsp");

            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtId"));
        String dataInscricao = request.getParameter("txtDataInscricao");
        int numeroInscricao = Integer.parseInt(request.getParameter("txtNumeroInscricao"));
        String formaPagamento = request.getParameter("optFormaPagamento");

        String kit_id = request.getParameter("optKit");
        String prova_id = request.getParameter("optProva");
        String atleta_id = request.getParameter("txtAtleta");
        String percurso_id = request.getParameter("optPercurso");

        try {
            Kit kit = Kit.obterKit(id);
            Prova prova = Prova.obterProva(id);
            Percurso percurso = Percurso.obterPercurso(id);
            Atleta atleta = Atleta.obterAtleta(id);

            Inscricao inscricao = new Inscricao(id, dataInscricao, numeroInscricao, formaPagamento, kit_id, prova_id, percurso_id, atleta_id);
            inscricao.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaInscricaoController");
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
            request.setAttribute("kit", Kit.obterKits());
            request.setAttribute("percurso", Percurso.obterPercursos());
            request.setAttribute("atleta", Atleta.obterAtletas());

            int codInscricao = Integer.parseInt(request.getParameter("id"));

            Inscricao inscricao = Inscricao.obterInscricao(codInscricao);
            request.setAttribute("inscricao", inscricao);
            RequestDispatcher view = request.getRequestDispatcher("/manterInscricao.jsp");
            view.forward(request, response);

            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtId"));
        String dataInscricao = request.getParameter("txtDataInscricao");
        int numeroInscricao = Integer.parseInt(request.getParameter("txtNumeroInscricao"));
        String formaPagamento = request.getParameter("optFormaPagamento");
        String kit_id = request.getParameter("optKit");
        String prova_id = request.getParameter("optProva");
        String atleta_id = request.getParameter("txtAtleta");
        String percurso_id = request.getParameter("optPercurso");
        Inscricao inscricao = new Inscricao(id, dataInscricao, numeroInscricao, formaPagamento, kit_id, prova_id, percurso_id, atleta_id);
        try {
            inscricao.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaInscricaoController");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        } catch (ServletException ex) {

        }
    }
    
     public void escolherProva(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("kit", Kit.obterKits());
            request.setAttribute("prova", Prova.obterProvas());
            request.setAttribute("percurso", Percurso.obterPercursos());
            request.setAttribute("atleta", Atleta.obterAtletas());

            RequestDispatcher view = request.getRequestDispatcher("/listaDeProva.jsp");

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
            Logger.getLogger(ManterInscricaoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterInscricaoController.class.getName()).log(Level.SEVERE, null, ex);
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
