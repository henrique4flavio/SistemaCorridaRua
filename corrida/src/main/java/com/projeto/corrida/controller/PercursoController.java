package com.projeto.corrida.controller;

import com.projeto.corrida.model.Percurso;
import com.projeto.corrida.repository.PercursoRepository;
import com.projeto.corrida.repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/percurso")
public class PercursoController {

    @Autowired
    private PercursoRepository percursoRepository;

    @Autowired
    private ProvaRepository provaRepository;


    @GetMapping(value = "listar")
    public String listaPercurso(Model model) {
        model.addAttribute("percursos", percursoRepository.findAll());
        model.addAttribute("operacao", "listar");
        model.addAttribute("title", "Lista de percursos");
        model.addAttribute("botaoOperacao", "Adicionar Percurso");

        return "percurso/pesquisaPercurso";
    }

    @GetMapping(value = "add")
    public String displayPercursoForm(Model model) {
        model.addAttribute("title", "Adicionar prova");
        model.addAttribute("operacao", "adicionar");
        model.addAttribute("provas", provaRepository.findAll());
        model.addAttribute("botaoOperacao", "Cadastrar percurso");
        return "percurso/manterPercurso";
    }

    @PostMapping(value = "add")
    public String processProvaForm(@ModelAttribute Percurso percurso) {
        percursoRepository.save(percurso);
        return "redirect:/percurso/listar";
    }

    @GetMapping(value = "edit/{id}")
    public String percursoEdit(Model model, @PathVariable Long id) {
        Optional<Percurso> percurso = percursoRepository.findById(id);
        model.addAttribute("operacao", "editar");
        model.addAttribute("botaoOperacao", "Editar percurso");
        model.addAttribute("title", "Editar percurso");
        model.addAttribute("provas", provaRepository.findAll());

        model.addAttribute("percursos",percursoRepository.findAll());

        if (percurso.isPresent()) {
            model.addAttribute("percurso", percurso.get());
        }
        model.addAttribute("title", "Editar Percurso");
        return "percurso/manterPercurso";
    }

    @PostMapping(value = "edit/{id}")
    public String edit(@ModelAttribute Percurso percurso, Model model,
                           @PathVariable Long id) throws Exception {
        if (id.equals(percurso.getId())) {
            percursoRepository.save(percurso);
        } else {
            model.addAttribute("error", "Dados incorretos");
        }
        return "redirect:/percurso/listar";
    }

    @GetMapping(value = "delete/{id}")
    public String percursoDelete(Model model, @PathVariable Long id) {
        Optional<Percurso> percurso = percursoRepository.findById(id);

        model.addAttribute("provas", provaRepository.findAll());
        model.addAttribute("operacao", "deletar");
        model.addAttribute("botaoOperacao", "Excluir percurso");
        model.addAttribute("title", "Excluir percurso");

        if (percurso.isPresent()) {
            model.addAttribute("percurso", percurso.get());
        }
        model.addAttribute("title", "Excluir percurso");
        return "percurso/manterPercurso";
    }

    @PostMapping(value = "delete/{id}")
    public String delete(@PathVariable Long id, @ModelAttribute Percurso percurso) {
        percursoRepository.delete(percurso);
        return "redirect:/percurso/listar";
    }
}