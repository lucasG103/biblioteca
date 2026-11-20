package com.lucas.biblioteca.controller;

import com.lucas.biblioteca.model.Livro;
import com.lucas.biblioteca.service.BibliotecaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final BibliotecaService bibliotecaService;

    public LivroController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("livros", bibliotecaService.getLivros());
        return "livros/lista-livros";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Livro livro) {
        bibliotecaService.getLivros().add(livro);
        return "redirect:/livros";
    }

    @PostMapping("/remover/{indice}")
    public String remover(@PathVariable int indice) {
        if (indice >= 0 && indice < bibliotecaService.getLivros().size()) {
            bibliotecaService.getLivros().remove(indice);
        }

        return "redirect:/livros";
    }
}
