/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Marco
 */
public class RelatorioAtletaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("todosAtletas")) {
            todosAtletas(request, response);
        }
        if (acao.equals("atletasPorEstado")) {
            atletasPorEstado(request, response);
        } else {
            if (acao.equals("atletasPorCidade")) {
                atletasPorCidade(request, response);
            }
        }
    }

    protected void todosAtletas(HttpServletRequest request, HttpServletResponse response) {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/sccr", "root", "");
            HashMap parametros = new HashMap();
            // parametros.put("PAR_codCurso", Integer.parseInt(request.getParameter("txtCodCurso"))); //  relatorio que precisa de parametro
            String relatorio = getServletContext().getRealPath("/WEB-INF/relatorios") + "/Relatorio_Atletas.jasper";
            JasperPrint jp = JasperFillManager.fillReport(relatorio, parametros, conexao);
            byte[] relat = JasperExportManager.exportReportToPdf(jp); // exportar para pdf
            response.setHeader("Content-Disposition", "attachment;filename=relatorio.pdf");
            response.setContentType("application/pdf");
            response.getOutputStream().write(relat);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (!conexao.isClosed()) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    protected void atletasPorEstado(HttpServletRequest request, HttpServletResponse response) {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/sccr", "root", "");
            HashMap parametros = new HashMap();
            parametros.put("estado", request.getParameter("optEstado")); //  relatorio que precisa de parametro
            String relatorio = getServletContext().getRealPath("/WEB-INF/relatorios") + "/RelatorioAtleta_estado.jasper";
            JasperPrint jp = JasperFillManager.fillReport(relatorio, parametros, conexao);
            byte[] relat = JasperExportManager.exportReportToPdf(jp); // exportar para pdf
            response.setHeader("Content-Disposition", "attachment;filename=relatorio.pdf");
            response.setContentType("application/pdf");
            response.getOutputStream().write(relat);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (!conexao.isClosed()) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    protected void atletasPorCidade(HttpServletRequest request, HttpServletResponse response) {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/sccr", "root", "");
            HashMap parametros = new HashMap();
            parametros.put("cidade", request.getParameter("txtCidade")); //  relatorio que precisa de parametro
            String relatorio = getServletContext().getRealPath("/WEB-INF/relatorios") + "/RelatorioAtleta_Cidade.jasper";
            JasperPrint jp = JasperFillManager.fillReport(relatorio, parametros, conexao);
            byte[] relat = JasperExportManager.exportReportToPdf(jp); // exportar para pdf
            response.setHeader("Content-Disposition", "attachment;filename=relatorio.pdf");
            response.setContentType("application/pdf");
            response.getOutputStream().write(relat);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (!conexao.isClosed()) {
                    conexao.close();
                }
            } catch (SQLException ex) {
            }
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
            Logger.getLogger(RelatorioAtletaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RelatorioAtletaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RelatorioAtletaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RelatorioAtletaController.class.getName()).log(Level.SEVERE, null, ex);
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
