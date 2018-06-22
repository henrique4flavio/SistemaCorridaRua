package com.projeto.corrida.controller;

import com.projeto.corrida.model.Inscricao;
import com.projeto.corrida.repository.InscricaoRepository;
import com.projeto.corrida.repository.PercursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "inscricao")

public class InscricaoController {
    @Autowired
    private InscricaoRepository inscricaoRepository;
    @Autowired
    private PercursoRepository percursoRepository;
    @Autowired
    private PercursoRepository kitRepository;
    @Autowired
    private PercursoRepository atletaRepository;


    @GetMapping(value = "listar")
    public String listaInscricao(Model model) {
        model.addAttribute("percursos", inscricaoRepository.findAll());
        model.addAttribute("operacao", "listar");
        model.addAttribute("title", "Lista de inscrição");
        model.addAttribute("botaoOperacao", "Adicionar inscrição");

        return "inscricao/pesquisaInscricao";
    }

    @GetMapping(value = "add")
    public String displayCorredorForm(Model model) {
        model.addAttribute("title", "Adicionar inscrição");
        model.addAttribute("operacao", "adicionar");
        model.addAttribute("atletas", atletaRepository.findAll());
        model.addAttribute("kits", kitRepository.findAll());
        model.addAttribute("percursos", percursoRepository.findAll());
        model.addAttribute("botaoOperacao", "Adicionar inscricao");
        return "inscricao/manterInscricao";
    }

    @PostMapping(value = "add")
    public String processInscricaoForm(@ModelAttribute Inscricao inscricao) {
        inscricaoRepository.save(inscricao);
        return "redirect:/inscricao/listar"; // url para qual página quero voltar.
    }

    @GetMapping(value = "edit/{id}") // site.com/corredor/edit
    public String inscricaoEdit(Model model, @PathVariable Long id) {
        Optional<Inscricao> inscricao = inscricaoRepository.findById(id);
        model.addAttribute("operacao", "editar");
        model.addAttribute("botaoOperacao", "Editar inscricao");
        model.addAttribute("title", "Editar inscricao");
        model.addAttribute("atletas", atletaRepository.findAll());
        model.addAttribute("kits", kitRepository.findAll());
        model.addAttribute("percursos", percursoRepository.findAll());

        model.addAttribute("percursos",inscricaoRepository.findAll());

        if (inscricao.isPresent()){
            model.addAttribute("inscricao", inscricao.get());
        }
        model.addAttribute("title", "Editar inscricao");
        return "inscricao/manterInscricao";
    }

    @PostMapping(value = "edit/{id}") // site.com/corredor/edit/1/
    public String edit(@ModelAttribute Inscricao inscricao, Model model,
                       @PathVariable Long id) throws Exception {
        if (id.equals(inscricao.getId())) {
            inscricaoRepository.save(inscricao);
        } else {
            model.addAttribute("error", "Dados incorretos");
        }
        return "redirect:/inscricao/listar";
    }

    @GetMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String inscricaoDelete(Model model, @PathVariable Long id) {
        Optional<Inscricao> inscricao = inscricaoRepository.findById(id);

        model.addAttribute("atletas", atletaRepository.findAll());
        model.addAttribute("kits", kitRepository.findAll());
        model.addAttribute("percursos", percursoRepository.findAll());

        model.addAttribute("operacao", "deletar");
        model.addAttribute("botaoOperacao", "Excluir inscricao");
        model.addAttribute("title", "Excluir inscricao");
        if (inscricao.isPresent()) {
            model.addAttribute("inscricao", inscricao.get());
        }
        model.addAttribute("tittle", "Excluir inscricao");
        return "inscricao/manterInscricao";
    }

    @PostMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String delete(@PathVariable Long id, @ModelAttribute Inscricao inscricao) {
        inscricaoRepository.delete(inscricao);
        return "redirect:/inscricao/listar";
    }

}
