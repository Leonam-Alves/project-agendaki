package com.br.agendaki.dto;

import com.br.agendaki.models.Agendamento;
import com.br.agendaki.models.StatusAgendamento;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendamentoResponseDTO(
        Long id,
        String clienteNome,
        String clienteTelefone,
        String profissionalNome,
        String categoriaNome,
        LocalDate data,
        LocalTime hora,
        StatusAgendamento status,
        String descricao
) {
    public static AgendamentoResponseDTO fromEntity(Agendamento agendamento) {
        return new AgendamentoResponseDTO(
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getCliente().getTelefone(),
                agendamento.getProfissional().getNome(),
                agendamento.getCategoria().getNome(),
                agendamento.getData(),
                agendamento.getHora(),
                agendamento.getStatus(),
                agendamento.getDescricao()
        );
    }
}
