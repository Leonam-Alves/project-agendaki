package com.br.agendaki.services;

import com.br.agendaki.models.Agendamento;
import com.br.agendaki.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Agendamento agendamento) {
        if (agendamento.getStatus() == null || agendamento.getStatus().isEmpty()) {
            agendamento.setStatus("Pendente");
        }

        if (agendamento.getData() != null && !agendamento.getData().isEmpty()) {
            try {
                LocalDate dataIso = LocalDate.parse(agendamento.getData());
                DateTimeFormatter formatadorBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                agendamento.setData(dataIso.format(formatadorBr));
            } catch (Exception e) {
            }
        }

        repository.save(agendamento);
    }

    public List<Agendamento> listarTodos() {
        return repository.findAll();
    }

    public List<Agendamento> buscarUltimosTres() {
        List<Agendamento> todos = repository.findAll();
        Collections.reverse(todos);
        return todos.stream().limit(3).toList();
    }
}

