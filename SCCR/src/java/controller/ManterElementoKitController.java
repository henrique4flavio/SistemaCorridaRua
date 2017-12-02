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
import modelo.ElementoKit;
import modelo.Item;

public class ManterElementoKitController extends HttpServlet {

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
            request.setAttribute("Itens", Item.obterItens());
            request.setAttribute("kit", Kit.obterKits());
           

            int codElementoKit = Integer.parseInt(request.getParameter("item_id"));


            ElementoKit elementoKit = ElementoKit.obterElementoKit(codElementoKit);
            request.setAttribute("elementoKit", elementoKit);
            RequestDispatcher view = request.getRequestDispatcher("/manterElementoKit.jsp");
            view.forward(request, response);

            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtId"));
        int item_id = Integer.parseInt(request.getParameter("txtItem_id"));
        int kit_id = Integer.parseInt(request.getParameter("txtKit_id"));
        
        
        ElementoKit elementoKit = new ElementoKit(id, item_id, kit_id);

        try {
            elementoKit.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaElementoKitController");
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
            request.setAttribute("item", Item.obterItens());
            request.setAttribute("kit", Kit.obterKits());
           
            RequestDispatcher view = request.getRequestDispatcher("/manterElementoKit.jsp");

            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtId"));
        int item_id = Integer.parseInt(request.getParameter("txtItem_id"));
        int kit_id = Integer.parseInt(request.getParameter("txtKit_id"));
 
        try {
            Item item = Item.obterItem(item_id);
            Kit kit = Kit.obterKit(kit_id);
            
            
            ElementoKit elementoKit = new ElementoKit(id, item_id, kit_id);
            elementoKit.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaElementoKitController");
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
            request.setAttribute("Itens", Item.obterItens());
            request.setAttribute("kit", Kit.obterKits());
            int codElementoKit = Integer.parseInt(request.getParameter("id"));  
            ElementoKit elementoKit = ElementoKit.obterElementoKit(codElementoKit);
            request.setAttribute("elementoKit", elementoKit);
            RequestDispatcher view = request.getRequestDispatcher("/manterElementoKit.jsp");
            view.forward(request, response);

            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtId"));
        int item_id = Integer.parseInt(request.getParameter("txtItem_id"));
        int kit_id = Integer.parseInt(request.getParameter("txtKit_id"));
        
        ElementoKit elementoKit = new ElementoKit(id, item_id, kit_id);
        try {
            elementoKit.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaElementoKitController");
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
            Logger.getLogger(ManterElementoKitController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterElementoKitController.class.getName()).log(Level.SEVERE, null, ex);
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
