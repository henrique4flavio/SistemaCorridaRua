
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Kit;
import modelo.Prova;
import modelo.ControleChipRetornavel;
import modelo.Percurso;
import modelo.Atleta;


public class ManterInscricaoController extends HttpServlet {

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } 
    } 
public void prepararIncluir(HttpServletRequest request, HttpServletResponse response){
        try{
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("prova", Prova.obterProva());
            request.setAttribute("kit", Kit.obterKit());
            request.setAttribute("controleChipRetornavel", ControleChipRetornavel.obterControleChipRetornavel());
            request.setAttribute("percurso", Percurso.obterPercurso());
            request.setAttribute("atleta", Atleta.obterAtleta());
            
            RequestDispatcher view = request.getRequestDispatcher("/manterInscricao.jsp");
            
            view.forward(request, response);
        }catch (ServletException ex){
        }catch (IOException ex){
        }catch (ClassNotFoundException ex) {
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
