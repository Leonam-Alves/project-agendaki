package com.br.agendaki.models;

public class Agendamento {
    private Long id;
    private String nome;
    private String data;
    private String hora;
    private String status;
    private String telefone;
    private String descricao;

    public Agendamento() {
    }

    public Agendamento(Long id, String nome, String data, String hora, String status) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.status = status;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
