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
import modelo.Organizador;
import modelo.Percurso;
import modelo.Prova;
import modelo.Ranking;
import modelo.ResultadoProva;

public class ManterProvaController extends HttpServlet {

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

                            } else {
                                if (acao.equals("visualizarProva")) {
                                    visualizarProva(request, response);
                                    

                                }
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
            request.setAttribute("organizador", Organizador.obterOrganizadores());
            request.setAttribute("ranking", Ranking.obterRankings());

            RequestDispatcher view = request.getRequestDispatcher("/manterProva.jsp");

            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Editar");
            request.setAttribute("organizador", Organizador.obterOrganizadores());
            request.setAttribute("ranking", Ranking.obterRankings());

            int codProva = Integer.parseInt(request.getParameter("id"));

            Prova prova = Prova.obterProva(codProva);
            request.setAttribute("prova", prova);
            RequestDispatcher view = request.getRequestDispatcher("/manterProva.jsp");

            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtId"));
        String nomeProva = request.getParameter("txtNomeProva");
        String localLargada = request.getParameter("txtLocalLargada");
        String horarioLargada = request.getParameter("txtHorarioLargada");
        String dataProva = request.getParameter("txtDataProva");
        String maxParticipantes = request.getParameter("txtmaxParticipantes");
        String dataInicioInscricao = request.getParameter("txtInicioInscricao");
        String dataFimInscricao = request.getParameter("txtFimInscricao");
        String faixaEtaria = request.getParameter("txtFaixaEtaria");
        String localRetiradaKit = request.getParameter("txtLocalRetiradaKit");
        String valorProva = request.getParameter("txtValorProva");
        String organizador_id = request.getParameter("optOrganizador");
        String ranking_id = request.getParameter("optRanking");

        try {
            Organizador organizador = Organizador.obterOrganizador(id);
            Ranking ranking = Ranking.obterRanking(id);
            
            Prova prova = new Prova(id, nomeProva, localLargada, horarioLargada, dataProva, maxParticipantes, dataInicioInscricao, dataFimInscricao, localRetiradaKit, valorProva, id, id, organizador_id, ranking_id);

            prova.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaProvaController?acao=listarProvas");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        } catch (ServletException ex) {

        }
    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
       
     int id = Integer.parseInt(request.getParameter("txtId"));
        String nomeProva = request.getParameter("txtNomeProva");
        String localLargada = request.getParameter("txtLocalLargada");
        String horarioLargada = request.getParameter("txtHorarioLargada");
        String dataProva = request.getParameter("txtDataProva");
        String maxParticipantes = request.getParameter("txtmaxParticipantes");
        String dataInicioInscricao = request.getParameter("txtInicioInscricao");
        String dataFimInscricao = request.getParameter("txtFimInscricao");
        String faixaEtaria = request.getParameter("txtFaixaEtaria");
        String localRetiradaKit = request.getParameter("txtLocalRetiradaKit");
        String valorProva = request.getParameter("txtValorProva");
        String organizador_id = request.getParameter("optOrganizador");
        String ranking_id = request.getParameter("optRanking");

        try {
            Organizador organizador = Organizador.obterOrganizador(id);
            Ranking ranking = Ranking.obterRanking(id);
            
            Prova prova = new Prova(id, nomeProva, localLargada, horarioLargada, dataProva, maxParticipantes, dataInicioInscricao, dataFimInscricao, localRetiradaKit, valorProva, id, id, organizador_id, ranking_id);

            prova.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaProvaController?acao=listarProvas");
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
            request.setAttribute("organizador", Organizador.obterOrganizadores());

            request.setAttribute("ranking", Ranking.obterRankings());


            int codProva = Integer.parseInt(request.getParameter("id"));

            Prova prova = Prova.obterProva(codProva);
            request.setAttribute("prova", prova);
            RequestDispatcher view = request.getRequestDispatcher("/manterProva.jsp");

            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtId"));
        String nomeProva = request.getParameter("txtNomeProva");
        String localLargada = request.getParameter("txtLocalLargada");
        String horarioLargada = request.getParameter("txtHorarioLargada");
        String dataProva = request.getParameter("txtDataProva");
        String maxParticipantes = request.getParameter("txtmaxParticipantes");
        String inicioInscricao = request.getParameter("txtInicioInscricao");
        String fimInscricao = request.getParameter("txtFimInscricao");
        String faixaEtaria = request.getParameter("txtFaixaEtaria");
        String organizador_id = request.getParameter("optOrganizador");
        String ranking_id = request.getParameter("optRanking");
        String localRetiradaKit = request.getParameter("txtLocalRetiradaKit");
        String valorProva = request.getParameter("txtValorProva");
        Prova prova = new Prova(id, nomeProva, localLargada, horarioLargada, dataProva, maxParticipantes, inicioInscricao, fimInscricao, localRetiradaKit, valorProva, id, id, organizador_id, ranking_id);

        try {
            prova.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaProvaController?acao=listarProvas");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        } catch (ServletException ex) {

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
            Logger.getLogger(ManterProvaController.class
.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterProvaController.class
.getName()).log(Level.SEVERE, null, ex);
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
