package com.fatec.gerenciadortcc.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private String matricula;
    private ContaUsuario contaUsuario;
    private StatusAluno status;
    private List<Turma> turmas = new ArrayList<>();

    public Aluno(String nome, String matricula, ContaUsuario contaUsuario, StatusAluno status) {
        this.nome = nome;
        this.matricula = matricula;
        this.contaUsuario = contaUsuario;
        this.status = status;
    }

    // Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public ContaUsuario getContaUsuario() {
        return contaUsuario;
    }

    public void setContaUsuario(ContaUsuario contaUsuario) {
        this.contaUsuario = contaUsuario;
    }

    public StatusAluno getStatus() {
        return status;
    }

    public void setStatus(StatusAluno status) {
        this.status = status;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}