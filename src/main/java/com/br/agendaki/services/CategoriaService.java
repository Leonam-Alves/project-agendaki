package com.br.agendaki.services;

import com.br.agendaki.dto.CategoriaRequestDTO;
import com.br.agendaki.exception.NomeDuplicadoException;
import com.br.agendaki.models.Categoria;
import com.br.agendaki.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria cadastrar(CategoriaRequestDTO dto) {
        if (repository.findByNomeIgnoreCase(dto.getNome()).isPresent()) {
            throw new NomeDuplicadoException("Já existe uma categoria com esse nome.");
        }
        return repository.save(dto.toEntity());
    }

    public List<Categoria> listarTodos() {
        return repository.findAll();
    }
}
