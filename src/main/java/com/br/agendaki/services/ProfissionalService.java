package com.br.agendaki.services;

import com.br.agendaki.dto.ProfissionalRequestDTO;
import com.br.agendaki.exception.EntidadeNaoEncontradaException;
import com.br.agendaki.exception.NomeDuplicadoException;
import com.br.agendaki.models.Categoria;
import com.br.agendaki.models.Profissional;
import com.br.agendaki.repository.CategoriaRepository;
import com.br.agendaki.repository.ProfissionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalService {
    private final ProfissionalRepository repository;
    private final CategoriaRepository categoriaRepository;

    public ProfissionalService(ProfissionalRepository repository, CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
    }

    public Profissional cadastrar(ProfissionalRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Categoria não encontrada."));

        if (repository.findByRegistroProfissional(dto.getRegistroProfissional()).isPresent()) {
            throw new NomeDuplicadoException("Já existe um profissional com esse registro profissional (CRM).");
        }

        Profissional profissional = new Profissional();
        profissional.setNome(dto.getNome());
        profissional.setRegistroProfissional(dto.getRegistroProfissional());
        profissional.setTelefone(dto.getTelefone());
        profissional.setCategoria(categoria);

        return repository.save(profissional);
    }

    public List<Profissional> listarTodos() {
        return repository.findAll();
    }
}
