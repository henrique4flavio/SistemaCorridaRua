package com.projeto.corrida.controller;

import com.projeto.corrida.model.Administrador;
import com.projeto.corrida.model.Kit;
import com.projeto.corrida.repository.AdministradorRepository;
import com.projeto.corrida.repository.KitRepository;
import com.projeto.corrida.repository.OrganizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/kit")
public class KitController {


    @Autowired
    private KitRepository kitRepository;
    @Autowired
    private OrganizadorRepository  organizadorRepository;

    @GetMapping(value = "listar")
    public String listaKit(Model model) {
        model.addAttribute("kits", kitRepository.findAll());
        model.addAttribute("operacao", "listar");
        model.addAttribute("title", "Lista de Kits");
        model.addAttribute("botaoOperacao", "Adicionar Kit");

        return "kit/pesquisaKit";
    }

    @GetMapping(value = "add")
    public String displayCorredorForm(Model model) {
        model.addAttribute("title", "Adicionar kit");
        model.addAttribute("operacao", "adicionar");
        model.addAttribute("organizadores", organizadorRepository.findAll());
        model.addAttribute("botaoOperacao", "Adicionar kit");
        return "kit/manterKit";
    }

    @PostMapping(value = "add")
    public String processKitForm(@ModelAttribute Kit kit) {
        kitRepository.save(kit);
        return "redirect:/kit/listar"; // url para qual página quero voltar.
    }

    @GetMapping(value = "edit/{id}") // site.com/corredor/edit
    public String kitEdit(Model model, @PathVariable Long id) {
        Optional<Kit> kit = kitRepository.findById(id);
        model.addAttribute("operacao", "editar");
        model.addAttribute("botaoOperacao", "Editar Kit");
        model.addAttribute("title", "Editar Kit");
        model.addAttribute("organizadores", organizadorRepository.findAll());

        model.addAttribute("kits",kitRepository.findAll());

        if (kit.isPresent()){
            model.addAttribute("kit", kit.get());
        }
        model.addAttribute("title", "Editar Kit");
        return "kit/manterKit";
    }

    @PostMapping(value = "edit/{id}") // site.com/corredor/edit/1/
    public String edit(@ModelAttribute Kit kit, Model model,
                       @PathVariable Long id) throws Exception {
        if (id.equals(kit.getId())) {
            kitRepository.save(kit);
        } else {
            model.addAttribute("error", "Dados incorretos");
        }
        return "redirect:/kit/listar";
    }

    @GetMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String administradorDelete(Model model, @PathVariable Long id) {
        Optional<Kit> kit = kitRepository.findById(id);
        model.addAttribute("organizadores", organizadorRepository.findAll());

        model.addAttribute("operacao", "deletar");
        model.addAttribute("botaoOperacao", "Excluir Administrador");
        model.addAttribute("title", "Excluir Administrador");
        if (kit.isPresent()) {
            model.addAttribute("kit", kit.get());
        }
        model.addAttribute("tittle", "Excluir administrador");
        return "kit/manterKit";
    }

    @PostMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String delete(@PathVariable Long id, @ModelAttribute Kit kit) {
        kitRepository.delete(kit);
        return "redirect:/kit/listar";
    }

}
