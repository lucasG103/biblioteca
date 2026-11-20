package com.lucas.biblioteca.service;

import com.lucas.biblioteca.model.Autor;
import com.lucas.biblioteca.model.Categoria;
import com.lucas.biblioteca.model.Emprestimo;
import com.lucas.biblioteca.model.Livro;
import com.lucas.biblioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BibliotecaService {

    private final List<Livro> livros = new ArrayList<>();
    private final List<Autor> autores = new ArrayList<>();
    private final List<Categoria> categorias = new ArrayList<>();
    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
