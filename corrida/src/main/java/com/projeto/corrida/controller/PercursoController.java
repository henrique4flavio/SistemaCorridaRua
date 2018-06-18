package com.projeto.corrida.controller;

import com.projeto.corrida.model.Percurso;
import com.projeto.corrida.repository.PercursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "percurso")
public class PercursoController {

    @Autowired
    private PercursoRepository percursoRepository;


    @GetMapping
    public String get(Model model) {
        model.addAttribute("percursos", percursoRepository.findAll());
        return "percurso/listarPercursos";
    }

    @GetMapping(value = "/add")
    public String getAdd(Model model) {
        model.addAttribute("title", "Adicionar percurso");
        model.addAttribute("operacao", "adicionar");
        model.addAttribute("botaoOperacao", "Cadastrar percurso");
        return "percurso/formPercursos";
    }

    @PostMapping(value = "/add")
    public String postAdd(@ModelAttribute Percurso percurso) {
        percursoRepository.save(percurso);
        return "redirect:/percurso";
    }

    @GetMapping(value = "/edit/{codPercurso}")
    public String getEdit(Model model, @PathVariable Long codPercurso) {
        Optional<Percurso> percurso = percursoRepository.findById(codPercurso);
        model.addAttribute("title", "Editar percurso");
        model.addAttribute("operacao", "editar");
        model.addAttribute("botaoOperacao", "Editar percurso");
        if (percurso.isPresent()) {
            model.addAttribute("percurso", percurso.get());
        }

        return "percurso/formPercursos";
    }

    @PostMapping(value = "/edit/{codPercuso}")
    public String postEdit(@ModelAttribute Percurso percurso, Model model,
                           @PathVariable Long codPercuso) throws Exception {
        percursoRepository.save(percurso);
        return "redirect:/percurso";
    }

    @GetMapping(value = "/delete/{codPercurso}")
    public String getDelete(Model model, @PathVariable Long codPercurso) {
        Optional<Percurso> percurso = percursoRepository.findById(codPercurso);

        if (percurso.isPresent()) {
            model.addAttribute("percurso", percurso.get());
        }
        model.addAttribute("title", "Excluir percurso");
        model.addAttribute("operacao", "excluir");
        model.addAttribute("botaoOperacao", "Excluir percurso");
        return "percurso/formPercursos";
    }

    @PostMapping(value = "/delete/{codPercurso}")
    public String postDelete(@PathVariable Long codPercurso, @ModelAttribute Percurso percurso) {
        percursoRepository.delete(percurso);
        return "redirect:/percurso";
    }
}