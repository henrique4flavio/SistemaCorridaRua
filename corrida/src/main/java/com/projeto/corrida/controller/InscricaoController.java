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


    @GetMapping
    public String get(Model model) {
        model.addAttribute("inscricoes", inscricaoRepository.findAll());
        return "inscricao/listarInscricoes";
    }

    @GetMapping(value = "/add")
    public String getAdd(Model model) {
        model.addAttribute("title", "Adicionar inscricao");
        model.addAttribute("operacao", "adicionar");
        model.addAttribute("botaoOperacao", "Cadastrar inscricao");
        model.addAttribute("percursos", percursoRepository.findAll());
        return "inscricao/formInscricoes";
    }

    @PostMapping(value = "/add")
    public String postAdd(@ModelAttribute Inscricao inscricao) {

        inscricaoRepository.save(inscricao);
        return "redirect:/inscricao";
    }

    @GetMapping(value = "/edit/{codInscricao}")
    public String getEdit(Model model, @PathVariable Long codInscricao) {
        Optional<Inscricao> inscricao = inscricaoRepository.findById(codInscricao);
        model.addAttribute("title", "Editar inscricao");
        model.addAttribute("operacao", "editar");
        model.addAttribute("botaoOperacao", "Editar inscricao");
        model.addAttribute("percursos", percursoRepository.findAll());

        if (inscricao.isPresent()) {
            model.addAttribute("inscricao", inscricao.get());
        }
        return "inscricao/formInscricoes";
    }

    @PostMapping(value = "/edit/{codInscricao}")
    public String postEdit(@ModelAttribute Inscricao inscricao, Model model,
                           @PathVariable Long codInscricao) throws Exception {


        inscricaoRepository.save(inscricao);
        return "redirect:/inscricao";
    }

    @GetMapping(value = "/delete/{codInscricao}")
    public String getDelete(Model model, @PathVariable Long codInscricao) {
        Optional<Inscricao> inscricao = inscricaoRepository.findById(codInscricao);

        if (inscricao.isPresent()) {
            model.addAttribute("inscricao", inscricao.get());
        }
        model.addAttribute("title", "Excluir inscricao");
        model.addAttribute("operacao", "excluir");
        model.addAttribute("botaoOperacao", "Excluir inscricao");
        return "inscricao/formInscricoes";
    }

    @PostMapping(value = "/delete/{codInscricao}")
    public String postDelete(@PathVariable Long codInscricao, @ModelAttribute Inscricao inscricao) {
        inscricaoRepository.delete(inscricao);
        return "redirect:/inscricao";
    }
}
