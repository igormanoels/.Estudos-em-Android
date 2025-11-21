package com.fatec.gerenciadortcc.model;

public class ParametrosCurso {
    private int cargaHoraria;
    private int minimoSemestres;
    private int maximoSemestres;

    public ParametrosCurso(int cargaHoraria, int minimoSemestres, int maximoSemestres) {
        this.cargaHoraria = cargaHoraria;
        this.minimoSemestres = minimoSemestres;
        this.maximoSemestres = maximoSemestres;
    }

    // Getters and Setters

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getMinimoSemestres() {
        return minimoSemestres;
    }

    public void setMinimoSemestres(int minimoSemestres) {
        this.minimoSemestres = minimoSemestres;
    }

    public int getMaximoSemestres() {
        return maximoSemestres;
    }

    public void setMaximoSemestres(int maximoSemestres) {
        this.maximoSemestres = maximoSemestres;
    }
}