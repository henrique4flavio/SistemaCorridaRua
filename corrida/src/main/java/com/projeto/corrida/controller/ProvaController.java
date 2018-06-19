package com.projeto.corrida.controller;

import com.projeto.corrida.model.Prova;
import com.projeto.corrida.repository.KitRepository;
import com.projeto.corrida.repository.OrganizadorRepository;
import com.projeto.corrida.repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping(value = "/prova")
public class ProvaController {
    @Autowired
    private ProvaRepository provaRepository;
    @Autowired
    private OrganizadorRepository organizadorRepository;
    @Autowired
    private KitRepository kitRepository;

    @GetMapping(value = "listar")
    public String listaProva(Model model) {
        model.addAttribute("provas", provaRepository.findAll());
        model.addAttribute("operacao", "listar");
        model.addAttribute("title", "Lista de provas");
        model.addAttribute("botaoOperacao", "Adicionar Prova");

        return "prova/pesquisaProva";
    }

    @GetMapping(value = "gridProvas")
    public String gridProvas(Model model) {
        model.addAttribute("provas", provaRepository.findAll());
        model.addAttribute("operacao", "listar");
        model.addAttribute("title", "Lista de provas");
        model.addAttribute("botaoOperacao", "Adicionar Prova");

        return "prova/gridProvas";
    }



    @GetMapping(value = "add")
    public String displayCorredorForm(Model model) {
        model.addAttribute("title", "Adicionar kit");
        model.addAttribute("operacao", "adicionar");
        model.addAttribute("organizadores", organizadorRepository.findAll());
        model.addAttribute("kits", kitRepository.findAll());
        model.addAttribute("botaoOperacao", "Adicionar prova");
        return "prova/manterProva";
    }

    @PostMapping(value = "add")
    public String processKitForm(@ModelAttribute Prova prova) {
        provaRepository.save(prova);
        return "redirect:/prova/listar"; // url para qual página quero voltar.
    }

    @GetMapping(value = "edit/{id}") // site.com/corredor/edit
    public String provaEdit(Model model, @PathVariable Long id) {
        Optional<Prova> prova = provaRepository.findById(id);
        model.addAttribute("operacao", "editar");
        model.addAttribute("botaoOperacao", "Editar Prova");
        model.addAttribute("title", "Editar Prova");
        model.addAttribute("organizadores", organizadorRepository.findAll());
        model.addAttribute("kits", kitRepository.findAll());


        model.addAttribute("provas",provaRepository.findAll());

        if (prova.isPresent()){
            model.addAttribute("prova", prova.get());
        }
        model.addAttribute("title", "Editar Prova");
        return "prova/manterProva";
    }

    @PostMapping(value = "edit/{id}") // site.com/corredor/edit/1/
    public String edit(@ModelAttribute Prova prova, Model model,
                       @PathVariable Long id) throws Exception {
        if (id.equals(prova.getId())) {
            provaRepository.save(prova);
        } else {
            model.addAttribute("error", "Dados incorretos");
        }
        return "redirect:/prova/listar";
    }

    @GetMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String provaDelete(Model model, @PathVariable Long id) {
        Optional<Prova> prova = provaRepository.findById(id);
        model.addAttribute("organizadores", organizadorRepository.findAll());
        model.addAttribute("kits", kitRepository.findAll());
        model.addAttribute("operacao", "deletar");
        model.addAttribute("botaoOperacao", "Excluir Prova");
        model.addAttribute("title", "Excluir Prova");
        if (prova.isPresent()) {
            model.addAttribute("prova", prova.get());
        }
        model.addAttribute("title", "Excluir prova");
        return "prova/manterProva";
    }

    @PostMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String delete(@PathVariable Long id, @ModelAttribute Prova prova) {
        provaRepository.delete(prova);
        return "redirect:/prova/listar";
    }

}
