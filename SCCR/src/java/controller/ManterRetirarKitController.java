
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Atleta;
import modelo.Prova;
import modelo.Inscricao;


public class ManterRetirarKitController extends HttpServlet {

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
        if (acao.equals("prepararRetirarKit")) {
            prepararRetirarKit(request, response);
        } else if (acao.equals("confirmarRetirarKit")) {
            confirmarRetirarKit(request, response);
        } else if (acao.equals("escolherProva")) {
            escolherProva(request, response);
        }
    }

    public void prepararRetirarKit(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
        try {
            int prova_id = Integer.parseInt(request.getParameter("prova_id"));
            request.setAttribute("inscricoes", Inscricao.obterInscricoesPagas(prova_id));
            request.setAttribute("prova", Prova.obterProva(prova_id));
            RequestDispatcher view = request.getRequestDispatcher("/manterRetirarKit.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (IOException ex) {

        }
    }

    private void confirmarRetirarKit(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Inscricao inscricao = Inscricao.obterInscricao(id);
        inscricao.setKitRetirado(true);
        HttpSession session = request.getSession(true);
        Atleta atleta = (Atleta) session.getAttribute("atleta");

        try {
            inscricao.retirarKit();
            RequestDispatcher view = request.getRequestDispatcher("ManterRetirarKitController?acao=escolherCorrida");
            view.forward(request, response);
        } catch (IOException ex) {
        } catch (ServletException ex) {
        }
    }

    private void escolherProva(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("provas", Prova.obterProvas());
            RequestDispatcher view = request.getRequestDispatcher("/escolherCorridaRetirarKit.jsp");
            view.forward(request, response);
        } catch (IOException ex) {
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterRetirarKitController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterRetirarKitController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterRetirarKitController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterRetirarKitController.class.getName()).log(Level.SEVERE, null, ex);
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