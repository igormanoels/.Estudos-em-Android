package com.fatec.gerenciadortcc.model;

public class Curso {
    private String nome;
    private ParametrosCurso parametros;
    private Professor coordenador;

    public Curso(String nome, ParametrosCurso parametros, Professor coordenador) {
        this.nome = nome;
        this.parametros = parametros;
        this.coordenador = coordenador;
    }

    // Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ParametrosCurso getParametros() {
        return parametros;
    }

    public void setParametros(ParametrosCurso parametros) {
        this.parametros = parametros;
    }

    public Professor getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Professor coordenador) {
        this.coordenador = coordenador;
    }
}