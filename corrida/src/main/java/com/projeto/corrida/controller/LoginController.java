package com.projeto.corrida.controller;

import com.projeto.corrida.model.Administrador;
import com.projeto.corrida.model.Atleta;
import com.projeto.corrida.model.Organizador;
import com.projeto.corrida.repository.AdministradorRepository;
import com.projeto.corrida.repository.AtletaRepository;
import com.projeto.corrida.repository.OrganizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;


@Controller
@RequestMapping("/login")
public class LoginController extends HttpServlet {

    @Autowired
    private AdministradorRepository administradorRepository;
    @Autowired
    private AtletaRepository atletaRepository;
    @Autowired
    private OrganizadorRepository organizadorRepository;


    @GetMapping(value = "")
    public String get(Model model) {
        model.addAttribute("msg", "");

        return "login";
    }


    @PostMapping(value = "logar")

    public String postAdd(Model model, @RequestParam String login, @RequestParam String senha) {
        if(atletaRepository.existsAtletaByEmailAndSenha(login,senha)){
            Atleta atleta = atletaRepository.getAtletaByEmail(login);
            HttpSession session = new HttpSession() {
                @Override
                public long getCreationTime() {
                    return 0;
                }

                @Override
                public String getId() {
                    return null;
                }

                @Override
                public long getLastAccessedTime() {
                    return 0;
                }

                @Override
                public ServletContext getServletContext() {
                    return null;
                }

                @Override
                public void setMaxInactiveInterval(int i) {

                }

                @Override
                public int getMaxInactiveInterval() {
                    return 0;
                }

                @Override
                public HttpSessionContext getSessionContext() {
                    return null;
                }

                @Override
                public Object getAttribute(String s) {
                    return null;
                }

                @Override
                public Object getValue(String s) {
                    return null;
                }

                @Override
                public Enumeration<String> getAttributeNames() {
                    return null;
                }

                @Override
                public String[] getValueNames() {
                    return new String[0];
                }

                @Override
                public void setAttribute(String s, Object o) {

                }

                @Override
                public void putValue(String s, Object o) {

                }

                @Override
                public void removeAttribute(String s) {

                }

                @Override
                public void removeValue(String s) {

                }

                @Override
                public void invalidate() {

                }

                @Override
                public boolean isNew() {
                    return false;
                }
            };
            session.setAttribute("tipoLogin", "atleta");
            session.setAttribute("id", atleta.getId());
            return "atleta/atletaHome";
        }
        if(organizadorRepository.existsOrganizadorByEmailAndSenha(login,senha)){
            Organizador organizador = organizadorRepository.getOrganizadorByEmail(login);
            HttpSession session = new HttpSession() {
                @Override
                public long getCreationTime() {
                    return 0;
                }

                @Override
                public String getId() {
                    return null;
                }

                @Override
                public long getLastAccessedTime() {
                    return 0;
                }

                @Override
                public ServletContext getServletContext() {
                    return null;
                }

                @Override
                public void setMaxInactiveInterval(int i) {

                }

                @Override
                public int getMaxInactiveInterval() {
                    return 0;
                }

                @Override
                public HttpSessionContext getSessionContext() {
                    return null;
                }

                @Override
                public Object getAttribute(String s) {
                    return null;
                }

                @Override
                public Object getValue(String s) {
                    return null;
                }

                @Override
                public Enumeration<String> getAttributeNames() {
                    return null;
                }

                @Override
                public String[] getValueNames() {
                    return new String[0];
                }

                @Override
                public void setAttribute(String s, Object o) {

                }

                @Override
                public void putValue(String s, Object o) {

                }

                @Override
                public void removeAttribute(String s) {

                }

                @Override
                public void removeValue(String s) {

                }

                @Override
                public void invalidate() {

                }

                @Override
                public boolean isNew() {
                    return false;
                }
            };
            session.setAttribute("tipoLogin", "organizador");
            session.setAttribute("id", organizador.getId());
            return "organizador/organizadorHome";
        }
        if(administradorRepository.existsAdministradorByEmailAndSenha(login,senha)){
            Administrador administrador = administradorRepository.getAdministradorByEmail(login);
            HttpSession session = new HttpSession() {
                @Override
                public long getCreationTime() {
                    return 0;
                }

                @Override
                public String getId() {
                    return null;
                }

                @Override
                public long getLastAccessedTime() {
                    return 0;
                }

                @Override
                public ServletContext getServletContext() {
                    return null;
                }

                @Override
                public void setMaxInactiveInterval(int i) {

                }

                @Override
                public int getMaxInactiveInterval() {
                    return 0;
                }

                @Override
                public HttpSessionContext getSessionContext() {
                    return null;
                }

                @Override
                public Object getAttribute(String s) {
                    return null;
                }

                @Override
                public Object getValue(String s) {
                    return null;
                }

                @Override
                public Enumeration<String> getAttributeNames() {
                    return null;
                }

                @Override
                public String[] getValueNames() {
                    return new String[0];
                }

                @Override
                public void setAttribute(String s, Object o) {

                }

                @Override
                public void putValue(String s, Object o) {

                }

                @Override
                public void removeAttribute(String s) {

                }

                @Override
                public void removeValue(String s) {

                }

                @Override
                public void invalidate() {

                }

                @Override
                public boolean isNew() {
                    return false;
                }
            };
            session.setAttribute("tipoLogin", "administrador");
            session.setAttribute("id", administrador.getId());
            session.setAttribute("nome", administrador.getNome());

            return "admin/administradorHome";
        }
        else {
            model.addAttribute("msg", "Erro inesperado!");
            return "login";
        }
    }

    @GetMapping(value = "/logout")
    public String getLogout(Model model, HttpSession session) {
        model.addAttribute("msg", "");
        session.invalidate();
        return "redirect:/";
    }


}



