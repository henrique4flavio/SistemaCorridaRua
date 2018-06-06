package com.projeto.corrida.controller;

import com.projeto.corrida.model.Administrador;
import com.projeto.corrida.repository.AdministradorRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@Controller
@RequestMapping("/admin")
public class AdministradorController {


    @Autowired
    private AdministradorRepository administradorRepository;

    @GetMapping(value = "")
    public String administradores(Model model) {
        model.addAttribute("administradores", administradorRepository.findAll());
        return "admin/administradores";
    }

    @GetMapping(value = "add")
    public String displayCorredorForm(Model model) {
        model.addAttribute("tittle", "Adicionar administrador");
        return "admin/add";
    }

    @PostMapping(value = "add")
    public String processCorredorForm(@ModelAttribute Administrador administrador) {
        administradorRepository.save(administrador);
        return "redirect:/admin/add"; // url para qual página quero voltar.
    }

    @GetMapping(value = "edit/{id}") // site.com/corredor/edit
    public String corredorEdit(Model model, @PathVariable Long id) {
        Optional<Administrador> administrador = administradorRepository.findById(id);
        if (administrador.isPresent()){
            model.addAttribute("administrador", administrador.get());
        }
        model.addAttribute("title", "Editar administrador");
        return "admin/edit";
    }

    @PostMapping(value = "edit/{id}") // site.com/corredor/edit/1/
    public String edit(@ModelAttribute Administrador administrador, Model model,
                       @PathVariable Long id) throws Exception {
        if (id.equals(administrador.getId())) {
            administradorRepository.save(administrador);
        } else {
            model.addAttribute("error", "Dados incorretos");
        }
        return "redirect:/admin";
    }

    @GetMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String administradorDelete(Model model, @PathVariable Long id) {
        Optional<Administrador> administrador = administradorRepository.findById(id);
        if (administrador.isPresent()) {
            model.addAttribute("administrador", administrador.get());
        }
        model.addAttribute("tittle", "Excluir administrador");
        return "admin/delete";
    }

    @PostMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String delete(@PathVariable Long id, @ModelAttribute Administrador administrador) {
        administradorRepository.delete(administrador);
        return "redirect:/admin";
    }

}
