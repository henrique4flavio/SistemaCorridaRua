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
@RequestMapping(value = "prova")
public class ProvaController {
    @Autowired
    private ProvaRepository provaRepository;
    @Autowired
    private OrganizadorRepository organizadorRepository;
    @Autowired
    private KitRepository kitRepository;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("provas", provaRepository.findAll());
        return "prova/listarProvas";
    }

    @GetMapping(value = "/add")
    public String getAdd(Model model) {
        model.addAttribute("tittle", "Adicionar prova");
        model.addAttribute("operacao", "adicionar");
        model.addAttribute("botaoOperacao", "Cadastrar prova");
        model.addAttribute("organizadores", organizadorRepository.findAll());
        model.addAttribute("kits", kitRepository.findAll());

        return "prova/formProvas";
    }

    @PostMapping(value = "/add")
    public String postAdd(@ModelAttribute Prova prova) {

        provaRepository.save(prova);
        return "redirect:/prova";
    }

    @GetMapping(value = "/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        Optional<Prova> prova = provaRepository.findById(id);
        model.addAttribute("tittle", "Editar prova");
        model.addAttribute("operacao", "editar");
        model.addAttribute("botaoOperacao", "Editar prova");
        model.addAttribute("eventos", provaRepository.findAll());
        model.addAttribute("organizadores", organizadorRepository.findAll());
        model.addAttribute("kits", kitRepository.findAll());

        if (prova.isPresent()) {
            model.addAttribute("prova", prova.get());
        }
        return "prova/formProva";
    }

    @PostMapping(value = "/edit/{id}")
    public String postEdit(@ModelAttribute Prova prova, Model model,
                           @PathVariable Long id) throws Exception {

        provaRepository.save(prova);
        return "redirect:/prova";
    }

    @GetMapping(value = "/delete/{id}")
    public String getDelete(Model model, @PathVariable Long id) {
        Optional<Prova> prova = provaRepository.findById(id);

        if (prova.isPresent()) {
            model.addAttribute("prova", prova.get());
        }
        model.addAttribute("tittle", "Excluir evento");
        model.addAttribute("operacao", "excluir");
        model.addAttribute("botaoOperacao", "Excluir evento");
        return "prova/formProvas";
    }

    @PostMapping(value = "/delete/{id}")
    public String postDelete(@PathVariable Long id, @ModelAttribute Prova prova) {
        provaRepository.delete(prova);
        return "redirect:/prova";
    }
}

