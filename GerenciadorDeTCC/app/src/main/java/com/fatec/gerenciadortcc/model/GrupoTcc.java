package com.fatec.gerenciadortcc.model;

import java.util.List;

public class GrupoTcc {
    private Professor orientador;
    private Coorientador coorientador;
    private String tema;
    private TipoTcc tipoTcc;
    private Disciplina disciplina;
    private List<Aluno> alunos;
    private Turma turma;

    public GrupoTcc(Professor orientador, Coorientador coorientador, String tema, TipoTcc tipoTcc, Disciplina disciplina, List<Aluno> alunos, Turma turma) {
        this.orientador = orientador;
        this.coorientador = coorientador;
        this.tema = tema;
        this.tipoTcc = tipoTcc;
        this.disciplina = disciplina;
        this.alunos = alunos;
        this.turma = turma;
    }

    // Getters and Setters

    public Professor getOrientador() {
        return orientador;
    }

    public void setOrientador(Professor orientador) {
        this.orientador = orientador;
    }

    public Coorientador getCoorientador() {
        return coorientador;
    }

    public void setCoorientador(Coorientador coorientador) {
        this.coorientador = coorientador;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public TipoTcc getTipoTcc() {
        return tipoTcc;
    }

    public void setTipoTcc(TipoTcc tipoTcc) {
        this.tipoTcc = tipoTcc;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}