package com.projeto.corrida.controller;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/relatorioLote")
public class RelatorioLoteController extends HttpServlet {
    @GetMapping(value = "lotes")
    @ResponseBody
    public String RelatorioOrganizadores(HttpServletResponse response, HttpServletRequest request) throws JRException, IOException, ClassNotFoundException, SQLException {
        Connection conexao = null;
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://localhost/corrida", "root", "");

        Map<String,Object> params = new HashMap<>();

        InputStream jasperStream = this.getClass().getResourceAsStream("/relatorios/Relatorio_Lotes.jasper");
        //  String relatorio = getServletContext().getRealPath("/relatorios") + "/Relatorio_Administradores.jasper";
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, params,conexao);
        // JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);


        //  response.setContentType("application/x-pdf");
        // response.setHeader("Content-disposition", "inline; filename=report_atleta.pdf");
        byte[] relat = JasperExportManager.exportReportToPdf(jasperPrint); // exportar para pdf
        response.setHeader("Content-Disposition", "attachment;filename=Relatorio Lotes.pdf");
        response.setContentType("application/x-pdf");
        ServletOutputStream out = response.getOutputStream();

        response.getOutputStream().write(relat);

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);



        return "redirect:/admin/home";
    }

}
