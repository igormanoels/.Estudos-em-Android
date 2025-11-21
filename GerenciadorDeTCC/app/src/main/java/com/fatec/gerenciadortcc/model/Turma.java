package com.fatec.gerenciadortcc.model;

public class Turma {
    private Curso curso;
    private Disciplina disciplina;
    private Turno turno;
    private Professor professorTg;
    private Integer ano;
    private Integer semestre;

    public Turma(Curso curso, Disciplina disciplina, Turno turno, Professor professorTg, Integer ano, Integer semestre) {
        this.curso = curso;
        this.disciplina = disciplina;
        this.turno = turno;
        this.professorTg = professorTg;
        this.ano = ano;
        this.semestre = semestre;
    }

    // Getters and Setters

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Professor getProfessorTg() {
        return professorTg;
    }

    public void setProfessorTg(Professor professorTg) {
        this.professorTg = professorTg;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }
}