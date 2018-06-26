package com.projeto.corrida.controller;

import com.projeto.corrida.model.Atleta;
import com.projeto.corrida.repository.AtletaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/atleta")
public class AtletaController {

    @Autowired
    private AtletaRepository atletaRepository;

    @GetMapping(value = "listar")
    public String atletas(Model model) {
        model.addAttribute("atletas", atletaRepository.findAll());
        model.addAttribute("operacao", "listar");
        model.addAttribute("title", "Atletas");
        model.addAttribute("botaoOperacao", "Atletas");

        return "atleta/pesquisaAtleta";
    }


    @GetMapping(value = "add")
    public String displayCorredorForm(Model model) {
        model.addAttribute("title", "Adicionar atleta");
        model.addAttribute("operacao", "adicionar");
        model.addAttribute("botaoOperacao", "Adicionar atleta");
        return "atleta/registro";
    }

    @PostMapping(value = "add")
    public String processCorredorForm(@ModelAttribute Atleta atleta) {
        atletaRepository.save(atleta);
        return "login"; // url para qual página quero voltar.
    }

    @GetMapping(value = "edit/{id}") // site.com/corredor/edit
    public String atletaEdit(Model model, @PathVariable Long id) {
        Optional<Atleta> atleta = atletaRepository.findById(id);
        model.addAttribute("operacao", "editar");
        model.addAttribute("botaoOperacao", "Editar atleta");
        model.addAttribute("title", "Editar atleta");
        if (atleta.isPresent()){
            model.addAttribute("atleta", atleta.get());
        }
        model.addAttribute("title", "Editar atleta");
        return "atleta/manterAtleta";
    }

    @PostMapping(value = "edit/{id}") // site.com/corredor/edit/1/
    public String edit(@ModelAttribute Atleta atleta, Model model,
                       @PathVariable Long id) throws Exception {
        if (id.equals(atleta.getId())) {
            atletaRepository.save(atleta);
        } else {
            model.addAttribute("error", "Dados incorretos");
        }
        model.addAttribute("atleta",atleta);
        return "atleta/atletaHome";
    }

    @GetMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String atletaDelete(Model model, @PathVariable Long id) {
        Optional<Atleta> atleta = atletaRepository.findById(id);

        model.addAttribute("operacao", "deletar");
        model.addAttribute("botaoOperacao", "Excluir atleta");
        model.addAttribute("title", "Excluir atleta");
        if (atleta.isPresent()) {
            model.addAttribute("atleta", atleta.get());
        }
        model.addAttribute("tittle", "Excluir atleta");
        return "atleta/manterAtleta";
    }

    @PostMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String delete(@PathVariable Long id, @ModelAttribute Atleta atleta) {
        atletaRepository.delete(atleta);
        return "redirect:/atleta/listar";
    }

}
