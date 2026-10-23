package com.br.agendaki.dto;

import com.br.agendaki.models.Categoria;

public record CategoriaResponseDTO(Long id, String nome, String descricao) {
    public static CategoriaResponseDTO fromEntity(Categoria categoria) {
        return new CategoriaResponseDTO(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }
}
