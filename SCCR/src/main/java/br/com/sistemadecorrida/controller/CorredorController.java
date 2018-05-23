package br.com.sistemadecorrida.controller;

import br.com.sistemadecorrida.model.Corredor;
import br.com.sistemadecorrida.repository.CorredorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(value = "/corredor")
public class CorredorController {

    private CorredorRepository corredorRepository;

    @Autowired
    public CorredorController(CorredorRepository corredorRepository) {
        this.corredorRepository = corredorRepository;
    }

    @GetMapping
    // Chamada via get que retorna a view com todos os corredores
    public String corredores(Model model) {
        model.addAttribute("corredores", corredorRepository.findAll());
        return "corredor/corredores";
    }

    @GetMapping(value = "/add")
    // Mostra o form de adicionar
    public String displayCorredorForm() {
        return "corredor/add";
    }

    @PostMapping(value = "/add")
    // Insere o novo corredor no banco e redireciona a tela para '/add'
    // public String processCorredorForm(@RequestBody Corredor corredor -> também funfa)
    public String processCorredorForm(String corredorName, String corredorCpf) {
        Corredor corredor = new Corredor();
        corredor.setNome(corredorName);
        corredor.setCpf(corredorCpf);
        corredor.setNascimento(new Date());
        corredorRepository.save(corredor);
        return "redirect:";
    }

    @GetMapping(value = "/edit")
    // Chamada via get que entrega a view edit
    public String corredorEdit(Model model) {
        model.addAttribute("tittle", "Editar corredor");
        return "corredor/edit";
    }

    public String edit(@PathVariable Long id, @RequestBody Corredor corredor) {
        corredorRepository.findById(id).ifPresent(corredor1 -> corredorRepository.save(corredor1
                .setCpf(corredor.getCpf())
                .set(corredor.getNascimento())
                .setNome(corredor.getNome())
                .setId(id)));
        return "redirect:";
    }

    @GetMapping(value = "/delete") // Entrega a view de delete
    public String corredorDelete(Model model) {
        model.addAttribute("tittle", "Excluir corredor");
        return "corredor/delete";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        corredorRepository.deleteById(id);
        return "redirect:";
    }

}
