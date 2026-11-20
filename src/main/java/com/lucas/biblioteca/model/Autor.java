package com.lucas.biblioteca.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Autor {

    private String nome;
    private String nacionalidade;
    private LocalDate dataNascimento;
    private List<Livro> obras = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Livro> getObras() {
        return obras;
    }

    public void setObras(List<Livro> obras) {
        this.obras = obras;
    }
}
