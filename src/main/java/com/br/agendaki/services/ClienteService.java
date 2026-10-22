package com.br.agendaki.services;

import com.br.agendaki.dto.ClienteRequestDTO;
import com.br.agendaki.models.Cliente;
import com.br.agendaki.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente cadastrar(ClienteRequestDTO dto) {
        return repository.save(dto.toEntity());
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }
}
