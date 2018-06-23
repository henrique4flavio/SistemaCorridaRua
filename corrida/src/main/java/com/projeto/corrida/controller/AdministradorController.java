package com.projeto.corrida.controller;

import com.projeto.corrida.model.Administrador;
import com.projeto.corrida.repository.AdministradorRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
import java.util.Optional;
@Controller
@RequestMapping("/admin")
public class AdministradorController extends HttpServlet {


    @Autowired
    private AdministradorRepository administradorRepository;

    @GetMapping(value = "listar")
    public String administradores(Model model) {
        model.addAttribute("administradores", administradorRepository.findAll());
        model.addAttribute("operacao", "listar");
        model.addAttribute("title", "Administradores");
        model.addAttribute("botaoOperacao", "Listar Admin");

        return "admin/pesquisaAdministrador";
    }
    @GetMapping(value = "")
    public String administradorHome1(Model model) {


        return "admin/administradorHome";
    }
    @GetMapping(value = "home")
    public String administradorHome2(Model model) {


        return "admin/administradorHome";
    }
    @GetMapping(value = "add")
    public String displayCorredorForm(Model model) {
        model.addAttribute("title", "Adicionar administrador");
        model.addAttribute("operacao", "adicionar");
        model.addAttribute("botaoOperacao", "Adicionar administrador");
        return "admin/manterAdministrador";
    }

    @PostMapping(value = "add")
    public String processCorredorForm(@ModelAttribute Administrador administrador) {
        administradorRepository.save(administrador);
        return "redirect:/admin/listar"; // url para qual página quero voltar.
    }

    @GetMapping(value = "edit/{id}") // site.com/corredor/edit
    public String administradorEdit(Model model, @PathVariable Long id) {
        Optional<Administrador> administrador = administradorRepository.findById(id);
        model.addAttribute("operacao", "editar");
        model.addAttribute("botaoOperacao", "Editar administrador");
        model.addAttribute("title", "Editar administrador");
        if (administrador.isPresent()){
            model.addAttribute("administrador", administrador.get());
        }
        model.addAttribute("title", "Editar administrador");
        return "admin/manterAdministrador";
    }

    @PostMapping(value = "edit/{id}") // site.com/corredor/edit/1/
    public String edit(@ModelAttribute Administrador administrador, Model model,
                       @PathVariable Long id) throws Exception {
        if (id.equals(administrador.getId())) {
            administradorRepository.save(administrador);
        } else {
            model.addAttribute("error", "Dados incorretos");
        }
        return "redirect:/admin/listar";
    }

    @GetMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String administradorDelete(Model model, @PathVariable Long id) {
        Optional<Administrador> administrador = administradorRepository.findById(id);
        model.addAttribute("operacao", "deletar");
        model.addAttribute("botaoOperacao", "Excluir administrador");
        model.addAttribute("title", "Excluir administrador");
        if (administrador.isPresent()) {
            model.addAttribute("administrador", administrador.get());
        }
        model.addAttribute("tittle", "Excluir administrador");
        return "admin/manterAdministrador";
    }

    @PostMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String delete(@PathVariable Long id, @ModelAttribute Administrador administrador) {
        administradorRepository.delete(administrador);
        return "redirect:/admin/listar";
    }
    @GetMapping(value = "relatorio")
    @ResponseBody
    public String RelatorioOrganizadores(HttpServletResponse response,HttpServletRequest request) throws JRException, IOException, ClassNotFoundException, SQLException {
        Connection conexao = null;
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://localhost/corrida", "root", "");

        Map<String,Object> params = new HashMap<>();

        InputStream jasperStream = this.getClass().getResourceAsStream("/relatorios/RelatorioOrganizadores.jasper");
      //  String relatorio = getServletContext().getRealPath("/relatorios") + "/Relatorio_Administradores.jasper";
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, params,conexao);
       // JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);


      //  response.setContentType("application/x-pdf");
       // response.setHeader("Content-disposition", "inline; filename=report_atleta.pdf");
        byte[] relat = JasperExportManager.exportReportToPdf(jasperPrint); // exportar para pdf
        response.setHeader("Content-Disposition", "attachment;filename=Relatorio Organizadores.pdf");
        response.setContentType("application/x-pdf");
        ServletOutputStream out = response.getOutputStream();

        response.getOutputStream().write(relat);

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);



        return "redirect:/admin/home";
    }

}
