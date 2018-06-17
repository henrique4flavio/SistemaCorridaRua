package com.projeto.corrida.controller;

import com.projeto.corrida.model.Atleta;
import com.projeto.corrida.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/atleta")
public class AtletaController {
    @Autowired
    private AtletaRepository atletaRepository;

    @GetMapping
    public String atletas(Model model) {
        model.addAttribute("atletas", atletaRepository.findAll());
        return "atleta/atletas";
    }

    @GetMapping(value = "/add") // site.com/atleta/add
    public String displayAtletaForm(Model model) {
        model.addAttribute("tittle", "Adicionar atleta");
        return "atleta/add";
    }

    @PostMapping(value = "/add")
    public String processaAtletaForm(@ModelAttribute Atleta atleta, Model model) {
        atletaRepository.save(atleta);

        return "redirect:/atleta"; // url para qual página quero voltar.
    }

    @GetMapping(value = "/edit/{id}") // site.com/corredor/edit
    public String atletaEdit(Model model, @PathVariable Long id) {
        Optional<Atleta> atleta = atletaRepository.findById(id);
        model.addAttribute("tittle", "Editar atleta");

        if (atleta.isPresent()){
            model.addAttribute("atleta", atleta.get());
        }
        return "atleta/edit";
    }

    @PostMapping(value = "/edit/{id}") // site.com/atleta/edit/1/
    public String edit(@ModelAttribute Atleta atleta, Model model,
                       @PathVariable Long id) throws Exception {
        if (id.equals(atleta.getId())) {
            atletaRepository.save(atleta);
        } else {
            model.addAttribute("error", "Dados incorretos");
        }
        return "redirect:/atleta";
    }

    @GetMapping(value = "/delete/{id}") // site.com/corredor/delete/1
    public String atletaDelete(Model model, @PathVariable Long id) {
        Optional<Atleta> atleta = atletaRepository.findById(id);
        if (atleta.isPresent()) {
            model.addAttribute("atleta", atleta.get());
        }
        model.addAttribute("tittle", "Excluir atleta");
        return "atleta/delete";
    }

    @PostMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String delete(@PathVariable Long id, @ModelAttribute Atleta atleta) {
        atletaRepository.delete(atleta);
        return "redirect:/atleta";
    }

}
