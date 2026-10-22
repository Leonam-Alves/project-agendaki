package com.br.agendaki.dto;

import com.br.agendaki.models.Cliente;

public record ClienteResponseDTO(Long id, String nome, String telefone, String email) {
    public static ClienteResponseDTO fromEntity(Cliente cliente) {
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getTelefone(), cliente.getEmail());
    }
}
