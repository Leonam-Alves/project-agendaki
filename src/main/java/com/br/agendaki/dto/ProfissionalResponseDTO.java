package com.br.agendaki.dto;

import com.br.agendaki.models.Profissional;

public record ProfissionalResponseDTO(
        Long id,
        String nome,
        String registroProfissional,
        String telefone,
        String categoriaNome
) {
    public static ProfissionalResponseDTO fromEntity(Profissional profissional) {
        return new ProfissionalResponseDTO(
                profissional.getId(),
                profissional.getNome(),
                profissional.getRegistroProfissional(),
                profissional.getTelefone(),
                profissional.getCategoria().getNome()
        );
    }
}
