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
import modelo.Kit;
import modelo.Prova;
import modelo.Percurso;
import modelo.Atleta;
import modelo.Inscricao;
import modelo.Item;
import modelo.Lote;

public class ManterInscricaoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String acao = request.getParameter("acao");
        if(acao.equals("visualziarPagamento")){
            visualizarPagamento(request,response);
        }
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
     public void visualizarPagamento(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("provas", Prova.obterProvas());
            request.setAttribute("kit", Kit.obterKits());
            request.setAttribute("percurso", Percurso.obterPercursos());
            request.setAttribute("atleta", Atleta.obterAtletas());
            request.setAttribute("item", Item.obterItens());

            int codInscricao = Integer.parseInt(request.getParameter("numeroPeito"));
            int prova_id = Integer.parseInt(request.getParameter("prova_id"));

            Prova prova = Prova.obterProva(prova_id);
            request.setAttribute("prova_id", prova);

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

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("provas", Prova.obterProvas());
            request.setAttribute("kit", Kit.obterKits());
            request.setAttribute("percurso", Percurso.obterPercursos());
            request.setAttribute("atleta", Atleta.obterAtletas());
            request.setAttribute("item", Item.obterItens());

            int codInscricao = Integer.parseInt(request.getParameter("numeroPeito"));
            int prova_id = Integer.parseInt(request.getParameter("prova_id"));

            Prova prova = Prova.obterProva(prova_id);
            request.setAttribute("prova_id", prova);

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
        int id = Integer.parseInt(request.getParameter("txtnumeroPeito"));
        String total = request.getParameter("txtTotal");
        Boolean pago = Boolean.parseBoolean(request.getParameter("optPago"));
        Boolean kitRetirado = Boolean.parseBoolean(request.getParameter("optKitRetirado"));
        String formaPagamento = request.getParameter("optFormaPagamento");
        String kit_id = request.getParameter("optKit");
        String prova_id = request.getParameter("prova_id");
        String categoria = request.getParameter("optCategoria");
        String percurso_id = request.getParameter("optPercurso");
        String atleta_id = request.getParameter("optAtleta");

        Inscricao inscricao = new Inscricao(id,formaPagamento, total, categoria, kit_id, prova_id, percurso_id, atleta_id);

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

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {

            request.setAttribute("operacao", "Incluir");
            request.setAttribute("kit", Kit.obterKits());
            request.setAttribute("item", Item.obterItens());
            request.setAttribute("percurso", Percurso.obterPercursos());
            request.setAttribute("atleta", Atleta.obterAtletas());
            request.setAttribute("lote", Lote.obterLotes());

            int prova_id = Integer.parseInt(request.getParameter("prova_id"));

            Prova prova = Prova.obterProva(prova_id);
            request.setAttribute("prova_id", prova);
            RequestDispatcher view = request.getRequestDispatcher("/manterInscricao.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int pago;
        String kit_id = request.getParameter("optKit");
        String prova_id = request.getParameter("prova_id");
        String percurso_id = request.getParameter("optPercurso");
        String atleta_id = request.getParameter("optAtleta");
        int id= Integer.parseInt(request.getParameter("txtnumeroPeito"));
        String total = request.getParameter("txtTotal");
        String formaPagamento = request.getParameter("optFormaPagamento");
      
        
        if(formaPagamento.equals("Boleto Bancário")){
            pago = 0;
        }else{
            pago=1;
        }
        
        //int pago=0;
        String categoria = request.getParameter("optCategoria");
        int numero = 222;
        Inscricao inscricao = new Inscricao(id,pago,formaPagamento, total, categoria, kit_id, prova_id, percurso_id, atleta_id);

        try {
            inscricao.gravar();
        } catch (SQLException ex) {
            Logger.getLogger(ManterInscricaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterInscricaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher view = request.getRequestDispatcher("ObterInscricaoAtletaController?acao=exibirInscricoes&id="+atleta_id);
        view.forward(request, response);

    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Editar");
            request.setAttribute("prova", Prova.obterProvas());
            request.setAttribute("kit", Kit.obterKits());
            request.setAttribute("percurso", Percurso.obterPercursos());
            request.setAttribute("atleta", Atleta.obterAtletas());
            request.setAttribute("item", Item.obterItens());

            int codInscricao = Integer.parseInt(request.getParameter("numeroPeito"));
            int prova_id = Integer.parseInt(request.getParameter("prova_id"));

            Prova prova = Prova.obterProva(prova_id);
            request.setAttribute("prova_id", prova);

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
        int id = Integer.parseInt(request.getParameter("txtnumeroPeito"));
        String total = request.getParameter("txtTotal");
        String formaPagamento = request.getParameter("optFormaPagamento");
        String kit_id = request.getParameter("optKit");
        String prova_id = request.getParameter("optProva");
        String percurso_id = request.getParameter("optPercurso");
        String atleta_id = request.getParameter("optAtleta");
        String categoria = request.getParameter("optCategoria");

        Inscricao inscricao = new Inscricao(id, formaPagamento, total, categoria, kit_id, prova_id, percurso_id, atleta_id);

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
