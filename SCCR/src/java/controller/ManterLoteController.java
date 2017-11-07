
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Prova;
import modelo.Lote;


public class ManterLoteController extends HttpServlet {

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
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else {
            if (acao.equals("confirmarIncluir")) {
                confirmarIncluir(request, response);
            }
        }
    }
   
   public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("Prova", Prova.obterProva());

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
        String prova_id = request.getParameter("txtIdProva");
    
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
   
}
