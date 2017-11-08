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
import modelo.Percurso;

public class ManterPercursoController extends HttpServlet {

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
            }
        }
        if (acao.equals("prepararExcluir")) {
            prepararExcluir(request, response);
        } else {
            if (acao.equals("confirmarExcluir")) {
                confirmarExcluir(request, response);
            }
        }
    }
    
    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdPercurso"));
        String nome = request.getParameter("txtNomePercurso");
        String distancia = request.getParameter("txtDistancia");
        String faixaEtaria = request.getParameter("txtfaixaEtaria");
        String prova_id = request.getParameter("optProva");
        Percurso percurso = new Percurso(id, nome, distancia, faixaEtaria, prova_id);
        try {
            percurso.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPercursoController");

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
            request.setAttribute("provas", Prova.obterProvas());

            RequestDispatcher view = request.getRequestDispatcher("/manterPercurso.jsp");

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
            int idPercurso =  Integer.parseInt(request.getParameter("id"));
            
            
            Percurso percurso = Percurso.obterPercurso(idPercurso);
            request.setAttribute("percurso",percurso);
            RequestDispatcher view = request.getRequestDispatcher("/manterPercurso.jsp");
            view.forward(request, response);
            
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdPercurso"));
        String nome = request.getParameter("txtNomePercurso");
        String distancia = request.getParameter("txtDistancia");
        String faixaEtaria = request.getParameter("txtfaixaEtaria");
        String prova_id = request.getParameter("optProva");

        try {
            Prova prova = Prova.obterProva(id);
            Percurso percurso = new Percurso(id, nome, distancia, faixaEtaria, prova_id);

            percurso.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPercursoController");
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
            Logger.getLogger(ManterPercursoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterPercursoController.class.getName()).log(Level.SEVERE, null, ex);
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
