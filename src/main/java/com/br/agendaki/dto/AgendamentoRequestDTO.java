package com.br.agendaki.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoRequestDTO {
    @NotNull(message = "O cliente é obrigatório.")
    private Long clienteId;

    @NotNull(message = "O profissional é obrigatório.")
    private Long profissionalId;

    @NotNull(message = "A categoria é obrigatória.")
    private Long categoriaId;

    @NotNull(message = "A data é obrigatória.")
    @FutureOrPresent(message = "A data deve ser hoje ou uma data futura.")
    private LocalDate data;

    @NotNull(message = "O horário é obrigatório.")
    private LocalTime hora;

    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres.")
    private String descricao;

    public AgendamentoRequestDTO() {
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
