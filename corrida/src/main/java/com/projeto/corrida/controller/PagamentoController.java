package com.projeto.corrida.controller;

import com.projeto.corrida.model.Pagamento;
import com.projeto.corrida.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Optional;

public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;


    @GetMapping(value = "listar")
    public String listaPagamento(Model model) {
        model.addAttribute("percursos", pagamentoRepository.findAll());
        model.addAttribute("operacao", "listar");
        model.addAttribute("title", "Lista de pagamentos");
        model.addAttribute("botaoOperacao", "Adicionar pagamento");

        return "pagamento/pesquisaPagamento";
    }

    @GetMapping(value = "add")
    public String displayCorredorForm(Model model) {
        model.addAttribute("title", "Adicionar pagamento");
        model.addAttribute("operacao", "adicionar");
        model.addAttribute("botaoOperacao", "Adicionar pagamento");
        return "pagamento/manterPagamento";
    }

    @PostMapping(value = "add")
    public String processPagamentoForm(@ModelAttribute Pagamento pagamento) {
        pagamentoRepository.save(pagamento);
        return "redirect:/pagamento/listar"; // url para qual página quero voltar.
    }

    @GetMapping(value = "edit/{id}") // site.com/corredor/edit
    public String pagamentoEdit(Model model, @PathVariable Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        model.addAttribute("operacao", "editar");
        model.addAttribute("botaoOperacao", "Editar Kit");
        model.addAttribute("title", "Editar Kit");

        model.addAttribute("pagamentos",pagamentoRepository.findAll());

        if (pagamento.isPresent()){
            model.addAttribute("pagamento", pagamento.get());
        }
        model.addAttribute("title", "Editar pagamento");
        return "pagamento/manterPagamento";
    }

    @PostMapping(value = "edit/{id}") // site.com/corredor/edit/1/
    public String edit(@ModelAttribute Pagamento pagamento, Model model,
                       @PathVariable Long id) throws Exception {
        if (id.equals(pagamento.getId())) {
            pagamentoRepository.save(pagamento);
        } else {
            model.addAttribute("error", "Dados incorretos");
        }
        return "redirect:/pagamento/listar";
    }

    @GetMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String administradorDelete(Model model, @PathVariable Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);

        model.addAttribute("operacao", "deletar");
        model.addAttribute("botaoOperacao", "Excluir pagamento");
        model.addAttribute("title", "Excluir pagamento");
        if (pagamento.isPresent()) {
            model.addAttribute("pagamentoS", pagamento.get());
        }
        model.addAttribute("tittle", "Excluir pagamento");
        return "pagamento/manterPagamento";
    }

    @PostMapping(value = "delete/{id}") // site.com/corredor/delete/1
    public String delete(@PathVariable Long id, @ModelAttribute Pagamento pagamento) {
        pagamentoRepository.delete(pagamento);
        return "redirect:/pagamento/listar";
    }

}
