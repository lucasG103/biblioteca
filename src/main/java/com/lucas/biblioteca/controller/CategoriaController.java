package com.lucas.biblioteca.controller;

import com.lucas.biblioteca.model.Categoria;
import com.lucas.biblioteca.service.BibliotecaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final BibliotecaService bibliotecaService;

    public CategoriaController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("categorias", bibliotecaService.getCategorias());
        return "categorias/lista-categorias";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Categoria categoria) {
        bibliotecaService.getCategorias().add(categoria);
        return "redirect:/categorias";
    }

    @PostMapping("/remover/{indice}")
    public String remover(@PathVariable int indice) {
        if (indice >= 0 && indice < bibliotecaService.getCategorias().size()) {
            bibliotecaService.getCategorias().remove(indice);
        }

        return "redirect:/categorias";
    }
}
