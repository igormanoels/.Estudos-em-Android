package com.fatec.gerenciadortcc.model;

public class Orientador {
    private String nome;
    private String origem;
    private CargoProfessor cargoProfessor;

    public Orientador(String nome, String origem, CargoProfessor cargoProfessor) {
        this.nome = nome;
        this.origem = origem;
        this.cargoProfessor = cargoProfessor;
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

    public CargoProfessor getCargoProfessor() {
        return cargoProfessor;
    }

    public void setCargoProfessor(CargoProfessor cargoProfessor) {
        this.cargoProfessor = cargoProfessor;
    }
}