package com.lucas.biblioteca.controller;

import com.lucas.biblioteca.model.Autor;
import com.lucas.biblioteca.service.BibliotecaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autores")
public class AutorController {

    private final BibliotecaService bibliotecaService;

    public AutorController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("autores", bibliotecaService.getAutores());
        return "autores/lista-autores";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Autor autor) {
        bibliotecaService.getAutores().add(autor);
        return "redirect:/autores";
    }

    @PostMapping("/remover/{indice}")
    public String remover(@PathVariable int indice) {
        if (indice >= 0 && indice < bibliotecaService.getAutores().size()) {
            bibliotecaService.getAutores().remove(indice);
        }

        return "redirect:/autores";
    }
}
