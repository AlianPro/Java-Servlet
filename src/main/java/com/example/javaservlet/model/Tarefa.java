package com.example.javaservlet.model;

public class Tarefa {
    private int id;
    private String descricao;
    private byte finalizado;
    private String dt_finalizado;
    private String dt_criacao;
    private String dt_ult_alt;
    private byte excluido;

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", finalizado=" + finalizado +
                ", dt_finalizado=" + dt_finalizado +
                ", dt_criacao=" + dt_criacao +
                ", dt_ult_alt=" + dt_ult_alt +
                ", excluido=" + excluido +
                '}';
    }

    public Tarefa(int id, String descricao, String dt_finalizado, String dt_criacao, String dt_ult_alt) {
        this.id = id;
        this.descricao = descricao;
        this.dt_finalizado = dt_finalizado;
        this.dt_criacao = dt_criacao;
        this.dt_ult_alt = dt_ult_alt;
    }

    public Tarefa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(byte finalizado) {
        this.finalizado = finalizado;
    }

    public String getDt_finalizado() {
        return dt_finalizado;
    }

    public void setDt_finalizado(String dt_finalizado) {
        this.dt_finalizado = dt_finalizado;
    }

    public String getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(String dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public String getDt_ult_alt() {
        return dt_ult_alt;
    }

    public void setDt_ult_alt(String dt_ult_alt) {
        this.dt_ult_alt = dt_ult_alt;
    }

    public byte getExcluido() {
        return excluido;
    }

    public void setExcluido(byte excluido) {
        this.excluido = excluido;
    }
}
