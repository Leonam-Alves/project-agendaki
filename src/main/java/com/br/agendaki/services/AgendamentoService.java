package com.br.agendaki.services;

import com.br.agendaki.dto.AgendamentoRequestDTO;
import com.br.agendaki.exception.AgendamentoConflitanteException;
import com.br.agendaki.exception.EntidadeNaoEncontradaException;
import com.br.agendaki.models.Agendamento;
import com.br.agendaki.models.Categoria;
import com.br.agendaki.models.Cliente;
import com.br.agendaki.models.Profissional;
import com.br.agendaki.models.StatusAgendamento;
import com.br.agendaki.repository.AgendamentoRepository;
import com.br.agendaki.repository.CategoriaRepository;
import com.br.agendaki.repository.ClienteRepository;
import com.br.agendaki.repository.ProfissionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final ClienteRepository clienteRepository;
    private final ProfissionalRepository profissionalRepository;
    private final CategoriaRepository categoriaRepository;

    public AgendamentoService(
            AgendamentoRepository repository,
            ClienteRepository clienteRepository,
            ProfissionalRepository profissionalRepository,
            CategoriaRepository categoriaRepository
    ) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.profissionalRepository = profissionalRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Agendamento cadastrar(AgendamentoRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente não encontrado."));
        Profissional profissional = profissionalRepository.findById(dto.getProfissionalId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Profissional não encontrado."));
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Categoria não encontrada."));

        boolean conflito = repository
                .findByProfissionalIdAndDataAndHora(profissional.getId(), dto.getData(), dto.getHora())
                .isPresent();
        if (conflito) {
            throw new AgendamentoConflitanteException("Este profissional já possui um agendamento nesse horário.");
        }

        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setProfissional(profissional);
        agendamento.setCategoria(categoria);
        agendamento.setData(dto.getData());
        agendamento.setHora(dto.getHora());
        agendamento.setDescricao(dto.getDescricao());
        agendamento.setStatus(StatusAgendamento.PENDENTE);

        return repository.save(agendamento);
    }

    public List<Agendamento> listarTodos() {
        return repository.findAll();
    }

    public List<Agendamento> buscarUltimosTres() {
        return repository.findTop3ByOrderByIdDesc();
    }
}
