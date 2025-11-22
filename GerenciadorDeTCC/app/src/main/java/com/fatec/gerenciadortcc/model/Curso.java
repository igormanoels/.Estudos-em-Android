package com.fatec.gerenciadortcc.model;

import java.util.List;

public class Curso {
    private String nome;
    private Professor coordenador;
    private List<Turno> turnos;
    private List<Disciplina> disciplinas;
    private List<ParametrosTccCurso> parametrosTcc;

    public Curso(String nome, Professor coordenador, List<Turno> turnos, List<Disciplina> disciplinas, List<ParametrosTccCurso> parametrosTcc) {
        this.nome = nome;
        this.coordenador = coordenador;
        this.turnos = turnos;
        this.disciplinas = disciplinas;
        this.parametrosTcc = parametrosTcc;
    }

    // Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Professor coordenador) {
        this.coordenador = coordenador;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<ParametrosTccCurso> getParametrosTcc() {
        return parametrosTcc;
    }

    public void setParametrosTcc(List<ParametrosTccCurso> parametrosTcc) {
        this.parametrosTcc = parametrosTcc;
    }
}