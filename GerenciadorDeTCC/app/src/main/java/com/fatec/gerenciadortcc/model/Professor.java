package com.fatec.gerenciadortcc.model;

public class Professor {
    private String nome;
    private String matricula;
    private ContaUsuario contaUsuario;
    private CargoProfessor cargo;

    public Professor(String nome, String matricula, ContaUsuario contaUsuario, CargoProfessor cargo) {
        this.nome = nome;
        this.matricula = matricula;
        this.contaUsuario = contaUsuario;
        this.cargo = cargo;
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

    public CargoProfessor getCargo() {
        return cargo;
    }

    public void setCargo(CargoProfessor cargo) {
        this.cargo = cargo;
    }
}