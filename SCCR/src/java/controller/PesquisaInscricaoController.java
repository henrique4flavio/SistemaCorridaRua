
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
import modelo.Inscricao;
import modelo.Kit;
import modelo.Percurso;
import modelo.Prova;


public class PesquisaInscricaoController extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try  {
            request.setAttribute("inscricoes",Inscricao.obterInscricoes());
            request.setAttribute("kits",Kit.obterKits());
            request.setAttribute("provas",Prova.obterProvas());
            request.setAttribute("percursos",Percurso.obterPercursos());
            request.setAttribute("atletas",Atleta.obterAtletas());
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaInscricao.jsp");
            view.forward(request,response);

           
        }catch(ClassNotFoundException ex){
            
        
               String acao = request.getParameter("acao");
                if (acao.equals("pesquisa")) {
                        pesquisaInscricao(request, response);

                    }
    }
    }
    public void pesquisaInscricao(HttpServletRequest request, HttpServletResponse response) {
        try {
            String  numero = request.getParameter("numero");
            try {
                request.setAttribute("inscricoes", Inscricao.obterInscricao(0));
            } catch (SQLException ex) {
                Logger.getLogger(PesquisaInscricaoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("kits", Kit.obterKits());
            request.setAttribute("provas", Prova.obterProvas());
            request.setAttribute("percursos", Percurso.obterPercursos());
            request.setAttribute("atletas", Atleta.obterAtletas());
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaInscricao.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PesquisaInscricaoController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PesquisaInscricaoController.class.getName()).log(Level.SEVERE, null, ex);
            }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
