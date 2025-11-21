package com.fatec.gerenciadortcc.model;

public class Coorientador {
    private String nome;
    private String origem;

    public Coorientador(String nome, String origem) {
        this.nome = nome;
        this.origem = origem;
    }

    // Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
}