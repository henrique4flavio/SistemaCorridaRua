package br.com.sistemadecorrida.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InscricaoController {

    @RequestMapping(value ="inscricao")
    public String inscricao(){
        return "inscricao";
    }
}
