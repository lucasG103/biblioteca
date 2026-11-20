package com.lucas.biblioteca.controller;

import com.lucas.biblioteca.model.Usuario;
import com.lucas.biblioteca.service.BibliotecaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final BibliotecaService bibliotecaService;

    public UsuarioController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("usuarios", bibliotecaService.getUsuarios());
        return "usuarios/lista-usuarios";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Usuario usuario) {
        bibliotecaService.getUsuarios().add(usuario);
        return "redirect:/usuarios";
    }

    @PostMapping("/remover/{indice}")
    public String remover(@PathVariable int indice) {
        if (indice >= 0 && indice < bibliotecaService.getUsuarios().size()) {
            bibliotecaService.getUsuarios().remove(indice);
        }

        return "redirect:/usuarios";
    }
}
