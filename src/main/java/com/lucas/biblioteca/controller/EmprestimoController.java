package com.lucas.biblioteca.controller;

import com.lucas.biblioteca.model.Emprestimo;
import com.lucas.biblioteca.service.BibliotecaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final BibliotecaService bibliotecaService;

    public EmprestimoController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("emprestimos", bibliotecaService.getEmprestimos());
        model.addAttribute("livros", bibliotecaService.getLivros());
        model.addAttribute("usuarios", bibliotecaService.getUsuarios());

        return "emprestimos/lista-emprestimos";
    }

    @PostMapping
    public String cadastrar(
            @RequestParam int livroIndice,
            @RequestParam int usuarioIndice,
            @RequestParam LocalDate dataRetirada,
            @RequestParam LocalDate dataDevolucao,
            @RequestParam String status) {

        if (livroIndice < 0 || livroIndice >= bibliotecaService.getLivros().size()
                || usuarioIndice < 0 || usuarioIndice >= bibliotecaService.getUsuarios().size()) {
            return "redirect:/emprestimos";
        }

        if (dataDevolucao.isBefore(dataRetirada)) {
            return "redirect:/emprestimos";
        }

        if (!status.equals("Em andamento")
                && !status.equals("Devolvido")
                && !status.equals("Atrasado")) {
            return "redirect:/emprestimos";
        }

        Emprestimo emprestimo = new Emprestimo();

        emprestimo.setLivro(bibliotecaService.getLivros().get(livroIndice));
        emprestimo.setUsuario(bibliotecaService.getUsuarios().get(usuarioIndice));
        emprestimo.setDataRetirada(dataRetirada);
        emprestimo.setDataDevolucao(dataDevolucao);
        emprestimo.setStatus(status);

        bibliotecaService.getEmprestimos().add(emprestimo);

        return "redirect:/emprestimos";
    }

    @PostMapping("/remover/{indice}")
    public String remover(@PathVariable int indice) {
        if (indice >= 0 && indice < bibliotecaService.getEmprestimos().size()) {
            bibliotecaService.getEmprestimos().remove(indice);
        }

        return "redirect:/emprestimos";
    }
}
