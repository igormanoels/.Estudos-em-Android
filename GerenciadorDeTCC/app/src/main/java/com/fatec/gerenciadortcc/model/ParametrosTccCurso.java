package com.fatec.gerenciadortcc.model;

public class ParametrosTccCurso {
    private TipoTcc tipoTcc;
    private Integer maxAlunos;

    public ParametrosTccCurso(TipoTcc tipoTcc, Integer maxAlunos) {
        this.tipoTcc = tipoTcc;
        this.maxAlunos = maxAlunos;
    }

    // Getters and Setters
    public TipoTcc getTipoTcc() {
        return tipoTcc;
    }

    public void setTipoTcc(TipoTcc tipoTcc) {
        this.tipoTcc = tipoTcc;
    }

    public Integer getMaxAlunos() {
        return maxAlunos;
    }

    public void setMaxAlunos(Integer maxAlunos) {
        this.maxAlunos = maxAlunos;
    }
}