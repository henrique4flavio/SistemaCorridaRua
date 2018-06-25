package com.projeto.corrida.controller;

import com.projeto.corrida.model.Lote;
import com.projeto.corrida.model.Percurso;
import com.projeto.corrida.repository.LoteRepository;
import com.projeto.corrida.repository.OrganizadorRepository;
import com.projeto.corrida.repository.PercursoRepository;
import com.projeto.corrida.repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/lote")
public class LoteController {

    @Autowired
    private OrganizadorRepository organizadorRepository;
    @Autowired
    private ProvaRepository  provaRepository;
    @Autowired
    private LoteRepository  loteRepository;

    @GetMapping(value = "listar")
    public String listaPercurso(Model model) {
        model.addAttribute("lotes", loteRepository.findAll());
        model.addAttribute("operacao", "listar");
        model.addAttribute("title", "Lotes");
        model.addAttribute("botaoOperacao", "Adicionar Lote");

        return "lote/pesquisaLote";
    }

    @GetMapping(value = "add")
    public String displayCorredorForm(Model model) {
        model.addAttribute("title", "Adicionar lote");
        model.addAttribute("operacao", "adicionar");
        model.addAttribute("provas", provaRepository.findAll());

        model.addAttribute("botaoOperacao", "Adicionar lote");
        return "lote/manterLote";
    }

    @PostMapping(value = "add")
    public String processKitForm(@ModelAttribute Lote lote) {
        loteRepository.save(lote);
        return "redirect:/lote/listar"; // url para qual página quero voltar.
    }

    @GetMapping(value = "edit/{id}") // site.com/corredor/edit
    public String percursoEdit(Model model, @PathVariable Long id) {
        Optional<Lote> lote = loteRepository.findById(id);
        model.addAttribute("operacao", "editar");
        model.addAttribute("botaoOperacao", "Editar lote");
        model.addAttribute("title", "Editar lote");
        model.addAttribute("provas", provaRepository.findAll());

        model.addAttribute("lotes",loteRepository.findAll());

        if (lote.isPresent()){
            model.addAttribute("lote", lote.get());
        }
        model.addAttribute("title", "Editar lote");
        return "lote/manterLote";
    }

    @PostMapping(value = "edit/{id}") // site.com/corredor/edit/1/
    public String edit(@ModelAttribute Lote lote, Model model,
                       @PathVariable Long id) throws Exception {
        if (id.equals(lote.getId())) {
            loteRepository.save(lote);
        } else {
            model.addAttribute("error", "Dados incorretos");
        }
        return "redirect:/lote/listar";
    }

    @GetMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String loteDelete(Model model, @PathVariable Long id) {
        Optional<Lote> lote = loteRepository.findById(id);
        model.addAttribute("provas", provaRepository.findAll());

        model.addAttribute("operacao", "deletar");
        model.addAttribute("botaoOperacao", "Excluir lote");
        model.addAttribute("title", "Excluir lote");
        if (lote.isPresent()) {
            model.addAttribute("lote", lote.get());
        }
        model.addAttribute("tittle", "Excluir lote");
        return "lote/manterLote";
    }

    @PostMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String delete(@PathVariable Long id, @ModelAttribute Lote lote) {
        loteRepository.delete(lote);
        return "redirect:/lote/listar";
    }

}
