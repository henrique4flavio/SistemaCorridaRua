package com.projeto.corrida.controller;

import com.projeto.corrida.model.Organizador;
import com.projeto.corrida.repository.AdministradorRepository;
import com.projeto.corrida.repository.OrganizadorRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
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
@RequestMapping("/organizador")
public class OrganizadorController {


    @Autowired
    private OrganizadorRepository organizadorRepository;
    @Autowired
    private AdministradorRepository administradorRepository;

    @GetMapping(value = "listar")
    public String listarOrganizadores(Model model) {
        model.addAttribute("organizadores", organizadorRepository.findAll());
        model.addAttribute("operacao", "listar");
        model.addAttribute("title", "Organizadores");
        model.addAttribute("botaoOperacao", "Listar organizador");

        return "organizador/pesquisaOrganizador";
    }

    @GetMapping(value = "")
    public String organizadores(Model model) {

        return "organizador/organizadorHome";
    }
    @GetMapping(value = "home")
    public String organizadorHome(Model model) {
        model.addAttribute("organizadores", organizadorRepository.findAll());
        model.addAttribute("operacao", "listar");
        model.addAttribute("title", "Lista organizadores");
        model.addAttribute("botaoOperacao", "Listar organizador");

        return "organizador/organizadorHome";
    }

    @GetMapping(value = "add")
    public String displayCorredorForm(Model model) {
        model.addAttribute("title", "Adicionar organizador");
        model.addAttribute("administradores", administradorRepository.findAll());
        model.addAttribute("operacao", "adicionar");
        model.addAttribute("botaoOperacao", "Adicionar organizador");
        return "organizador/manterOrganizador";
    }


    @PostMapping(value = "add")
    public String processCorredorForm(@ModelAttribute Organizador organizador) {
        organizadorRepository.save(organizador);
        return "redirect:/organizador/listar"; // url para qual página quero voltar.
    }

    @GetMapping(value = "edit/{id}") // site.com/corredor/edit
    public String administradorEdit(Model model, @PathVariable Long id) {
        Optional<Organizador> organizador = organizadorRepository.findById(id);
        model.addAttribute("operacao", "editar");
        model.addAttribute("botaoOperacao", "Editar organizador");
        model.addAttribute("tittle", "Editar organizador");
        model.addAttribute("administradores", administradorRepository.findAll());
        if (organizador.isPresent()){
            model.addAttribute("organizador", organizador.get());
        }
        model.addAttribute("title", "Editar organizador");
        return "organizador/manterOrganizador";
    }

    @PostMapping(value = "edit/{id}") // site.com/corredor/edit/1/
    public String edit(@ModelAttribute Organizador organizador, Model model,
                       @PathVariable Long id) throws Exception {
        if (id.equals(organizador.getId())) {
            organizadorRepository.save(organizador);
        } else {
            model.addAttribute("error", "Dados incorretos");
        }
        return "redirect:/organizador/listar";
    }

    @GetMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String organizadorDelete(Model model, @PathVariable Long id) {
        Optional<Organizador> organizador = organizadorRepository.findById(id);
        model.addAttribute("operacao", "deletar");
        model.addAttribute("botaoOperacao", "Excluir organizador");
        model.addAttribute("title", "Excluir Organizador");
        model.addAttribute("administradores", administradorRepository.findAll());
        if (organizador.isPresent()) {
            model.addAttribute("organizador", organizador.get());
        }
        model.addAttribute("title", "Excluir organizador");
        return "organizador/manterOrganizador";
    }

    @PostMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String delete(@PathVariable Long id, @ModelAttribute Organizador organizador) {
        organizadorRepository.delete(organizador);
        return "redirect:/organizador/listar";
    }
    @GetMapping(value = "relatorio")
    @ResponseBody
    public String RelatorioKit(HttpServletResponse response, HttpServletRequest request) throws JRException, IOException, ClassNotFoundException, SQLException {
        Connection conexao = null;
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://localhost/corrida", "root", "");

        Map<String,Object> params = new HashMap<>();

        InputStream jasperStream = this.getClass().getResourceAsStream("/relatorios/RelatorioListaKit.jasper");
        //  String relatorio = getServletContext().getRealPath("/relatorios") + "/Relatorio_Administradores.jasper";
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, params,conexao);
        // JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);


        //  response.setContentType("application/x-pdf");
        // response.setHeader("Content-disposition", "inline; filename=report_atleta.pdf");
        byte[] relat = JasperExportManager.exportReportToPdf(jasperPrint); // exportar para pdf
        response.setHeader("Content-Disposition", "attachment;filename=Relatorio Lista Kit.pdf");
        response.setContentType("application/x-pdf");
        ServletOutputStream out = response.getOutputStream();

        response.getOutputStream().write(relat);

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);



        return "redirect:/admin/home";
    }




}
