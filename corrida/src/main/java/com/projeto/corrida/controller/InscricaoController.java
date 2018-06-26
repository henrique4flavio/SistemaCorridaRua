package com.projeto.corrida.controller;

import com.projeto.corrida.model.Inscricao;
import com.projeto.corrida.repository.AtletaRepository;
import com.projeto.corrida.repository.InscricaoRepository;
import com.projeto.corrida.repository.KitRepository;
import com.projeto.corrida.repository.PercursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/inscricao")
public class InscricaoController {
    private InscricaoRepository inscricaoRepository;
    private AtletaRepository atletaRepository;
    private PercursoRepository percursoRepository;
    private KitRepository kitRepository;

    @Autowired
    public InscricaoController(InscricaoRepository inscricaoRepository,
                               AtletaRepository atletaRepository,
                               PercursoRepository percursoRepository,
                               KitRepository kitRepository) {
        this.inscricaoRepository = inscricaoRepository;
        this.atletaRepository = atletaRepository;
        this.percursoRepository = percursoRepository;
        this.kitRepository = kitRepository;
    }

    @GetMapping(value = "")
    public String inscricoes(Model model){
        model.addAttribute("operacao", "listar");
        model.addAttribute("title", "Inscrições");
        model.addAttribute("inscricoes", inscricaoRepository.findAll());
        model.addAttribute("botaoOperacao", "Listar inscrições");
        return "inscricao/pesquisar";
    }

    @GetMapping(value = "add/{id}")
    public String getInscricoesAdd(Model model, @PathVariable Long id){


        model.addAttribute("operacao", "adicionar");
        model.addAttribute("atletas", atletaRepository.findAll());
        model.addAttribute("percursos", percursoRepository.findAll());
        model.addAttribute("prova", percursoRepository.findById(id));
        model.addAttribute("kits", kitRepository.findAll());
        model.addAttribute("title", "Adicionar inscrição");
        model.addAttribute("botaoOperacao", "Adicionar inscrição");
        return "inscricao/manter";
    }

    @PostMapping(value = "add")
    public String postInscricoesAdd(Model model, @ModelAttribute Inscricao inscricao){
        model.addAttribute("title", "Adicionar inscrição");
        inscricaoRepository.save(inscricao);
        return "redirect:/inscricao";
    }

    @GetMapping(value = "edit/{id}")
    public String getCorridaEdit(Model model, @PathVariable Long id) {
        model.addAttribute("atletas", atletaRepository.findAll());
        model.addAttribute("percursos", percursoRepository.findAll());
        model.addAttribute("kits", kitRepository.findAll());
        model.addAttribute("operacao", "editar");
        model.addAttribute("botaoOperacao", "Editar inscrição");
        model.addAttribute("title", "Editar inscrição");
        Optional<Inscricao> inscricao = inscricaoRepository.findById(id);
        if (inscricao.isPresent()){
            model.addAttribute("inscricao", inscricao.get());
        }
        return "inscricao/manter";
    }

    @PostMapping(value = "edit/{id}")
    public String postInscricaoEdit(@ModelAttribute Inscricao inscricao, Model model,
                                    @PathVariable Long id) throws Exception {
        if (id.equals(inscricao.getId())) {
            inscricaoRepository.save(inscricao);
        } else {
            model.addAttribute("error", "Dados incorretos");
        }
        return "redirect:/inscricao";
    }

    @GetMapping(value = "delete/{id}")
    public String getInscricaoDelete(Model model, @PathVariable Long id) {
        model.addAttribute("operacao", "deletar");
        model.addAttribute("title", "Excluir inscrição");
        model.addAttribute("botaoOperacao", "Excluir inscrição");
        model.addAttribute("atletas", atletaRepository.findAll());
        model.addAttribute("percursos", percursoRepository.findAll());
        model.addAttribute("kits", kitRepository.findAll());
        Optional<Inscricao> inscricao = inscricaoRepository.findById(id);
        if (inscricao.isPresent()) {
            model.addAttribute("inscricao", inscricao.get());
        }

        return "inscricao/manter";
    }

    @PostMapping(value = "delete/{id}")
    public String postInscricaoDelete(@PathVariable Long id, @ModelAttribute Inscricao inscricao) {
        inscricaoRepository.delete(inscricao);
        return "redirect:/inscricao";
    }

}