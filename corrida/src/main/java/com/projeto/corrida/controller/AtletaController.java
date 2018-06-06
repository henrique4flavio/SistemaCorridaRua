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
    private AtletaRepository AtletaRepository;

    @GetMapping(value = "")
    public String atletas(Model model) {
        model.addAttribute("atletas", AtletaRepository.findAll());
        return "atletas/atletas";
    }

    @GetMapping(value = "add")
    public String displayCorredorForm(Model model) {
        model.addAttribute("tittle", "Adicionar Atleta");
        return "atletas/add";
    }

    @PostMapping(value = "add")
    public String processCorredorForm(@ModelAttribute Atleta Atleta) {
        AtletaRepository.save(Atleta);
        return "redirect:/atletas/add"; // url para qual página quero voltar.
    }

    @GetMapping(value = "edit/{id}") // site.com/corredor/edit
    public String corredorEdit(Model model, @PathVariable Long id) {
        Optional<Atleta> Atleta = AtletaRepository.findById(id);
        if (Atleta.isPresent()){
            model.addAttribute("Atleta", Atleta.get());
        }
        model.addAttribute("title", "Editar Atleta");
        return "atletas/edit";
    }

    @PostMapping(value = "edit/{id}") // site.com/corredor/edit/1/
    public String edit(@ModelAttribute Atleta Atleta, Model model,
                       @PathVariable Long id) throws Exception {
        if (id.equals(Atleta.getId())) {
            AtletaRepository.save(Atleta);
        } else {
            model.addAttribute("error", "Dados incorretos");
        }
        return "redirect:/atletas";
    }

    @GetMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String AtletaDelete(Model model, @PathVariable Long id) {
        Optional<Atleta> Atleta = AtletaRepository.findById(id);
        if (Atleta.isPresent()) {
            model.addAttribute("Atleta", Atleta.get());
        }
        model.addAttribute("tittle", "Excluir Atleta");
        return "atletas/delete";
    }

    @PostMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String delete(@PathVariable Long id, @ModelAttribute Atleta Atleta) {
        AtletaRepository.delete(Atleta);
        return "redirect:/atletas";
    }

}
