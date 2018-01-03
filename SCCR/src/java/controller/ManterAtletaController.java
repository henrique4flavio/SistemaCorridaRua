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

public class ManterAtletaController extends HttpServlet {

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
            // para chave estrangeira
            //request.setAttribute("administrador", Administrador.obterAdministrador());

            int codAtleta = Integer.parseInt(request.getParameter("id"));

            Atleta atleta = Atleta.obterAtleta(codAtleta);
            request.setAttribute("atleta", atleta);
            RequestDispatcher view = request.getRequestDispatcher("/manterAtleta.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdAtleta"));
        String nome = request.getParameter("txtNomeAtleta");
        String dataNascimento = request.getParameter("txtDataNascimento");
        String apelido = request.getParameter("txtApelido");
        String cpf = request.getParameter("txtCpf");
        String tamCamisa = request.getParameter("optTamanhoCamisa");
        String sexo = request.getParameter("optSexo");
        String email = request.getParameter("txtEmail");
        String telFixo = request.getParameter("txtTelefoneFixo");
        String telCel = request.getParameter("txtTelefoneCelular");
        String pais = request.getParameter("txtPais");
        String estado = request.getParameter("txtEstadoAtleta");
        String rua = request.getParameter("txtRuaAtleta");

        String bairro = request.getParameter("txtBairroAtleta");
        String cidade = request.getParameter("txtCidadeAtleta");
        String login = request.getParameter("txtLoginAtleta");
        String senha = request.getParameter("txtSenhaAtleta");

        Atleta atleta = new Atleta(id, nome, dataNascimento, apelido,
                cpf, tamCamisa, sexo, telFixo, telCel, rua, bairro, cidade, estado, pais, login, senha, email);

        try {
            atleta.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAtletaController");
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
            RequestDispatcher view = request.getRequestDispatcher("/manterAtleta.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        }

    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdAtleta"));
        String sexo = request.getParameter("optSexo");
        String rua = request.getParameter("txtRuaAtleta");
        String bairro = request.getParameter("txtBairroAtleta");
        String cidade = request.getParameter("txtCidadeAtleta");
        String estado = request.getParameter("txtEstadoAtleta");
        String pais = request.getParameter("txtPais");
        String tamCamisa = request.getParameter("optTamanhoCamisa");
        String telefoneFixo = request.getParameter("txtTelefoneFixo");
        String telefoneCelular = request.getParameter("txtTelefoneCelular");
        String cpf = request.getParameter("txtCpf");
        String apelido = request.getParameter("txtApelido");
        String nomeDaEquipe = request.getParameter("txtNomeEquipe");
        String dataNascimento = request.getParameter("txtDataNascimento");
        String nome = request.getParameter("txtNomeAtleta");
        String email = request.getParameter("txtEmail");
        String login = request.getParameter("txtLoginAtleta");
        String senha = request.getParameter("txtSenhaAtleta");

        try {
            Atleta atleta = new Atleta(id, nome, dataNascimento, apelido, cpf, tamCamisa, sexo, telefoneFixo, telefoneCelular, rua, bairro, cidade, estado, pais, login, senha, email);
            atleta.gravar();
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
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
            // para chave estrangeira
            //request.setAttribute("administrador", Administrador.obterAdministrador());

            int codAtleta = Integer.parseInt(request.getParameter("id"));

            Atleta atleta = Atleta.obterAtleta(codAtleta);
            request.setAttribute("atleta", atleta);
            RequestDispatcher view = request.getRequestDispatcher("/manterAtleta.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdAtleta"));
        String sexo = request.getParameter("optSexo");
        String rua = request.getParameter("txtRuaAtleta");
        String bairro = request.getParameter("txtBairroAtleta");
        String cidade = request.getParameter("txtCidadeAtleta");
        String estado = request.getParameter("txtEstadoAtleta");
        String pais = request.getParameter("txtPais");
        String tamCamisa = request.getParameter("optTamanhoCamisa");
        String telefoneFixo = request.getParameter("txtTelefoneFixo");
        String telefoneCelular = request.getParameter("txtTelefoneCelular");
        String cpf = request.getParameter("txtCpf");
        String apelido = request.getParameter("txtApelido");
        String nomeDaEquipe = request.getParameter("txtNomeEquipe");
        String dataNascimento = request.getParameter("txtDataNascimento");
        String nome = request.getParameter("txtNomeAtleta");
        String email = request.getParameter("txtEmail");
        String login = request.getParameter("txtLoginAtleta");
        String senha = request.getParameter("txtSenhaAtleta");

        try {
            Atleta atleta = new Atleta(id, nome, dataNascimento, apelido, cpf, tamCamisa, sexo, telefoneFixo, telefoneCelular, rua, bairro, cidade, estado, pais, login, senha, email);
            atleta.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAtletaController");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        } catch (ServletException ex) {

        }

    }
    public void editarAtleta(HttpServletRequest request, HttpServletResponse response) throws SQLException{
         try {
            request.setAttribute("operacao", "EditarAtleta");
            // para chave estrangeira
            //request.setAttribute("administrador", Administrador.obterAdministrador());

            int codAtleta = Integer.parseInt(request.getParameter("id"));

            Atleta atleta = Atleta.obterAtleta(codAtleta);
            request.setAttribute("atleta", atleta);
            RequestDispatcher view = request.getRequestDispatcher("/alterarDadosPessoais.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {
        }
    }
    public void confirmarEditarAtleta(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtIdAtleta"));
        String sexo = request.getParameter("optSexo");
        String rua = request.getParameter("txtRuaAtleta");
        String bairro = request.getParameter("txtBairroAtleta");
        String cidade = request.getParameter("txtCidadeAtleta");
        String estado = request.getParameter("txtEstadoAtleta");
        String pais = request.getParameter("txtPais");
        String tamCamisa = request.getParameter("optTamanhoCamisa");
        String telefoneFixo = request.getParameter("txtTelefoneFixo");
        String telefoneCelular = request.getParameter("txtTelefoneCelular");
        String cpf = request.getParameter("txtCpf");
        String apelido = request.getParameter("txtApelido");
        String nomeDaEquipe = request.getParameter("txtNomeEquipe");
        String dataNascimento = request.getParameter("txtDataNascimento");
        String nome = request.getParameter("txtNomeAtleta");
        String email = request.getParameter("txtEmail");
        String login = request.getParameter("txtLoginAtleta");
        String senha = request.getParameter("txtSenhaAtleta");

        try {
            Atleta atleta = new Atleta(id, nome, dataNascimento, apelido, cpf, tamCamisa, sexo, telefoneFixo, telefoneCelular, rua, bairro, cidade, estado, pais, login, senha, email);
            atleta.alterar();
            RequestDispatcher view = request.getRequestDispatcher("/atletaHome.jsp");
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
            Logger.getLogger(ManterAtletaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterAtletaController.class.getName()).log(Level.SEVERE, null, ex);
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
